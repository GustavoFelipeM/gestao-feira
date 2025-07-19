package br.ufrpe.gestao_feira.exceptions;

public class ProdutorInexistenteException extends Exception
{
    String cpfCnpjLivre;
    public ProdutorInexistenteException (String cpfCnpj)
    {
        super("Produtor inexistente com tal CPF: " + cpfCnpj);
        this.cpfCnpjLivre = cpfCnpj;
    }

    public String getCpfCnpjLivre()
    {
        return cpfCnpjLivre;
    }
}
