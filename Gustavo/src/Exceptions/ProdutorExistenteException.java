package Exceptions;

import Classesbasicas.*;

public class ProdutorExistenteException extends Exception
{
    Produtor produtorExistente;
    public  ProdutorExistenteException(Produtor produtor)
    {
        super("Produtor com mesmo CPF/CNPJ existente, não foi possível cadastrar");
        this.produtorExistente = produtor;

    }

    public Produtor getProdutorExistente()
    {
        return produtorExistente;
    }

}
