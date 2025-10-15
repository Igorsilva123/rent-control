//    package aluguel.inquilino.api.domain.tenants;
//
//
//    import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
//    import aluguel.inquilino.api.DTO.tenantsDTO.UpdateTenantsDTO;
//    import aluguel.inquilino.api.domain.house.House;
//    import jakarta.persistence.*;
//    import lombok.*;
//
//    import java.time.LocalDate;
//
//    //inquilinos
//    @Table(name = "tenants")
//    @Entity(name = "Tenants")
//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @NoArgsConstructor
//    @EqualsAndHashCode(of = "id_tenants")
//    public class Tenant {
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id_tenants;
//        private String name;
//        private String phone;
//        private LocalDate rentedAt;
//
//        @OneToOne(mappedBy = "tenant")
//        private House house;
//
//
//        public void updateTenants(UpdateTenantsDTO tenants) {
//            if(tenants.name() != null){
//                this.name = tenants.name();
//            }
//            if(tenants.phone() != null){
//                this.phone = tenants.phone();
//            }
//
//
//        }
//    }
