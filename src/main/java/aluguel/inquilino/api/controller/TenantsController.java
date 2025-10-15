//package aluguel.inquilino.api.controller;
//
//import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
//import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
//import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
//import aluguel.inquilino.api.service.TenantsService;
//import jakarta.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/tenants")
//@CrossOrigin(origins = "http://localhost:5173")
//public class TenantsController {
//
//    @Autowired
//    private TenantsService tenantsService;
//
//    @PostMapping
//    public ResponseEntity<?> saveTenants(@RequestBody @Valid TenantDataRegistrationDTO data){
//        tenantsService.createTenants(data);
//        return ResponseEntity.ok("registered successfully");
//    }
//
//    @GetMapping
//    public ResponseEntity <List<TenantListingDataDTO>>listTenants(){
//        List<TenantListingDataDTO> tenants = tenantsService.getAllTenants();
//        return ResponseEntity.ok(tenants);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteTenants(@PathVariable Long id){
//        tenantsService.deleteTenants(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping
//    public ResponseEntity<?> updateTenants(@RequestBody @Valid UpdateTenantsDTO dados) {
//        var tenants = tenantsService.putTenants(dados);
//        return ResponseEntity.ok(tenants);
//    }
//
//
//}
