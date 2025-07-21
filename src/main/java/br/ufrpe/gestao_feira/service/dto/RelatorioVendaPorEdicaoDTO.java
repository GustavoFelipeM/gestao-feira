package br.ufrpe.gestao_feira.service.dto;

public class RelatorioVendaPorEdicaoDTO
{
    private String dataEdicao;
    private String local;
    private double totalVendido;

   public RelatorioVendaPorEdicaoDTO (String dataEdicao, String local, double totalVendido)
    {
        this.dataEdicao = dataEdicao;
        this.local = local;
        this.totalVendido = totalVendido;
    }

    public String getDataEdicao()
    {
        return dataEdicao;
    }

    public void setDataEdicao(String dataEdicao)
    {
        this.dataEdicao = dataEdicao;
    }

    public String getLocal()
    {
        return local;
    }

    public void setLocal(String local)
    {
        this.local = local;
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
