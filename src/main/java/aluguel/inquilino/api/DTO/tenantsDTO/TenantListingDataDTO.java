package aluguel.inquilino.api.DTO.tenantsDTO;


import java.time.LocalDate;

public record TenantListingDataDTO(Long id_tenants, String name, String phone, LocalDate rentedAt) {
}
