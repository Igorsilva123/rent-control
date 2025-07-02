package aluguel.inquilino.api.repository;

import aluguel.inquilino.api.domain.tenants.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantsRepository extends JpaRepository<Tenant, Long> {

}
