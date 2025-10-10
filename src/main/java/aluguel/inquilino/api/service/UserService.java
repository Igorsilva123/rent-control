package aluguel.inquilino.api.service;

import aluguel.inquilino.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {
    @Autowired

    private UserRepository userRepository;


    login
    @Override
    public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException {
        return userRepository.findByEmailIgnoreCase(nickName).orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado!"));
    }
}
