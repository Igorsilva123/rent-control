package aluguel.inquilino.api.DTO.house;

import aluguel.inquilino.api.DTO.address.DataAddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HouseDataRegistrationDTO(
        @NotBlank
        String rent_value,

        @NotNull @Valid
        DataAddressDTO address,

        @NotNull
        Long user_id
) {
}
