import java.util.ArrayList;
import java.util.List;

public class Produtor {
    private String nome;
    private String cpfCnpj;
    private String telefone;
    private String email;
    private String categoria;

    public List<Produto> produtoAssociado(){
        List<Produto> produtos = new ArrayList<>();
        return produtos;
    }

    public List<EdicaoFeira> edicoesParticipadas(){
        List<EdicaoFeira> edicaoFeiras = new ArrayList<>();
        return edicaoFeiras;
    }
}
