package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.user.RegisterRequest;
import aluguel.inquilino.api.Mappers.UserMapper;
import aluguel.inquilino.api.domain.user.User;
import aluguel.inquilino.api.infra.security.TokenService;
import aluguel.inquilino.api.repository.UserRepository;
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

    @Transactional
    public User registerUser(RegisterRequest dto) {

        Optional<User> existingUser = userRepository.findByEmailIgnoreCase(dto.email());
        if (existingUser.isPresent()) {
            throw new RuntimeException("E-mail já registrado.");
        }

        User newUser = userMapper.toEntity(dto);

        newUser.setPassword(passwordEncoder.encode(dto.password()));

        userRepository.save(newUser);

        String token = tokenService.generateToken(newUser);
        System.out.println("Token gerado para novo usuário: " + token);

        return newUser;
    }
}
