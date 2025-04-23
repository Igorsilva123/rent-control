package aluguel.inquilino.api.repository;

import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.tenants.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
    boolean existsByTenant(Tenants tenant);
}
