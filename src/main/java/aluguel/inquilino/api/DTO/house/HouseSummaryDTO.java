package aluguel.inquilino.api.DTO.house;


import aluguel.inquilino.api.domain.address.Address;
import aluguel.inquilino.api.domain.house.House;

public record HouseSummaryDTO(Long id_house, Address address) {
    public HouseSummaryDTO(House house) {
        this(house.getId_house(), house.getAddress());
    }
}