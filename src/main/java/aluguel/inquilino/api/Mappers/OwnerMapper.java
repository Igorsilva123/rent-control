//package aluguel.inquilino.api.Mappers;
//
//import aluguel.inquilino.api.DTO.house.HouseSummaryDTO;
//import aluguel.inquilino.api.DTO.owner.DataListingOwnerDTO;
//import aluguel.inquilino.api.DTO.owner.HouseListingByOwnerDTO;
//import aluguel.inquilino.api.DTO.owner.OwnerDTO;
//import aluguel.inquilino.api.DTO.owner.OwnerDataRegistrationDTO;
//import aluguel.inquilino.api.domain.house.House;
//import aluguel.inquilino.api.domain.owner.Owner;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class OwnerMapper {
//    public Owner toEntity(OwnerDTO dto){
//        Owner owner = new Owner();
//        owner.setId_owner(dto.idOwner());
//        owner.setName(dto.name());
//        owner.setEmail(dto.email());
//        owner.setPassword(dto.password());
//        owner.setPhone(dto.phone());
//
//        return owner;
//    }
//    public Owner toEntity(OwnerDataRegistrationDTO dto){
//        Owner owner = new Owner();
//        owner.setName(dto.name());
//        owner.setEmail(dto.email());
//        owner.setPassword(dto.password());
//        owner.setPhone(dto.phone());
//        return owner;
//    }
//
//    public OwnerDTO toDTO(Owner owner){
//        return new OwnerDTO(
//                owner.getId_owner(),
//                owner.getName(),
//                owner.getEmail(),
//                owner.getPassword(),
//                owner.getPhone(),
//                owner.getHouses() != null
//                        ? owner.getHouses().stream().map(House::getId_house).toList()
//                        : List.of()
//        );
//    }
//    public DataListingOwnerDTO toOwnerWithHousesDTO(Owner owner) {
//        return new DataListingOwnerDTO(
//                owner.getId_owner(),
//                owner.getName(),
//                owner.getPhone(),
//                mapHouses(owner.getHouses())
//        );
//    }
//
//    private List<HouseSummaryDTO> mapHouses(List<House> houses) {
//        return houses != null
//                ? houses.stream().map(HouseSummaryDTO::new).toList()
//                : List.of();
//    }
//    public HouseListingByOwnerDTO toListingByOwnerDTO(House house) {
//        return new HouseListingByOwnerDTO(
//                house.getId_house(),
//                String.valueOf(house.getRent_value()),
//                house.getAddress() != null ? house.getAddress().getCidade() : null,
//                house.getAddress() != null ? house.getAddress().getBairro() : null,
//                house.getAddress() != null ? house.getAddress().getNumero() : null
//        );
//    }
//}
