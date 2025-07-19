package br.ufrpe.gestao_feira.service;

import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.repositorio.*;
import br.ufrpe.gestao_feira.repositorio.interfaces.*;
import br.ufrpe.gestao_feira.exceptions.*;

import java.util.List;

public class ProdutorControlador
{
    IRepositorio<Produtor> repositorioControlador = new ProdutorRepositorio();

    public ProdutorControlador (ProdutorRepositorio produtorRepositorio)
    {
        this.repositorioControlador = produtorRepositorio;
    }

    public void cadastrarProdutor(Produtor produtor) throws Exception
    {
        if (produtor == null || produtor.getCpfCnpj().isBlank() || produtor.getCpfCnpj() == null || produtor.getNome().isBlank() || produtor.getNome() == null)
        {
            throw new IllegalArgumentException("Campos obrigatórios nulos"); //TODO Tratar essa exception
        }

        else
        {
            repositorioControlador.add(produtor);
        }
    }

    public void removerProdutor(Produtor produtor)
    {
        if (!repositorioControlador.existe(produtor))
        {
            throw new IllegalArgumentException("Produtor inexistente");
        }

        else
        {
            repositorioControlador.remove(produtor);
        }
    }

    public Produtor buscarPorCpfCnpj(String cpfCnpj) throws Exception
    {
        if (cpfCnpj == null || cpfCnpj.isBlank())
        {
            throw new IllegalArgumentException("CPF/CNPJ invalido");
        }

        if (repositorioControlador instanceof ProdutorRepositorio repo)
        {
            Produtor produtor = repo.procurarPorCpfCnpj(cpfCnpj);

            if (produtor == null)
            {
                throw new ProdutorInexistenteException(cpfCnpj);
            }
            return produtor;
        }
        else
        {
            throw new UnsupportedOperationException("Controlador não tem acesso aos métodos do repositório");
        }
    }

    public List<Produtor> buscarPorNome(String nome)
    {

    }

    public List<Produtor> buscarPorCategoria(String categoria)
    {

    }

    public List<Produtor> buscarTodos()
    {
      return repositorioControlador.recuperarTudo();
    }

    public void inativarProdutor(String cpfCnpj)
    {

    }

}
