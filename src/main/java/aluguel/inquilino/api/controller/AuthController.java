package aluguel.inquilino.api.controller;

import aluguel.inquilino.api.DTO.user.LoginRequest;
import aluguel.inquilino.api.DTO.user.RegisterRequest;
import aluguel.inquilino.api.DTO.user.ResponseLogin;
import aluguel.inquilino.api.domain.user.User;
import aluguel.inquilino.api.service.UserService;
import aluguel.inquilino.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    // 🔹 LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest dto) {
        try {

            var authToken = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());

            Authentication authentication = authenticationManager.authenticate(authToken);

            var user = (User) authentication.getPrincipal();

            String token = tokenService.generateToken(user);

            return ResponseEntity.ok(new ResponseLogin(user.getUsername(), token));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }

    // 🔹 REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterRequest dto, UriComponentsBuilder uriBuilder) {
        try {
            var user = userService.registerUser(dto);
            var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).body("Usuário registrado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
