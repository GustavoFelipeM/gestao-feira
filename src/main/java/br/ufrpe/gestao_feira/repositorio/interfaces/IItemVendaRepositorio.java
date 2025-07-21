package br.ufrpe.gestao_feira.repositorio.interfaces;

import br.ufrpe.gestao_feira.classesbasicas.ItemVenda;
import br.ufrpe.gestao_feira.classesbasicas.Produto;

import java.util.List;

public interface IItemVendaRepositorio extends IRepositorio<ItemVenda>
{
    List<ItemVenda> procurarPorProduto (Produto produto);
}
