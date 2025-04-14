package aluguel.inquilino.api.DTO.tenantsDTO;

import jakarta.validation.constraints.NotNull;

public record UpdateTenantsDTO(
        @NotNull
        Long id,
        String name,
        String phone
) {
}
