package aluguel.inquilino.api.Mappers;

import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.domain.address.Address;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseMapper {

    @Autowired
    AddressMapper addressMapper;

    public House toEntity(HouseDataRegistrationDTO data, Owner owner) {
        House house = new House();
        house.setRent_value(data.rent_value());
        house.setAddress(addressMapper.toEntity(data.address()));
        house.setOwner(owner);

        return house;
    }public HouseListingDataDTO toDTO(House house) {
        if (house == null) {
            return null;
        }
        return new HouseListingDataDTO(
                house.getId_house(),
                house.getRent_value(),
                house.getAddress(),
                house.getOwner().getId_owner(),
                house.getOwner().getName(),
                house.getTenant() != null ? house.getTenant().getId_tenants() : null,
                house.getTenant() != null ? house.getTenant().getName() : null
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


