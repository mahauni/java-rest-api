package restapi.exemplo;

import jakarta.validation.constraints.NotBlank;

public record DataExemplo(
        @NotBlank String problema,
        @NotBlank String descricao) {
}
