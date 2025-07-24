package br.ufrpe.gestao_feira.repositorio;

import br.ufrpe.gestao_feira.classesbasicas.ItemVenda;
import br.ufrpe.gestao_feira.classesbasicas.Produto;
import br.ufrpe.gestao_feira.repositorio.abstrato.RepositorioPadrao;
import br.ufrpe.gestao_feira.repositorio.interfaces.IItemVendaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ItemVendaRepositorio extends RepositorioPadrao<ItemVenda> implements IItemVendaRepositorio
{
    private static  ItemVendaRepositorio instance;

    private ItemVendaRepositorio()
    {
        super();
    }

    public static synchronized ItemVendaRepositorio getInstance()
    {
        if (instance == null)
        {
            instance = new ItemVendaRepositorio();
        }
        return instance;
    }


   public List<ItemVenda> procurarPorProduto (Produto produto)
   {
        List<ItemVenda> itemVendas = new ArrayList<>();

        for(ItemVenda iv : lista)
        {
            if (iv.getProduto().equals(produto))
                {
                itemVendas.add(iv);
                }
        }
        return itemVendas;
   }
}
