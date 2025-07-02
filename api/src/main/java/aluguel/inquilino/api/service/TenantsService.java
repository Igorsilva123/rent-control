package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
import aluguel.inquilino.api.Mappers.TenantMapper;
import aluguel.inquilino.api.domain.tenants.Tenant;
import aluguel.inquilino.api.repository.TenantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TenantsService {

    @Autowired
    private TenantsRepository repository;

    @Autowired
    private TenantMapper tenantMapper;

    @Transactional
    public void createTenants(TenantDataRegistrationDTO data){
        Tenant tenants = tenantMapper.toEntity(data);
        repository.save(tenants);
    }

    public List<TenantListingDataDTO> getAllTenants(){
        return repository.findAll().stream()
                .map(tenantMapper::toDTO)
                .toList();
    }

    @Transactional
    public void deleteTenants(Long id){
        repository.deleteById(id);
    }

    @Transactional
    public Tenant putTenants(UpdateTenantsDTO dados){
        var tenants = repository.getReferenceById(dados.id_tenants());
        tenants.updateTenants(dados);

        return tenants;
    }
}
