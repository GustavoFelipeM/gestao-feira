package br.ufrpe.gestao_feira.repositorio;

import br.ufrpe.gestao_feira.classesbasicas.Produto;
import br.ufrpe.gestao_feira.classesbasicas.Produtor;
import br.ufrpe.gestao_feira.repositorio.abstrato.RepositorioPadrao;
import br.ufrpe.gestao_feira.repositorio.interfaces.IProdutoRepositorio;
import br.ufrpe.gestao_feira.repositorio.interfaces.IRepositorio;

import java.util.ArrayList;
import java.util.List;


public class ProdutoRepositorio extends RepositorioPadrao<Produto> implements IProdutoRepositorio
{
    private static ProdutoRepositorio instance;

    private ProdutoRepositorio()
    {
        super();
    }

    public static synchronized ProdutoRepositorio getInstance()
    {
        if (instance == null)
        {
            instance = new ProdutoRepositorio();
        }
        return instance;
    }

    @Override
    public void add(Produto obj)
    {
        if (obj != null)
        {
             //TODO Talvez implementar categorias fixas por índice
            lista.add(obj);
        }
    }


    public List<Produto> procurarPorNome(String nome)
    {
        List<Produto> listaNome = new ArrayList<>();
        for (Produto p : lista)
        {
            if (p.getNome().equalsIgnoreCase(nome))
            {
                listaNome.add(p);
            }
        }
        return listaNome;
    }


    public List<Produto> procurarProdutor(Produtor produtor)
    {

        List<Produto> produtosDoProdutor = new ArrayList<>();
        for (Produto p: lista)
        {
            if (produtor.equals(p.getProdutorAssociado()))
            {
                produtosDoProdutor.add(p);

            }
        }
        return produtosDoProdutor;
    }



}
