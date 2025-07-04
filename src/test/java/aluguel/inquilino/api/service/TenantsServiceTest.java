package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        assertEquals(dto.name(), tenantSave.getName());
        assertEquals(dto.phone(), tenantSave.getPhone());
    }
    @Test
    public void ShouldReturnTenantSucessfully(){
        Tenant tenant1 = new Tenant(1L, "Alice", "123456789", LocalDate.now(), null);
        Tenant tenant2 = new Tenant(1L, "Bob", "123456789", LocalDate.now(), null);

        List<Tenant> tenants = List.of(tenant1, tenant2);

        TenantListingDataDTO dto1 = new TenantListingDataDTO(1L, "Alice", "123456789", LocalDate.now());
        TenantListingDataDTO dto2 = new TenantListingDataDTO(2L, "Bob", "123456789", LocalDate.now());

        when(tenantsRepository.findAll()).thenReturn(tenants);
        when(tenantMapper.toDTO(tenant1)).thenReturn(dto1);
        when(tenantMapper.toDTO(tenant2)).thenReturn(dto2);


        List<TenantListingDataDTO> result = tenantsService.getAllTenants();
        assertEquals("Bob", result.get(1).name());
        assertEquals("987654321", result.get(1).phone());

        verify(tenantsRepository).findAll();
        verify(tenantMapper).toDTO(tenant1);
        verify(tenantMapper).toDTO(tenant2);

    }
}
