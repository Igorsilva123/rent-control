package aluguel.inquilino.api.controller;

import aluguel.inquilino.api.DTO.house.HouseListingDataDTO;
import aluguel.inquilino.api.DTO.user.RegisterRequest;
import aluguel.inquilino.api.DTO.user.DataProfile;
import aluguel.inquilino.api.DTO.user.UserListingData;
import aluguel.inquilino.api.exception.ErrorReponse;
import aluguel.inquilino.api.exception.ResourceNotFoundException;
import aluguel.inquilino.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserListingData> registerUser(@RequestBody @Valid RegisterRequest dto, UriComponentsBuilder uriBuilder) {
            var user = userService.registerUser(dto);
            var uri = uriBuilder.path("/{id}").buildAndExpand(user.getId()).toUri();
            return ResponseEntity.created(uri).body(new UserListingData(user));
    }

    @PatchMapping("/add-profile/{id}")
    public ResponseEntity<UserListingData> addProfile(@PathVariable Long id, @RequestBody @Valid DataProfile data) {
        var user = userService.addProfile(id, data);
        return ResponseEntity.ok(new UserListingData(user));
        }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivateUser(@PathVariable Long id) {
        var user = userService.deactivateUser(id);
        return ResponseEntity.ok("Usuário " + user.getEmail() + " foi desativado com sucesso.");
        }

    @PutMapping("/{id}/active")
    public ResponseEntity<?> activateUser(@PathVariable Long id) {
        var user = userService.activateUser(id);
        return ResponseEntity.ok("Usuário " + user.getEmail() + " foi ativado com sucesso.");
    }
}
