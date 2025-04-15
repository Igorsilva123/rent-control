package aluguel.inquilino.api.Service;

import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
import aluguel.inquilino.api.domain.tenants.Tenants;
import aluguel.inquilino.api.repository.TenantsRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TenantsService {

    @Autowired
    private TenantsRepository repository;

    @Transactional
    public void createTenants(TenantDataRegistrationDTO data){
        var tenants = new Tenants(data);
        repository.save(tenants);
    }

    public List<TenantListingDataDTO> getAllTenants(){
        var tenants = repository.findAll().stream()
                .map(TenantListingDataDTO::new)
                .toList();
        return tenants;
    }

    @Transactional
    public void deleteTenants(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Tenants putTenants(UpdateTenantsDTO dados){
        var tenants = repository.getReferenceById(dados.id_tenants());
        tenants.updateTenants(dados);

        return tenants;
    }
}
