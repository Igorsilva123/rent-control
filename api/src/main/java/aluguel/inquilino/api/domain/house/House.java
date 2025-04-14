package aluguel.inquilino.api.domain.house;


import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
import aluguel.inquilino.api.domain.address.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "house")
@Entity(name = "House")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_house;
    private String rent_value;
    @Embedded
    private Address address;

    public House(HouseDataRegistrationDTO data) {
        this.rent_value = data.rent_value();
        this.address = new Address(data.address());
    }

    public void updateHouse(UpdateHouse house) {
        if (house.rent_value() != null) {
            this.rent_value = house.rent_value();
        }
        if (house.address() != null) {
            this.address = house.address();
        }

    }
}
