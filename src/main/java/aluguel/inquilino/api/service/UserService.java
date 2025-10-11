package aluguel.inquilino.api.service;

import aluguel.inquilino.api.DTO.user.RegisterRequest;
import aluguel.inquilino.api.Mappers.UserMapper;
import aluguel.inquilino.api.domain.user.User;
import aluguel.inquilino.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Transactional
    public void registerUser(RegisterRequest dto) {
        Optional<User> user = userRepository.findByEmailIgnoreCase(dto.email());
        if (user.isPresent()) {
            throw new RuntimeException("E-mail já registrado.");
        }
        User newUser = userMapper.toEntity(dto);

        userRepository.save(newUser);

        String token = tokenService.generateToken(newUser);


    }
}
}
