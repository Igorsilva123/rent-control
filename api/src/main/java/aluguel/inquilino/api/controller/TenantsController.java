package aluguel.inquilino.api.controller;

import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
import aluguel.inquilino.api.Service.TenantsService;
import aluguel.inquilino.api.domain.tenants.Tenants;
import aluguel.inquilino.api.repository.TenantsRepository;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
@CrossOrigin(origins = "http://localhost:5173")
public class TenantsController {

    @Autowired
    private TenantsService tenantsService;

    @PostMapping
    public ResponseEntity saveTenants(@RequestBody @Valid TenantDataRegistrationDTO data){
        tenantsService.createTenants(data);
        return ResponseEntity.ok("registered successfully");
    }

    @GetMapping
    public ResponseEntity <List<TenantListingDataDTO>>listTenants(){
        var tenants = tenantsService.getAllTenants();
        return ResponseEntity.ok(tenants);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTenants(@PathVariable Long id){
        tenantsService.deleteTenants(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity updateTenants(@RequestBody @Valid UpdateTenantsDTO dados) {
        var tenants = tenantsService.putTenants(dados);
        return ResponseEntity.ok(new TenantListingDataDTO(tenants));
    }


}
