package br.ufrpe.gestao_feira.repositorio.interfaces;

import br.ufrpe.gestao_feira.classesbasicas.*;

import java.util.List;

public interface IVendaRepositorio extends IRepositorio<Venda>
{
    List<Venda> buscarVendasPorProdutor (Produtor produtor);
    List<Venda> buscarVendasPorProduto(Produto produto);
    List<Venda> buscarVendasPorEdicao(EdicaoFeira edicaoFeira);
}
