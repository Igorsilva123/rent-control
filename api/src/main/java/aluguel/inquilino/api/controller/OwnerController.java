package aluguel.inquilino.api.controller;

import aluguel.inquilino.api.DTO.owner.DataListingOwnerDTO;
import aluguel.inquilino.api.DTO.owner.OwnerDataRegistrationDTO;
import aluguel.inquilino.api.DTO.owner.UpdateOwnerDTO;
import aluguel.inquilino.api.Service.OwnerService;
import aluguel.inquilino.api.domain.owner.Owner;
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
    public ResponseEntity saveOwner(@RequestBody @Valid OwnerDataRegistrationDTO dados){
        ownerService.createOwner(dados);
        return ResponseEntity.ok("Owner registered successfully");
    }

    @GetMapping
    public ResponseEntity<List<DataListingOwnerDTO>> getAllOwners(){
        var owners = ownerService.getAll();
        return ResponseEntity.ok(owners);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOwner(@PathVariable Long id_owners){
        ownerService.deleteById(id_owners);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity updateOwner(@RequestBody @Valid UpdateOwnerDTO dados){
        var newOwner = ownerService.putOwner(dados);
        return ResponseEntity.ok(new DataListingOwnerDTO(newOwner));
    }
}
