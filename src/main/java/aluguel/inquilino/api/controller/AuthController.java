package aluguel.inquilino.api.controller;

import aluguel.inquilino.api.DTO.user.LoginRequest;
import aluguel.inquilino.api.domain.user.User;
import aluguel.inquilino.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;



    @PostMapping("/login")
    public ResponseEntity<Authentication> login(@Valid @RequestBody LoginRequest dto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var authentication = authenticationManager.authenticate(authenticationToken);
        return ResponseEntity.ok(authentication);
    }

    @PostMapping("register")
    public ResponseEntity registerUser(@Valid @RequestBody RegisterRequest dto, UriComponentsBuilder uriBuilder){
        User user = userService.registerUser(dto);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.id)

        return ResponseEntity.ok("successfully registered user");
    }
}
