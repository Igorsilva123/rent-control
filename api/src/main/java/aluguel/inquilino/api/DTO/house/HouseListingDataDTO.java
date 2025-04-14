package aluguel.inquilino.api.DTO.house;

import aluguel.inquilino.api.domain.address.Address;
import aluguel.inquilino.api.domain.house.House;

public record HouseListingDataDTO(Long id_house ,String rent_value, Address address) {
    public HouseListingDataDTO(House data){
        this(data.getId_house(), data.getRent_value(), data.getAddress());

    }
}
