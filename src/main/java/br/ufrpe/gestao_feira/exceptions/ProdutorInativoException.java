package br.ufrpe.gestao_feira.exceptions;

import br.ufrpe.gestao_feira.classesbasicas.*;

public class ProdutorInativoException extends Exception
{
    public ProdutorInativoException(Produtor produtor)
    {
        super("O produtor " + produtor.getNome() + " de Cpf: " + produtor.getCpfCnpj() + ", está inativo" );
    }
}
