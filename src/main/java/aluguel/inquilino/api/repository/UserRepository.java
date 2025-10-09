package aluguel.inquilino.api.repository;

import aluguel.inquilino.api.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
