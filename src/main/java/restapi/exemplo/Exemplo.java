package restapi.exemplo;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exemplo {
    private String problema;
    private String descricao;

    public Exemplo(DataExemplo exemplo) {
        this.problema = exemplo.problema();
        this.descricao = exemplo.descricao();
    }

    public void updateData(DataExemplo exemplo) {
        if (exemplo.descricao() != null) {
            this.descricao = exemplo.descricao();
        }

        if (exemplo.problema() != null) {
            this.problema = exemplo.problema();;
        }
    }
}
