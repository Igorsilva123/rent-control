package aluguel.inquilino.api.DTO.house;

import jakarta.validation.constraints.NotNull;

public record RemoveTenantDTO(@NotNull(message = "O ID da casa é obrigatório.")
                               Long houseId) {
}
