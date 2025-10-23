package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.house.*;
import aluguel.inquilino.api.Mappers.HouseMapper;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.user.User;
import aluguel.inquilino.api.exception.BusinessRuleException;
import aluguel.inquilino.api.exception.ResourceNotFoundException;
import aluguel.inquilino.api.repository.HouseRepository;
import aluguel.inquilino.api.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HouseMapper houseMapper;

    @Transactional
    public void saveHouse(HouseDataRegistrationDTO data) {
        User user = userRepository.findById(data.user_id())
                .orElseThrow(() -> new ResourceNotFoundException("Proprietário com ID " + data.user_id() + " não encontrado."));

        House house = houseMapper.toEntity(data, user);

        repository.save(house);
    }

    public List<HouseListingDataDTO>getAllHouse() {
        return repository.findAll().stream()
                .map(houseMapper::toDTO)
                .toList();

    }

    @Transactional
    public HouseListingDataDTO assignTenantToHouse(Long houseId, Long userId) {
        House house = repository.findById(houseId)
                .orElseThrow(() -> new ResourceNotFoundException("Casa com ID " + houseId + " não encontrada."));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Inquilino com ID " + userId + " não encontrado."));

        if (repository.existsByUser(user)) {
            throw new BusinessRuleException("Inquilino com ID " + user.getId() + " já está associado a uma casa.");
        }
        house.setUser(user);
        user.getHouses().add(house);
        user.setRentedAt(LocalDate.now());

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
        if (house.getUser() == null) {
            throw new ResourceNotFoundException("A casa com ID " + dto.houseId() + "não possui inquilino associado." );
        }
        house.setUser(null);

        return repository.save(house);
    }

}
