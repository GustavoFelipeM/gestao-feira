package br.ufrpe.gestao_feira.service.dto;

public class RelatorioVendaPorProdutoDTO
{
    private String nomeProduto;
    private String categoria;
    private double totalVendido;

    public RelatorioVendaPorProdutoDTO(String nomeProduto, String categoria, double totalVendido)
    {
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.totalVendido = totalVendido;
    }

    public String getNomeProduto()
    {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto)
    {
        this.nomeProduto = nomeProduto;
    }

    public String getCategoria()
    {
        return categoria;
    }

    public void setCategoria(String categoria)
    {
        this.categoria = categoria;
    }

    public double getTotalVendido()
    {
        return totalVendido;
    }

    public void setTotalVendido(double totalVendido)
    {
        this.totalVendido = totalVendido;
    }
}
