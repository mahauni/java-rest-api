package restapi.data;

import jakarta.validation.constraints.NotNull;
import restapi.exemplo.DataExemplo;

public record DataUpdate(
        @NotNull Long id,
        String idade,
        DataExemplo exemplo) {
}
