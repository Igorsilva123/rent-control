package aluguel.inquilino.api.repository;

import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.tenants.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {
    boolean existsByTenant(Tenant tenant);
    @Query("SELECT h FROM House h WHERE h.owner.id_owner = :ownerId")
    List<House> findByOwnerId(@Param("ownerId") Long ownerId);


}
