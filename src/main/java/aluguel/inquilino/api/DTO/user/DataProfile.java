package aluguel.inquilino.api.DTO.user;

import aluguel.inquilino.api.domain.user.ProfileName;
import jakarta.validation.constraints.NotNull;

public record DataProfile(@NotNull ProfileName profileName) {
}
