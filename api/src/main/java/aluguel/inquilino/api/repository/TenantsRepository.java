package aluguel.inquilino.api.repository;

import aluguel.inquilino.api.domain.tenants.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantsRepository extends JpaRepository<Tenants, Long> {

}
