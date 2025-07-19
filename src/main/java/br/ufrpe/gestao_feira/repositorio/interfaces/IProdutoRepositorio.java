package br.ufrpe.gestao_feira.repositorio.interfaces;

import br.ufrpe.gestao_feira.classesbasicas.*;

import java.util.List;

public interface IProdutoRepositorio extends IRepositorio<Produto>
{
    List<Produto> procurarPorNome(String nome);
    List<Produto> procurarProdutor(Produtor produtor);
}
