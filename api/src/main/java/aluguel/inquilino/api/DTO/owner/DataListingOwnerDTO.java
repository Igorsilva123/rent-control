package aluguel.inquilino.api.DTO.owner;

import aluguel.inquilino.api.domain.owner.Owner;

public record DataListingOwnerDTO(Long id_owner, String name, String email, String phone) {
    public DataListingOwnerDTO(Owner dados){
        this(dados.getId_owner(), dados.getName(), dados.getEmail(), dados.getPhone());
    }
}
