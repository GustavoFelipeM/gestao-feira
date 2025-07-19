package br.ufrpe.gestao_feira.service;

import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.repositorio.*;
import br.ufrpe.gestao_feira.repositorio.interfaces.*;
import br.ufrpe.gestao_feira.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ProdutorControlador
{
    private final IRepositorio<Produtor> repositorioControlador;
    private final IRepositorio<Produto> repositorioProdutoControlador;
    private final IRepositorio<Participacao> repositorioParticipacaoControlador;

    public ProdutorControlador (ProdutorRepositorio produtorRepositorio, ProdutoRepositorio produtoRepositorio, ParticipacaoRepositorio participacaoRepositorio)
    {
        this.repositorioControlador = produtorRepositorio;
        this.repositorioProdutoControlador = produtoRepositorio;
        this.repositorioParticipacaoControlador = participacaoRepositorio;
    }

    public void cadastrarProdutor(Produtor produtor) throws Exception
    {
        if (produtor == null || produtor.getCpfCnpj() == null || produtor.getCpfCnpj().isBlank() || produtor.getNome() == null || produtor.getNome().isBlank())
        {
            throw new IllegalArgumentException("Campos obrigatórios nulos"); //TODO Tratar essa exception
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

    public List<Produtor> buscarPorNome(String nome) throws Exception
    {
        if(nome == null || nome.isBlank())
        {
            throw new IllegalArgumentException("Nome invalido");
        }

        if(repositorioControlador instanceof ProdutorRepositorio)
        {
            List<Produtor> produtoresEncontrados = ((ProdutorRepositorio) repositorioControlador).procurarPorNome(nome);

            if(produtoresEncontrados.isEmpty())
            {
                throw new NomeInexistente(nome);
            }
            return produtoresEncontrados;

        }

        else
        {
            throw new UnsupportedOperationException("Controlador não tem acesso aos métodos do repositório");
        }

    }

    public List<Produtor> buscarPorCategoria(String categoria) throws Exception
    {
        if (categoria == null || categoria.isBlank())
        {
            throw new IllegalArgumentException("Categoria invalida");
        }

        if (repositorioControlador instanceof ProdutorRepositorio repo)
        {
            List <Produtor> produtoresEncontrados = repo.procurarPorCategoria(categoria);
            if (produtoresEncontrados == null)
            {
                throw new CategoriaInexistente(categoria);
            }
            return produtoresEncontrados;
        }
        else
        {
            throw new UnsupportedOperationException("Controlador não tem acesso aos métodos do repositório");
        }
    }

    public List<Produtor> buscarTodos()
    {
      return repositorioControlador.recuperarTudo();
    }

    public void inativarProdutor(String cpfCnpj) throws Exception
    {
        try
        {
            Produtor produtor = buscarPorCpfCnpj(cpfCnpj);
            produtor.setAtivo(false);
        }
        catch (ProdutorInexistenteException produtorNaoEncontrado)
        {
            throw new IllegalArgumentException("CPF/CNPJ invalido", produtorNaoEncontrado);
        }
    }

    public List<Produto> buscarProdutosDoProdutor(String cpfCnpj) throws Exception
    {
        Produtor produtor = buscarPorCpfCnpj(cpfCnpj);
        if (repositorioProdutoControlador instanceof ProdutoRepositorio repo)
        {
           List<Produto> produtosDoProdutor = repo.procurarProdutor(produtor);
           if(produtosDoProdutor.isEmpty())
           {
               throw new ProdutorSemProdutosException(produtor);
           }
           return produtosDoProdutor;
        }
        else
        {
            throw new UnsupportedOperationException("Controlador não tem acesso aos métodos do repositório");
        }
    }

    public List<EdicaoFeira> buscarEdicoesFeiraDoProdutor(String cpfCnpj) throws Exception
    {
        Produtor produtor = buscarPorCpfCnpj(cpfCnpj);
        List<Participacao> participacoes;
        List<EdicaoFeira> edicoesFeira = new ArrayList<>();
        if (repositorioParticipacaoControlador instanceof ParticipacaoRepositorio repo)
        {
            participacoes = repo.procurarProdutor(produtor);
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
        else
        {
            throw new UnsupportedOperationException("Controlador não tem acesso aos métodos do repositório");
        }

    }

}
