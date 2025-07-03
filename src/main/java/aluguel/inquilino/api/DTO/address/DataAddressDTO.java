package aluguel.inquilino.api.DTO.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddressDTO(
                          @NotBlank
                          String logradouro,
                          @NotBlank
                          String bairro,
                          @NotBlank
                          @Pattern(regexp = "\\d{8}")
                          String cep,
                          @NotBlank
                          String uf,
                          @NotBlank
                          String cidade,
                          String complemento,
                          String numero) {
}
