package aluguel.inquilino.api.DTO.tenantsDTO;

import aluguel.inquilino.api.domain.tenants.Tenants;

import java.time.LocalDateTime;

import java.time.LocalDate;

public record TenantListingDataDTO(Long id, String name, String phone, LocalDate rentedAt) {
    public TenantListingDataDTO(Tenants tenants){
        this(tenants.getId_tenants(), tenants.getName(), tenants.getPhone(), tenants.getRentedAt());
    }
}
