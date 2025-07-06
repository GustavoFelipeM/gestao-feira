package Exceptions;

import Classesbasicas.*;

public class ProdutoInvalidoException extends Exception
{
    private String categoriaDoProduto;
    private Produtor produtorAssociado;

    public ProdutoInvalidoException(String categoria, Produtor produtor)
    {
        super("Categoria difere do produtor");
        this.produtorAssociado = produtor;
    }

    public Produtor getProdutorAssociado()
    {
        return produtorAssociado;
    }

    public void setProdutorAssociado(Produtor produtor)
    {
        this.produtorAssociado = produtor;
    }

    public String getCategoriaDoProduto()
    {
        return categoriaDoProduto;
    }
    public void setCategoriaDoProduto(String categoriaDoProduto)
    {
        this.categoriaDoProduto = categoriaDoProduto;
    }



}
