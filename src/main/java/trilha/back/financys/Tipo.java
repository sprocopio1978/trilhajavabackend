package trilha.back.financys;

public enum Tipo {

    BEBIDAS("Bebidas"),
    VESTUARIO("Vestuário"),
    CONSTRUCAO("Construção"),
    FARMACIA("Farmácia");

    private String descricao;

    Tipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
