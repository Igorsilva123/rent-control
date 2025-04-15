package aluguel.inquilino.api.DTO.owner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateOwnerDTO(@NotNull
                             Long id_owner,
                             String name,
                             String email,
                             String phone) {

}
