package aluguel.inquilino.api.Mappers;

import aluguel.inquilino.api.DTO.tenantsDTO.TenantDataRegistrationDTO;
import aluguel.inquilino.api.DTO.tenantsDTO.TenantListingDataDTO;
import aluguel.inquilino.api.domain.tenants.Tenant;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class TenantMapper {
    public Tenant toEntity(TenantDataRegistrationDTO dto){
        Tenant tenant = new Tenant();
        tenant.setName(dto.name());
        tenant.setPhone(dto.phone());
        return tenant;
    }
    public TenantListingDataDTO toDTO(Tenant tenant){
       return new TenantListingDataDTO(
                tenant.getId_tenants(),
               tenant.getName(),
               tenant.getPhone(),
               tenant.getRentedAt()
        );
    }

}
