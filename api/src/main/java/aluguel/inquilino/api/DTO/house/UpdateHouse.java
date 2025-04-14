package aluguel.inquilino.api.DTO.house;

import aluguel.inquilino.api.domain.address.Address;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UpdateHouse(
        @NotNull
        Long id_house,
        String rent_value,
        Address address) {
}
