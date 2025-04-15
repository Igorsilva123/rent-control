package aluguel.inquilino.api.Service;


import aluguel.inquilino.api.DTO.owner.DataListingOwnerDTO;
import aluguel.inquilino.api.DTO.owner.OwnerDataRegistrationDTO;
import aluguel.inquilino.api.DTO.owner.UpdateOwnerDTO;
import aluguel.inquilino.api.domain.owner.Owner;
import aluguel.inquilino.api.repository.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

        @Transactional
        public void createOwner(OwnerDataRegistrationDTO data){
            var owner = new Owner(data);
            repository.save(owner);
        }

        public List<DataListingOwnerDTO> getAll() {
            var owner = repository.findAll().stream()
                    .map(DataListingOwnerDTO::new)
                    .toList();
            return owner;

        }

        @Transactional
        public void deleteById(Long id) {
            repository.deleteById(id);
        }

        @Transactional
        public Owner putOwner(UpdateOwnerDTO dados){
            var owner = repository.getReferenceById(dados.id_owner());
            owner.updateOwner(dados);
            return owner;
        }

}


