package aluguel.inquilino.api.Mappers;

import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseMapper {

    @Autowired
    AddressMapper addressMapper;

    public House toEntity(HouseDataRegistrationDTO data, User user) {
        House house = new House();
        house.setRent_value(data.rent_value());
        house.setAddress(addressMapper.toEntity(data.address()));
        house.setUser(user);

        return house;
    }public HouseListingDataDTO toDTO(House house) {
        if (house == null) {
            return null;
        }
        return new HouseListingDataDTO(
                house.getId(),
                house.getRent_value(),
                house.getAddress(),
                house.getUser().getId(),
                house.getUser().getName(),
                house.getUser() != null ? house.getUser().getId() : null,
                house.getUser() != null ? house.getUser().getName() : null
        );
    }


    public void updateEntity(UpdateHouse dto, House house) {
        if (dto.rent_value() != null) {
            house.setRent_value(dto.rent_value());
        }
        if (dto.address() != null) {
            house.setAddress(addressMapper.toEntity(dto.address()));
        }
    }
}


