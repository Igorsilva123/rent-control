package aluguel.inquilino.api.domain.owner;

import aluguel.inquilino.api.domain.house.House;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "owner")
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

    @OneToMany(mappedBy = "owner")
    private List<House> houses;
}
