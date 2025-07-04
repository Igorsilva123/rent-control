package aluguel.inquilino.api.DTO.tenantsDTO;

import aluguel.inquilino.api.domain.tenants.Tenant;

import java.time.LocalDate;

public record TenantListingDataDTO(Long id_tenants, String name, String phone, LocalDate rentedAt) {
}
