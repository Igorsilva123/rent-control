package aluguel.inquilino.api.DTO.house;

import jakarta.validation.constraints.NotNull;

public record AssignTenantDTO(
        @NotNull
        Long houseId,
        @NotNull
        Long userId
) {
}
