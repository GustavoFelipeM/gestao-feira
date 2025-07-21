package br.ufrpe.gestao_feira.service.dto;

public class RelatorioVendaPorProdutorDTO
{
    private String nomeProdutor;
    private String categoria;
    private double totalVendido;

    public RelatorioVendaPorProdutorDTO(String nomeProdutor, String categoria, double totalVendido) {
        this.nomeProdutor = nomeProdutor;
        this.categoria = categoria;
        this.totalVendido = totalVendido;
    }

    public String getNomeProdutor()
    {
        return nomeProdutor;
    }

    public void setNomeProdutor(String nomeProdutor)
    {
        this.nomeProdutor = nomeProdutor;
    }

    public String getCategoria() {
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
