package aluguel.inquilino.api.Service;


import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.owner.Owner;
import aluguel.inquilino.api.domain.tenants.Tenants;
import aluguel.inquilino.api.repository.HouseRepository;
import aluguel.inquilino.api.repository.OwnerRepository;
import aluguel.inquilino.api.repository.TenantsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepository repository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TenantsRepository tenantsRepository;

    @Transactional
    public House saveHouse(HouseDataRegistrationDTO data) {
        Owner owner = ownerRepository.getReferenceById(data.owner_id());
        Tenants tenant = tenantsRepository.getReferenceById(data.tenant_id());

        if(repository.existsByTenant(tenant)){
            throw new IllegalArgumentException("Esse inquilino já está alugando uma casa.");
        }

        House house = new House(data);
        house.setOwner(owner);
        house.setTenant(tenant);


        return repository.save(house);
    }
    public List<HouseListingDataDTO>getAllHouse() {
        var house = repository.findAll().stream()
                .map(HouseListingDataDTO::new)
                .toList();
        return house;

    }

    @Transactional
    public void deleteById(Long id_house) {
        repository.deleteById(id_house);
    }

    @Transactional
    public House putHouse(UpdateHouse dados){
        var newHouse = repository.getReferenceById(dados.id_house());
        newHouse.updateHouse(dados);
        return newHouse;
    }

}
