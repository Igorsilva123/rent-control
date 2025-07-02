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
    private String password;
    private String phone;

    @OneToMany(mappedBy = "owner")
    private List<House> houses;

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
        if (dados.password() != null) {
            this.password = dados.password();
        }

    }
}
