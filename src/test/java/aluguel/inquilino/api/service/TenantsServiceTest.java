package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
import aluguel.inquilino.api.Mappers.TenantMapper;
import aluguel.inquilino.api.domain.tenants.Tenant;
import aluguel.inquilino.api.repository.TenantsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TenantsServiceTest {

    @InjectMocks
    private TenantsService tenantsService;

    @Mock
    private TenantsRepository tenantsRepository;

    @Mock
    private TenantMapper tenantMapper;

    @Captor
    private ArgumentCaptor<Tenant> tenantCaptor;

    @Test
    public void ShouldCreateTenantSuccessfully() {
        TenantDataRegistrationDTO dto = new TenantDataRegistrationDTO("Igor da Silva de Brito", "122111221");

        Tenant tenant = new Tenant();
        tenant.setName(dto.name());
        tenant.setPhone(dto.phone());

        when(tenantMapper.toEntity(dto)).thenReturn(tenant);
        when(tenantsRepository.save(any(Tenant.class))).thenReturn(tenant);

        tenantsService.createTenants(dto);

        verify(tenantsRepository).save(tenantCaptor.capture());

        Tenant tenantSave = tenantCaptor.getValue();
        Assertions.assertEquals(dto.name(), tenantSave.getName());
        Assertions.assertEquals(dto.phone(), tenantSave.getPhone());
    }
}
