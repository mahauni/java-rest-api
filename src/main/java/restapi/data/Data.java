package restapi.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import restapi.exemplo.Exemplo;

@Entity
@Table(name = "data_test")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String idade;

    @Embedded
    private Exemplo exemplo;
    private boolean active;

    public Data(jsonData json) {
        this.active = true;
        this.nome = json.nome();
        this.idade = json.idade();
        this.exemplo = new Exemplo(json.exemplo());
    }

    public void updateData(DataUpdate json) {
        if (json.idade() != null) {
            this.idade = json.idade();
        }

        if (json.exemplo() != null) {
            this.exemplo.updateData(json.exemplo());
        }
    }

    public void delete() {
        this.active = false;
    }
}
