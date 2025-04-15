package aluguel.inquilino.api.domain.owner;

import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.DTO.owner.OwnerDataRegistrationDTO;
import aluguel.inquilino.api.DTO.owner.UpdateOwnerDTO;
import aluguel.inquilino.api.domain.house.House;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "owners")
@Entity(name = "Owner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_owner;

    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<House> houses;

    public Owner(OwnerDataRegistrationDTO dados){
        this.name = dados.name();
        this.email = dados.email();
        this.phone = dados.phone();
    }

    public void updateOwner(UpdateOwnerDTO dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.phone() != null) {
            this.phone = dados.phone();
        }

    }
}
