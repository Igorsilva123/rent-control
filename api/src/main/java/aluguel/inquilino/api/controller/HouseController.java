package aluguel.inquilino.api.controller;


import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.Service.HouseService;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.repository.HouseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @PostMapping
    public ResponseEntity saveHouse(@RequestBody @Valid HouseDataRegistrationDTO data){
        var house = houseService.saveHouse(data);

        return ResponseEntity.ok("usuario registrado");

    }

    @GetMapping
    public ResponseEntity <List<HouseListingDataDTO>> ListHouse(){
        var house = houseService.getAllHouse();

        return ResponseEntity.ok(house);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteHouse(@PathVariable Long id_house){
        houseService.deleteById(id_house);
        return ResponseEntity.noContent().build();

    }

    @PutMapping
    public ResponseEntity putHouse(@RequestBody @Valid UpdateHouse dados){
        var newHouse = houseService.putHouse(dados);
        return ResponseEntity.ok(new HouseListingDataDTO(newHouse));
    }

}
