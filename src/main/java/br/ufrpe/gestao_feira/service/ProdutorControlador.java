package br.ufrpe.gestao_feira.service;

import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.repositorio.*;
import br.ufrpe.gestao_feira.repositorio.interfaces.*;
import br.ufrpe.gestao_feira.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ProdutorControlador
{
    private final IProdutorRepositorio repositorioControlador;
    private final IProdutoRepositorio repositorioProdutoControlador;
    private final IParticipacaoRepositorio repositorioParticipacaoControlador;

    public ProdutorControlador (IProdutorRepositorio produtorRepositorio, IProdutoRepositorio produtoRepositorio, IParticipacaoRepositorio participacaoRepositorio)
    {
        this.repositorioControlador = produtorRepositorio;
        this.repositorioProdutoControlador = produtoRepositorio;
        this.repositorioParticipacaoControlador = participacaoRepositorio;
    }

    public void cadastrarProdutor(Produtor produtor) throws Exception
    {
        if (produtor == null || produtor.getCpfCnpj() == null || produtor.getCpfCnpj().isBlank() || produtor.getNome() == null || produtor.getNome().isBlank())
        {
            throw new IllegalArgumentException("Campos obrigatórios nulos");
        }

        else
        {
            repositorioControlador.add(produtor);
        }
    }

    public void removerProdutor(Produtor produtor) throws Exception
    {
        if (!repositorioControlador.existe(produtor))
        {
            throw new ProdutorInexistenteException(produtor.getCpfCnpj());
        }
        repositorioControlador.remove(produtor);

    }

    public Produtor buscarPorCpfCnpj(String cpfCnpj) throws Exception
    {
        if (cpfCnpj == null || cpfCnpj.isBlank())
        {
            throw new IllegalArgumentException("CPF/CNPJ não pode ser nulo ou vazio");
        }

        Produtor produtor = repositorioControlador.procurarPorCpfCnpj(cpfCnpj);

        if (produtor == null)
        {
            throw new ProdutorInexistenteException(cpfCnpj);
        }
        return produtor;
    }

    public List<Produtor> buscarPorNome(String nome) throws Exception
    {
        if(nome == null || nome.isBlank())
        {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }

        List<Produtor> produtoresEncontrados =  repositorioControlador.procurarPorNome(nome);

        if(produtoresEncontrados.isEmpty())
        {
            throw new NomeInexistente(nome);
        }
        return produtoresEncontrados;


    }

    public List<Produtor> buscarPorCategoria(String categoria) throws Exception
    {
        if (categoria == null || categoria.isBlank())
        {
            throw new IllegalArgumentException("Categoria não pode ser nula ou vazia");
        }


        List <Produtor> produtoresEncontrados = repositorioControlador.procurarPorCategoria(categoria);
        if (produtoresEncontrados.isEmpty())
        {
            throw new CategoriaInexistente(categoria);
        }
        return produtoresEncontrados;

    }

    public List<Produtor> buscarTodos()
    {
      return repositorioControlador.recuperarTudo();
    }

    public void inativarProdutor(String cpfCnpj) throws Exception
    {
        if (cpfCnpj == null || cpfCnpj.isBlank())
        {
            throw new IllegalArgumentException("CPF/CNPJ não pode ser nulo ou vazio");
        }
        Produtor produtor = buscarPorCpfCnpj(cpfCnpj);
        if (produtor == null)
        {
            throw new ProdutorInexistenteException(cpfCnpj);
        }
        if(!produtor.getAtivo())
        {
            throw new IllegalStateException("Produtor já está inativo");
        }
        produtor.setAtivo(false);
    }
    public void ativarProdutor(String cpfCnpj) throws Exception
    {
        if (cpfCnpj == null || cpfCnpj.isBlank())
        {
            throw new IllegalArgumentException("CPF/CNPJ não pode ser nulo ou vazio.");
        }

        Produtor produtor = buscarPorCpfCnpj(cpfCnpj);

        if (produtor == null)
        {
            throw new IllegalStateException("Produtor não encontrado.");
        }

        if (produtor.getAtivo())
        {
            throw new IllegalStateException("Produtor já está ativo.");
        }

        produtor.setAtivo(true);
    }

    public List<Produto> buscarProdutosDoProdutor(String cpfCnpj) throws Exception
    {
        Produtor produtor = buscarPorCpfCnpj(cpfCnpj);
        List<Produto> produtosDoProdutor = repositorioProdutoControlador.procurarProdutor(produtor);
        if(produtosDoProdutor.isEmpty())
        {
            throw new ProdutorSemProdutosException(produtor);
        }
        return produtosDoProdutor;
    }

    public List<EdicaoFeira> buscarEdicoesFeiraDoProdutor(String cpfCnpj) throws Exception
    {
        Produtor produtor = buscarPorCpfCnpj(cpfCnpj);
        List<Participacao> participacoes;
        List<EdicaoFeira> edicoesFeira = new ArrayList<>();

        participacoes = repositorioParticipacaoControlador.procurarProdutor(produtor);
        for (Participacao p : participacoes)
        {
            EdicaoFeira edicao = p.getEdicaoFeira();
            if(!edicoesFeira.contains(edicao))
            {
                    edicoesFeira.add(edicao);
                }
        }
        if (edicoesFeira.isEmpty())
        {
            throw new ProdutorSemParticipacoesException(produtor);
        }
        return edicoesFeira;
    }

}
