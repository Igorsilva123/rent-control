package aluguel.inquilino.api.DTO.owner;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public record OwnerDataRegistrationDTO(@NotBlank
                                       Long id_owner,
                                       @NotBlank
                                       String name,
                                       @NotBlank
                                       String email,
                                       @NotBlank
                                       String phone) {

}
