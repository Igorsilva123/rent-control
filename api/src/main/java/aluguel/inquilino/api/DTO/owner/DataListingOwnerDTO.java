package aluguel.inquilino.api.DTO.owner;

import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.owner.Owner;

import java.util.List;
import java.util.stream.Collectors;

public record DataListingOwnerDTO(Long id_owner, String name, String email, String phone, List<Long> houseIds) {
    public DataListingOwnerDTO(Owner dados){
        this(dados.getId_owner(), dados.getName(), dados.getEmail(), dados.getPhone(), dados.getHouses().stream()
                .map(House::getId_house)
                .collect(Collectors.toList()));
    }

    public record HouseDTO(Long id) {
        public HouseDTO(House house) {
            this(house.getId_house());
        }
    }

}
