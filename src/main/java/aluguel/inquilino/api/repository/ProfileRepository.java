package aluguel.inquilino.api.repository;

import aluguel.inquilino.api.domain.user.Profile;
import aluguel.inquilino.api.domain.user.ProfileName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findByName(ProfileName profileName);
}
