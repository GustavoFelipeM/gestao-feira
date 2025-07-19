package br.ufrpe.gestao_feira.exceptions;

import br.ufrpe.gestao_feira.classesbasicas.*;


public class ProdutoInexistenteException extends Exception
{
    public ProdutoInexistenteException(Produto produto)
    {
        super("O produto " + produto.getNome() + " não existe");
    }
    public ProdutoInexistenteException (String nome)
    {
        super ("O produto " + nome + " não existe");
    }
}
