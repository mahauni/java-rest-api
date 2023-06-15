package restapi.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import restapi.exemplo.DataExemplo;

public record jsonData(
        @NotBlank String nome,
        @NotBlank @Pattern(regexp = "\\d{1,3}") String idade,
        @NotNull @Valid DataExemplo exemplo) {
}
