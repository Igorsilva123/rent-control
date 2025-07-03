package aluguel.inquilino.api.repository;

import aluguel.inquilino.api.DTO.address.DataAddressDTO;
import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.owner.OwnerDataRegistrationDTO;
import aluguel.inquilino.api.Mappers.AddressMapper;
import aluguel.inquilino.api.Mappers.HouseMapper;
import aluguel.inquilino.api.Mappers.OwnerMapper;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.owner.Owner;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@Import({OwnerMapper.class, HouseMapper.class, AddressMapper.class})
class HouseRepositoryTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    private OwnerMapper ownerMapper;

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private HouseRepository houseRepository;

    @Test
    @DisplayName("Deve retornar as casas do proprietário pelo ID")
    void findByOwnerIdCase1() {
        OwnerDataRegistrationDTO owner = new OwnerDataRegistrationDTO(
                "Igor da Silva de Brito",
                "igor.seila@outlook.com",
                "igor",
                "87991977997");

        Owner newOwner = ownerMapper.toEntity(owner);
        entityManager.persist(newOwner);
        entityManager.flush();

        DataAddressDTO addressDTO = new DataAddressDTO(
                "Rua das Laranjeiras",
                "Centro",
                "12345678",
                "PB",
                "João Pessoa",
                "Apto 101",
                "12"
        );


        HouseDataRegistrationDTO houseDTO = new HouseDataRegistrationDTO(
                "1500",
                addressDTO,
                newOwner.getId_owner()
        );


        House house = houseMapper.toEntity(houseDTO, newOwner);
        entityManager.persist(house);
        entityManager.flush();


        List<House> houses = houseRepository.findByOwnerId(newOwner.getId_owner());

        assertThat(houses).isNotEmpty();
        assertThat(houses.get(0).getOwner().getId_owner()).isEqualTo(newOwner.getId_owner());
        assertThat(houses.get(0).getRent_value()).isEqualTo("1500");
    }


}