package br.ufrpe.gestao_feira.classesbasicas;

import br.ufrpe.gestao_feira.exceptions.ProdutoInvalidoException;

public class Produto
{
    private String nome;
    private String descricao;
    private String categoria;
    private double preco;
    private Produtor produtorAssociado;

    public Produto(String nome, String descricao, String categoria, double preço, Produtor produtorAssociado)
    {

        {
            this.nome = nome;
            this.descricao = descricao;
            this.categoria = categoria;
            this.preco = preco;
            this.setProdutorAssociado(produtorAssociado); //TODO Tirar esse método daí e colocar no controlador
        }
    }


    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public double getPreco()
    {
        return preco;
    }
    public void setPreco(double preco)
    {
        this.preco = preco;
    }

    public Produtor getProdutorAssociado()
    {
        return produtorAssociado;
    }
    public void setProdutorAssociado(Produtor produtorAssociado) throws ProdutoInvalidoException
    {
        if (!(categoria != null && !categoria.isEmpty() && produtorAssociado != null && this.categoria.equalsIgnoreCase(produtorAssociado.getCategoria())))
        {
           throw new ProdutoInvalidoException(this.categoria, produtorAssociado); //TODO
        }
        else
        {
            this.produtorAssociado = produtorAssociado;
        }
    }
}
