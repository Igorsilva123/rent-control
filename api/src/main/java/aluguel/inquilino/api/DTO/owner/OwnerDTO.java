package aluguel.inquilino.api.DTO.owner;

import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.owner.Owner;

import java.util.List;

public record OwnerDTO(Long idOwner, String name, String email, String password, String phone, List<Long> houseIds) {

}

