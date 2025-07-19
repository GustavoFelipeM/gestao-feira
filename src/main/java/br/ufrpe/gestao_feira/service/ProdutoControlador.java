package br.ufrpe.gestao_feira.service;

import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.exceptions.*;
import br.ufrpe.gestao_feira.repositorio.ProdutoRepositorio;
import br.ufrpe.gestao_feira.repositorio.interfaces.IRepositorio;

import java.util.List;

public class ProdutoControlador
{
    private final IRepositorio<Produto> repositorio;

    public ProdutoControlador(ProdutoRepositorio produtoRepositorio)
    {
        this.repositorio = produtoRepositorio;
    }

    public void cadastrarProduto(Produto produto, Produtor produtor) throws Exception
    {
        if (produto == null || produtor == null)
        {
            throw new IllegalArgumentException("Produto e produtor não podem ser nulos");
        }
        if (produto.getNome() == null || produto.getNome().isBlank() || produto.getCategoria() == null || produto.getCategoria().isBlank() || produto.getPreco() < 0)
        {
            throw new IllegalArgumentException("Campos obrigatórios inválidos");
        }
        if (!produto.getCategoria().equalsIgnoreCase(produtor.getCategoria()))
        {
            throw new ProdutoInvalidoException(produto.getCategoria(), produtor);
        }
        repositorio.add(produto);

    }
    public void removerProduto(Produto produto) throws Exception
    {
        if(!repositorio.existe(produto))
            {
                throw new ProdutoInexistenteException(produto);
            }
        repositorio.remove(produto);
    }
    public List<Produto> buscarProdutoPorNome(String nome) throws Exception
    {
        if(nome == null || nome.isBlank())
        {
            throw new IllegalArgumentException("Nome inválido");
        }
        if(repositorio instanceof ProdutoRepositorio repo)
        {
            List<Produto> produtosEncontrados = repo.procurarPorNome(nome);
            if (produtosEncontrados.isEmpty())
            {
                throw new ProdutoInexistenteException(nome);
            }
            return produtosEncontrados;
        }
        else
        {
            throw new UnsupportedOperationException("O controlador não tem acesso aos métodos do repositorio");
        }
    }
    public List<Produto> buscarTodos()
    {
        return repositorio.recuperarTudo();
    }
}

