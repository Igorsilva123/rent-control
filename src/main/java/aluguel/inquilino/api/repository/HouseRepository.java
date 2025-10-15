package aluguel.inquilino.api.repository;

import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

    boolean existsByUser(User user);

    List<House> findByUserId(Long userId);
}
