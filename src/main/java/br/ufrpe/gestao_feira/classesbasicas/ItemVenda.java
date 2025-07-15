package br.ufrpe.gestao_feira.classesbasicas;

public class ItemVenda
{
    Produto produto;
    int quantidade;
    double valorTotal;

    public ItemVenda(Produto produto, int quantidade)
    {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto()
    {
        return produto;
    }
    public void setProduto(Produto produto)
    {
        this.produto = produto;
    }

    public int getQuantidade()
    {
        return quantidade;
    }
    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public double getValorTotal()
    {
        return produto.getPreco() * quantidade;
    }

}
