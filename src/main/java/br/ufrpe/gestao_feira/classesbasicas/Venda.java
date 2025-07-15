package br.ufrpe.gestao_feira.classesbasicas;

import java.util.ArrayList;

public class Venda {
    private Produtor produtor;
    private ArrayList<ItemVenda> itensVenda;
    private EdicaoFeira edicaoFeira;
    private String observacoes;

    public Venda(Produtor produtor, EdicaoFeira edicaoFeira, String observacoes)
    {
        this.produtor=produtor;
        this.edicaoFeira=edicaoFeira;
        this.observacoes=observacoes;
        this.itensVenda= new ArrayList<>();
    }

    public void adicionarItemVenda(ItemVenda itemVenda)
    {
        this.itensVenda.add(itemVenda);
    }

    public void removerItemVenda(ItemVenda itemVenda)
    {
        this.itensVenda.remove(itemVenda);
    }



    // getters and setters
    public Produtor getProdutor()
    {
        return produtor;
    }

    public void setProdutor(Produtor produtor)
    {
        this.produtor = produtor;
    }


    public EdicaoFeira getEdicaoFeira()
    {
        return edicaoFeira;
    }

    public void setEdicaoFeira(EdicaoFeira edicaoFeira)
    {
        this.edicaoFeira = edicaoFeira;
    }

    public double calcularVendaTotal()
    {
        double vendaTotal = 0;
        for (ItemVenda itemVenda : itensVenda)
        {
            vendaTotal += itemVenda.getValorTotal();
        }
        return vendaTotal;

    }

    public String getObservacoes()
    {
        return observacoes;
    }

    public void setObservacoes(String observacoes)
    {
        this.observacoes = observacoes;
    }

    public ArrayList<ItemVenda> getItensVenda()
    {
        return itensVenda;
    }

}
