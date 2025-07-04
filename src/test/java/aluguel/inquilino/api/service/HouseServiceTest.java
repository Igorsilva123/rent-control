package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.house.AssignTenantDTO;
import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.domain.address.Address;
import aluguel.inquilino.api.domain.tenants.Tenant;
import aluguel.inquilino.api.repository.HouseRepository;
import aluguel.inquilino.api.repository.TenantsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HouseServiceTest {

    @Mock
    private HouseRepository houseRepository;

    @Mock
    private TenantsRepository tenantsRepository;




    @InjectMocks
    private HouseService houseService;
    @Test
    void shouldAssignTenantToHouseSucessfully() {
        Tenant tenant1 = new Tenant(1L, "Alice", "123456789", LocalDate.now(), null);

        // Cria DTO de saída esperado

        AssignTenantDTO dto1 = new AssignTenantDTO(1L, 1l);

        when(tenantsRepository.findById(1L)).thenReturn(Optional.of(tenant1));
    }
}