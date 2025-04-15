package aluguel.inquilino.api.DTO.tenantsDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TenantDataRegistrationDTO(
                                     @NotBlank
                                     String name,
                                     @NotBlank
                                     String phone) {

}
