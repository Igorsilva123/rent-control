package aluguel.inquilino.api.controller;


import aluguel.inquilino.api.DTO.house.*;
import aluguel.inquilino.api.service.HouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;
    @PostMapping
    public ResponseEntity<?> saveHouse(@RequestBody @Valid HouseDataRegistrationDTO data){
        houseService.saveHouse(data);

        return ResponseEntity.ok("usuario registrado");

    }

    @GetMapping
    public ResponseEntity <List<HouseListingDataDTO>> ListHouse(){
        List<HouseListingDataDTO> house = houseService.getAllHouse();

        return ResponseEntity.ok(house);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHouse(@PathVariable Long id_house){
        houseService.deleteById(id_house);
        return ResponseEntity.noContent().build();

    }

    @PutMapping
    public ResponseEntity<HouseListingDataDTO> putHouse(@RequestBody @Valid UpdateHouse dados){
        HouseListingDataDTO newHouse = houseService.putHouse(dados);
        return ResponseEntity.ok(newHouse);
    }

    @PutMapping("/assign-tenant")
    public ResponseEntity<HouseListingDataDTO> assignTenant(@RequestBody @Valid AssignTenantDTO data) {
        HouseListingDataDTO updateHouse = houseService.assignTenantToHouse(data);
        return ResponseEntity.ok(updateHouse);
    }

    @PutMapping("/remove-tenant")
    public ResponseEntity<?> removeTenant(@RequestBody @Valid RemoveTenantDTO dto) {
        var updatedHouse = houseService.removeTenantFromHouse(dto);
        return ResponseEntity.ok().build();
    }

}
