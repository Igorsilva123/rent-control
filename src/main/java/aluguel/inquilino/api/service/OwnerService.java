//package aluguel.inquilino.api.service;
//
//import aluguel.inquilino.api.DTO.owner.*;
//import aluguel.inquilino.api.Mappers.OwnerMapper;
//import aluguel.inquilino.api.domain.owner.Owner;
//import aluguel.inquilino.api.exception.ResourceNotFoundException;
//import aluguel.inquilino.api.repository.HouseRepository;
//import aluguel.inquilino.api.repository.OwnerRepository;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OwnerService {
//
//    @Autowired
//    private OwnerRepository ownerRepository;
//
//    @Autowired
//    private HouseRepository houseRepository;
//
//    @Autowired
//    private OwnerMapper ownerMapper;
//
//        @Transactional
//        public void createOwner(OwnerDataRegistrationDTO data){
//            Owner owner = ownerMapper.toEntity(data);
//
//            ownerRepository.save(owner);
//        }
//
//        public List<HouseListingByOwnerDTO> ListHouseByOwner(Long id_owner) {
//            if (!ownerRepository.existsById(id_owner)) {
//                throw new ResourceNotFoundException("Proprietário não encontrado com id: " + id_owner);
//            }
//
//            var houses = houseRepository.findByOwnerId(id_owner);
//            return houses.stream()
//                    .map(ownerMapper::toListingByOwnerDTO)
//                    .toList();
//             }
//
//        public List<DataListingOwnerDTO> listOwner() {
//            return ownerRepository.findAll().stream().map(ownerMapper::toOwnerWithHousesDTO).toList();
//
//        }
//
//        @Transactional
//        public void deleteById(Long id) {
//            ownerRepository.deleteById(id);
//        }
//
//        @Transactional
//        public Owner putOwner(UpdateOwnerDTO dados){
//            var owner = ownerRepository.getReferenceById(dados.id_owner());
//            owner.updateOwner(dados);
//            return owner;
//        }
//
//}
//
//
