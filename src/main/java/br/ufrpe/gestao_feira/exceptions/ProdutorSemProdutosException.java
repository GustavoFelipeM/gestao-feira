package br.ufrpe.gestao_feira.exceptions;

import br.ufrpe.gestao_feira.classesbasicas.Produtor;

public class ProdutorSemProdutosException extends Exception
{
    String cpfCnpjDoProdutor;
    String nomeDoProdutor;

    public ProdutorSemProdutosException(Produtor produtor)
    {
        super("Produtor sem produtos");
        cpfCnpjDoProdutor = produtor.getCpfCnpj();
        nomeDoProdutor = produtor.getNome();
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
