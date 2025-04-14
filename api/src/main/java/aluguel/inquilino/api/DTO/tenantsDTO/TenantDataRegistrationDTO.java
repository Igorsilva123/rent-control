package aluguel.inquilino.api.DTO.tenantsDTO;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record TenantDataRegistrationDTO(
                                     @NotBlank
                                     String name,
                                     @NotBlank
                                     String phone,
                                     @NotBlank
                                     LocalDateTime rentedAt) {

}
