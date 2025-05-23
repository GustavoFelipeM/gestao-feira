public class Produto {
    private String nome;
    private String descricao;
    private double precoMedio;
    private String categoria;
    private Produtor produtor;

    public Produtor produtorAssociado(){
        return produtor;
    }
}
