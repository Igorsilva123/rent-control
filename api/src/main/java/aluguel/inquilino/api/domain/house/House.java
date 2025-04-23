package aluguel.inquilino.api.domain.house;


import aluguel.inquilino.api.DTO.house.HouseDataRegistrationDTO;
import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
import aluguel.inquilino.api.domain.address.Address;
import aluguel.inquilino.api.domain.owner.Owner;
import aluguel.inquilino.api.domain.tenants.Tenants;
import aluguel.inquilino.api.repository.HouseRepository;
import aluguel.inquilino.api.repository.OwnerRepository;
import aluguel.inquilino.api.repository.TenantsRepository;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @OneToOne(fetch = FetchType.LAZY)
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
