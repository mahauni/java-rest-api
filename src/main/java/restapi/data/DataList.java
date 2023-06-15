package restapi.data;

import restapi.exemplo.Exemplo;

public record DataList(Long id, String nome, Exemplo exemplo) {

    public DataList(Data data) {
        this(data.getId(), data.getNome(), data.getExemplo());
    }
}
