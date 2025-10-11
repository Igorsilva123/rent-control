package aluguel.inquilino.api.DTO.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterRequest(@NotBlank
                              String name,
                              @NotBlank
                              String email,
                              @NotBlank
                              String password,
                              @NotBlank
                              String nickName
) {
}
