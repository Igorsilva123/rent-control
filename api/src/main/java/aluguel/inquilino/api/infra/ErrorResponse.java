package aluguel.inquilino.api.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private HttpStatus status;
    private String message;
}
