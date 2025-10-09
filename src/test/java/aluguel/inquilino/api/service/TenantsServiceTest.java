package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
import aluguel.inquilino.api.Mappers.TenantMapper;
import aluguel.inquilino.api.domain.tenants.Tenant;
import aluguel.inquilino.api.repository.TenantsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    @DisplayName("Deve criar um inquilino com sucesso")
    void shouldCreateTenantSuccessfully() {

        TenantDataRegistrationDTO dto = new TenantDataRegistrationDTO(
                "Igor da Silva de Brito", "122111221");

        Tenant tenant = new Tenant();
        tenant.setName(dto.name());
        tenant.setPhone(dto.phone());

        when(tenantMapper.toEntity(dto)).thenReturn(tenant);
        when(tenantsRepository.save(any(Tenant.class))).thenReturn(tenant);

        tenantsService.createTenants(dto);

        verify(tenantsRepository).save(tenantCaptor.capture());

        Tenant savedTenant = tenantCaptor.getValue();
        assertThat(savedTenant.getName()).isEqualTo(dto.name());
        assertThat(savedTenant.getPhone()).isEqualTo(dto.phone());

        verify(tenantMapper).toEntity(dto);
        verifyNoMoreInteractions(tenantsRepository);
    }

    @Test
    @DisplayName("Deve retornar todos os inquilinos com sucesso (sem verificar mapper)")
    void shouldReturnTenantsSuccessfully() {

        Tenant tenant1 = new Tenant(1L, "Alice", "123456789", LocalDate.now(), null);
        Tenant tenant2 = new Tenant(2L, "Bob", "987654321", LocalDate.now(), null);

        List<Tenant> tenants = List.of(tenant1, tenant2);

        TenantListingDataDTO dto1 = new TenantListingDataDTO(
                1L, "Alice", "123456789", LocalDate.now());
        TenantListingDataDTO dto2 = new TenantListingDataDTO(
                2L, "Bob", "987654321", LocalDate.now());

        when(tenantsRepository.findAll()).thenReturn(tenants);
        when(tenantMapper.toDTO(any(Tenant.class)))
                .thenAnswer(invocation -> {
                    Tenant t = invocation.getArgument(0);
                    if (t.getName().equals("Alice")) return dto1;
                    if (t.getName().equals("Bob")) return dto2;
                    return null;
                });

        List<TenantListingDataDTO> result = tenantsService.getAllTenants();

        assertThat(result).hasSize(2);
        assertThat(result).extracting("name")
                .containsExactly("Alice", "Bob");
        assertThat(result).extracting("phone")
                .containsExactly("123456789", "987654321");

        verify(tenantsRepository).findAll();
        verifyNoMoreInteractions(tenantsRepository);
    }
}
