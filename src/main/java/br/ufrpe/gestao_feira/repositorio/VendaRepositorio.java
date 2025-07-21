package br.ufrpe.gestao_feira.repositorio;

import br.ufrpe.gestao_feira.repositorio.abstrato.RepositorioPadrao;
import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.repositorio.interfaces.IVendaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class VendaRepositorio extends RepositorioPadrao<Venda> implements IVendaRepositorio
{

    public List<Venda> buscarVendasPorProdutor (Produtor produtor)
    {
        List<Venda> vendasDoProdutor = new ArrayList<>();

        for (Venda v : lista)
        {
            if(v.getProdutor().equals(produtor))
                {
                vendasDoProdutor.add(v);
                }
        }
        return vendasDoProdutor;
    }

    public List<Venda> buscarVendasPorProduto(Produto produto)
    {
        List<Venda> vendasComProduto = new ArrayList<>();


        for (Venda v : this.lista)
        {
            for (ItemVenda iv : v.getItensVenda())
            {
                if (iv.getProduto().equals(produto))
                {
                    vendasComProduto.add(v);
                }
            }
        }
        return vendasComProduto;
    }

    public List<Venda> buscarVendasPorEdicao(EdicaoFeira edicaoFeira) {
       List<Venda> vendasDaEdicao = new ArrayList<>();

       for (Venda v : lista)
       {
           if (v.getEdicaoFeira().equals(edicaoFeira))
               {
               vendasDaEdicao.add(v);
               }
       }
       return vendasDaEdicao;
    }
}
