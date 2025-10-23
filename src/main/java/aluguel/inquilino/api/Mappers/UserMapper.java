package aluguel.inquilino.api.Mappers;

import aluguel.inquilino.api.DTO.house.UpdateHouse;
import aluguel.inquilino.api.DTO.user.RegisterRequest;
import aluguel.inquilino.api.domain.house.House;
import aluguel.inquilino.api.domain.user.Profile;
import aluguel.inquilino.api.domain.user.ProfileName;
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

        public User toEntity(RegisterRequest dto, Profile profile){
            User newUser = new User();
            newUser.setName(dto.name());
            newUser.setEmail(dto.email());
            newUser.setPassword(passwordEncoder.encode(dto.password()));
            newUser.setNickName(dto.nickName());
            newUser.setRentedAt(LocalDate.now());
            newUser.setActive(Boolean.TRUE);
            newUser.getProfiles().add(profile);
            return newUser;

        }

//        public void updateEntity(UpdateHouse dto, House house) {
//            if (dto.rent_value() != null) {
//                house.setRent_value(dto.rent_value());
//            }
//            if (dto.address() != null) {
//                house.setAddress(addressMapper.toEntity(dto.address()));
//            }
//        }
}

