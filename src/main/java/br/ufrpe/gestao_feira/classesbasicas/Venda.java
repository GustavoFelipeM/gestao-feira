package br.ufrpe.gestao_feira.classesbasicas;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Produtor produtor;
    private List<ItemVenda> itensVenda;
    private EdicaoFeira edicaoFeira;
    private String observacoes;
    private int banca;

    public Venda(Produtor produtor, EdicaoFeira edicaoFeira, String observacoes)
    {
        this.produtor=produtor;
        this.edicaoFeira=edicaoFeira;
        this.observacoes=observacoes;
        this.itensVenda= new ArrayList<>();
        banca = -1;
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
    public int getBanca()
    {
        return banca;
    }
    public void setBanca(int banca)
    {
        if(this.banca == -1)
        {
            this.banca = banca;
        }
        else
        {
            throw new IllegalStateException("A banca já foi definida e não pode ser alterada."); //TODO Try/Catch IllegalStateException
        }
    }

    public String getObservacoes()
    {
        return observacoes;
    }

    public void setObservacoes(String observacoes)
    {
        this.observacoes = observacoes;
    }

    public List<ItemVenda> getItensVenda()
    {
        return itensVenda;
    }

}
