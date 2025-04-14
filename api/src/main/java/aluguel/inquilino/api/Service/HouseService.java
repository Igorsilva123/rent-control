package aluguel.inquilino.api.Service;


import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.repository.HouseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class HouseService {

    @Autowired
    private HouseRepository repository;

    @Transactional
    public void createHouse(HouseDataRegistrationDTO data){
        var house = new House(data);
        repository.save(house);
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
