package br.ufrpe.gestao_feira.repositorio.interfaces;

import br.ufrpe.gestao_feira.classesbasicas.Produtor;

import java.util.List;

public interface IRepositorio<ClasseBasica>
{
    boolean existe(ClasseBasica c);
    void add (ClasseBasica c) throws Exception;
    void remove (ClasseBasica c);
    List<ClasseBasica> recuperarTudo();
}
