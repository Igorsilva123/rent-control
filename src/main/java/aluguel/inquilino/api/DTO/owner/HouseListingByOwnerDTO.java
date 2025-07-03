package aluguel.inquilino.api.DTO.owner
        ;

import aluguel.inquilino.api.domain.house.House;

public record HouseListingByOwnerDTO(
        Long id_house,
        String rent_value,
        String cidade,
        String bairro,
        String numero
){
}
