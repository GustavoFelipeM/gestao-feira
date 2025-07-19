package br.ufrpe.gestao_feira.repositorio.interfaces;

import br.ufrpe.gestao_feira.classesbasicas.*;

import java.util.List;

public interface IProdutorRepositorio extends IRepositorio<Produtor>
{
    List<Produtor> procurarPorNome(String nome);
    Produtor procurarPorCpfCnpj(String cpfCnpj);
    List<Produtor> procurarPorCategoria(String categoria);
}
