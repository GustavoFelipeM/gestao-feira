package br.ufrpe.gestao_feira.exceptions;

import br.ufrpe.gestao_feira.classesbasicas.Produtor;

public class ProdutorSemParticipacoesException extends Exception
{
    String cpfCnpjDoProdutor;
    String nomeDoProdutor;
    public ProdutorSemParticipacoesException(Produtor produtor)
    {
        super("Produtor sem participacoes anteriores");
        this.cpfCnpjDoProdutor = produtor.getCpfCnpj();
        this.nomeDoProdutor = produtor.getNome();
    }
    public String getCpfCnpjDoProdutor()
    {
        return cpfCnpjDoProdutor;
    }
    public String getNomeDoProdutor()
    {
        return nomeDoProdutor;
    }
}
