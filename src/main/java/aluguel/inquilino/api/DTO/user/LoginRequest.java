package aluguel.inquilino.api.DTO.user;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
                            @NotBlank String email,
                            @NotBlank String password) {
}
