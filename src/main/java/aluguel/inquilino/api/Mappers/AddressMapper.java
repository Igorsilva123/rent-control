package aluguel.inquilino.api.Mappers;

import aluguel.inquilino.api.DTO.address.DataAddressDTO;
import aluguel.inquilino.api.domain.address.Address;
import org.springframework.stereotype.Component;


@Component
public class AddressMapper {

    public Address toEntity(DataAddressDTO dto){
        Address address = new Address();
        address.setLogradouro(dto.logradouro());
        address.setBairro(dto.bairro());
        address.setCep(dto.cep());
        address.setUf(dto.uf());
        address.setCidade(dto.cidade());
        address.setComplemento(dto.complemento());
        address.setNumero(dto.numero());

        return address;
    }
}
