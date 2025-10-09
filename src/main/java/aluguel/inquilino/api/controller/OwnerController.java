package aluguel.inquilino.api.controller;
import aluguel.inquilino.api.DTO.owner.DataListingOwnerDTO;
import aluguel.inquilino.api.DTO.owner.HouseListingByOwnerDTO;
import aluguel.inquilino.api.DTO.owner.OwnerDataRegistrationDTO;
import aluguel.inquilino.api.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public ResponseEntity<?> saveOwner(@RequestBody @Valid OwnerDataRegistrationDTO dados){
        ownerService.createOwner(dados);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/houses")
    public ResponseEntity<List<HouseListingByOwnerDTO>> ListHouseByOwner(@PathVariable Long id){
        var owners = ownerService.ListHouseByOwner(id);
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/listowner")
    public ResponseEntity<List<DataListingOwnerDTO>> listOwner(){
        var owners = ownerService.listOwner();
        return ResponseEntity.ok(owners);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long id_owners){
        ownerService.deleteById(id_owners);
        return ResponseEntity.noContent().build();
    }

}
