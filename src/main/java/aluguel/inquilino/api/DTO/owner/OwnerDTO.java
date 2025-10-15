package aluguel.inquilino.api.DTO.owner;


import java.util.List;

public record OwnerDTO(Long idOwner, String name, String email, String password, String phone, List<Long> houseIds) {

}

