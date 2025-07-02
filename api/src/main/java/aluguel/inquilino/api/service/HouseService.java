package aluguel.inquilino.api.service;


import aluguel.inquilino.api.DTO.house.*;
import aluguel.inquilino.api.Mappers.HouseMapper;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.owner.Owner;
import aluguel.inquilino.api.domain.tenants.Tenant;
import aluguel.inquilino.api.exception.BusinessRuleException;
import aluguel.inquilino.api.exception.ResourceNotFoundException;
import aluguel.inquilino.api.repository.HouseRepository;
import aluguel.inquilino.api.repository.OwnerRepository;
import aluguel.inquilino.api.repository.TenantsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepository repository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TenantsRepository tenantsRepository;

    @Autowired
    private HouseMapper houseMapper;

    @Transactional
    public void saveHouse(HouseDataRegistrationDTO data) {
        Owner owner = ownerRepository.findById(data.owner_id())
                .orElseThrow(() -> new ResourceNotFoundException("Proprietário com ID " + data.owner_id() + " não encontrado."));

        House house = houseMapper.toEntity(data, owner);

        repository.save(house);
    }

    public List<HouseListingDataDTO>getAllHouse() {
        return repository.findAll().stream()
                .map(houseMapper::toDTO)
                .toList();

    }

    @Transactional
    public HouseListingDataDTO assignTenantToHouse(@Valid AssignTenantDTO dto) {
        House house = repository.findById(dto.houseId())
                .orElseThrow(() -> new ResourceNotFoundException("Casa com ID " + dto.houseId() + " não encontrada."));

        Tenant tenant = tenantsRepository.findById(dto.tenantId())
                .orElseThrow(() -> new ResourceNotFoundException("Inquilino com ID " + dto.tenantId() + " não encontrado."));

        if (repository.existsByTenant(tenant)) {
            throw new BusinessRuleException("Inquilino com ID " + tenant.getId_tenants() + " já está associado a uma casa.");
        }
        house.setTenant(tenant);
        tenant.setHouse(house);
        tenant.setRentedAt(LocalDate.now());

        House putHouse = repository.save(house);

        return houseMapper.toDTO(putHouse);
    }


    @Transactional
    public void deleteById(Long id_house) {
        repository.deleteById(id_house);
    }

    @Transactional
    public HouseListingDataDTO putHouse(UpdateHouse dados){
        var newHouse = repository.findById(dados.id_house()).orElseThrow(() -> new ResourceNotFoundException("esse id não e valido!") );
        houseMapper.updateEntity(dados, newHouse);
        House saveHouse = repository.save(newHouse);
        return houseMapper.toDTO(saveHouse);
    }

    public House removeTenantFromHouse(RemoveTenantDTO dto) {
        House house = repository.findById(dto.houseId())
                .orElseThrow(() -> new ResourceNotFoundException("Casa com ID" +  dto.houseId() + "não encontrada. ")
                );
        if (house.getTenant() == null) {
            throw new ResourceNotFoundException("A casa com ID " + dto.houseId() + "não possui inquilino associado." );
        }
        house.setTenant(null);

        return repository.save(house);
    }

}
