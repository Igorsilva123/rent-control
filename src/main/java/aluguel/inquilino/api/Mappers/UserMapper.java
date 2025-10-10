package aluguel.inquilino.api.Mappers;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

        @Autowired
        private PasswordEncoder passwordEncoder;

        public User toEntity(RegisterRequest body){
            User newUser = new User();
            newUser.setEmail(body.email());
            newUser.setUsername(body.username());

            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setCpf(body.cpf());
            newUser.setActive(Boolean.TRUE);

            return newUser;
        }


    }
}
