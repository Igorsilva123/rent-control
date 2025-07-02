package aluguel.inquilino.api.DTO.owner;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record OwnerDataRegistrationDTO(
                                       @NotBlank
                                       String name,
                                       @NotBlank
                                       @Email
                                       String email,
                                       @NotBlank
                                       String password,
                                       @NotBlank
                                       String phone
                                       ) {

}
