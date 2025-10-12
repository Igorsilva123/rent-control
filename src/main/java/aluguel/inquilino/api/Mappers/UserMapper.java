package aluguel.inquilino.api.Mappers;

import aluguel.inquilino.api.DTO.user.RegisterRequest;
import aluguel.inquilino.api.domain.user.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserMapper {

        @Autowired
        private PasswordEncoder passwordEncoder;

        public User toEntity(RegisterRequest dto){
            User newUser = new User();
            newUser.setName(dto.name());
            newUser.setEmail(dto.email());
            newUser.setPassword(passwordEncoder.encode(dto.password()));
            newUser.setNickName(dto.nickName());
            newUser.setRentedAt(LocalDate.now());
            newUser.setActive(Boolean.TRUE);
            return newUser;

        }
}

//
//public record RegisterRequest(@NotBlank
//                              String name,
//                              @NotBlank
//                              String email,
//                              @NotBlank
//                              String password,
//                              @NotBlank
//                              String nickName
//) {
//}
