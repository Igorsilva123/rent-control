package aluguel.inquilino.api.domain.house;


import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
import aluguel.inquilino.api.domain.address.Address;
import aluguel.inquilino.api.domain.owner.Owner;
import aluguel.inquilino.api.domain.tenants.Tenants;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "houses")
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

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @OneToOne
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenants tenant;

    public House(HouseDataRegistrationDTO data) {
        this.rent_value = data.rent_value();
        this.address = new Address(data.address());
    }

    public void updateHouse(UpdateHouse house) {
        if (house.rent_value() != null) {
            this.rent_value = house.rent_value();
        }
        if (house.address() != null) {
            this.address.atualizarInformacoes(house.address());
        }

    }
}
