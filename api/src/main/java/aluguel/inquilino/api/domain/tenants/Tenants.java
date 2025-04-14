package aluguel.inquilino.api.domain.tenants;


import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//inquilinos
@Table(name = "tenants")
@Entity(name = "Tenants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id_tenants")
public class Tenants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tenants;
    private String name;
    private String phone;
    private LocalDate rentedAt;

    public Tenants(TenantDataRegistrationDTO data){
        this.name = data.name();
        this.phone = data.phone();
        this.rentedAt = LocalDate.now();
    }

    public void updateTenants(UpdateTenantsDTO tenants) {
        if(tenants.name() != null){
            this.name = tenants.name();
        }
        if(tenants.phone() != null){
            this.phone = tenants.phone();
        }

    }
}
