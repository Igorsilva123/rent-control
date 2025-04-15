package aluguel.inquilino.api.DTO.tenantsDTO;

import jakarta.validation.constraints.NotNull;

public record UpdateTenantsDTO(
        @NotNull
        Long id_tenants,
        String name,
        String phone
) {
}
