package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.DTO.user.DataProfile;
import aluguel.inquilino.api.DTO.user.RegisterRequest;
import aluguel.inquilino.api.Mappers.UserMapper;
import aluguel.inquilino.api.domain.user.ProfileName;
import aluguel.inquilino.api.domain.user.User;
import aluguel.inquilino.api.infra.security.TokenService;
import aluguel.inquilino.api.repository.ProfileRepository;
import aluguel.inquilino.api.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ProfileRepository profileRepository;

    @Transactional
    public User registerUser(RegisterRequest dto) {

        Optional<User> existingUser = userRepository.findByEmailIgnoreCase(dto.email());
        if (existingUser.isPresent()) {
            throw new RuntimeException("E-mail já registrado.");
        }
        var profile = profileRepository.findByName(ProfileName.TENANT);
        User newUser = userMapper.toEntity(dto, profile);

        userRepository.save(newUser);

        String token = tokenService.generateToken(newUser);
        System.out.println("Token gerado para novo usuário: " + token);

        return newUser;
    }

//    @Transactional
//    public User putUser(UpdateUser dto){
//        var tenants = userRepository.getReferenceById(dto.id_user());
//        tenants.updateUser(dto);
//
//        return tenants;
//    }

    @Transactional
    public User addProfile(Long id, @Valid DataProfile data) {
        var user = userRepository.findById(id).orElseThrow();
        var profile = profileRepository.findByName(data.profileName());
        user.addProfile(profile);
        return user;
    }
    @Transactional
    public User deactivateUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!user.getActive()) {
            throw new IllegalStateException("Usuário já está desativado");
        }

        user.setActive(false);
        return userRepository.save(user);
    }@Transactional
    public User activateUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (user.getActive()) {
            throw new IllegalStateException("usuario já esta ativo");
        }

        user.setActive(true);
        return userRepository.save(user);
    }
}
