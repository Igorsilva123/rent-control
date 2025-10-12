package aluguel.inquilino.api.DTO.user;

import jakarta.validation.constraints.NotBlank;


public record RegisterRequest(@NotBlank
                              String name,
                              @NotBlank
                              String email,
                              @NotBlank
                              String password,
                              @NotBlank
                              String nickName,
                              String phone
) {
}
