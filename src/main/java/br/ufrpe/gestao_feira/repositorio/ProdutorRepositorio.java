package br.ufrpe.gestao_feira.repositorio;

import br.ufrpe.gestao_feira.classesbasicas.Produtor;
import br.ufrpe.gestao_feira.exceptions.ProdutorExistenteException;
import br.ufrpe.gestao_feira.repositorio.abstrato.RepositorioPadrao;
import br.ufrpe.gestao_feira.exceptions.*;
import br.ufrpe.gestao_feira.repositorio.interfaces.IProdutorRepositorio;

import java.util.ArrayList;
import java.util.List;

public class ProdutorRepositorio extends RepositorioPadrao<Produtor> implements IProdutorRepositorio
{
    private static ProdutorRepositorio instance;

    private ProdutorRepositorio()
    {
        super();
    }

    public static synchronized ProdutorRepositorio getInstance()
    {
        if (instance == null)
        {
            instance = new ProdutorRepositorio();
        }
        return instance;
    }

    @Override
    public boolean existe(Produtor obj)
    {
        boolean existe = false;
        if(obj != null)
        {
            String CpfCnpj = obj.getCpfCnpj();
            {
                for (Produtor i : lista)
                {
                    if (i.getCpfCnpj().equals(CpfCnpj))
                    {
                        existe = true;
                        break;
                    }
                }
            }
        }
        return existe;
    }

    @Override
    public void add(Produtor obj) throws ProdutorExistenteException
    {
        if (!existe(obj))
        {
            lista.add(obj);
        }

        else
        {
            throw new ProdutorExistenteException(obj);

        }
    }


    public List<Produtor> procurarPorNome(String nome)
    {
        List<Produtor> listaDeProdutores = new ArrayList<>();
        for (Produtor i : lista)
        {
            if (i.getNome().equalsIgnoreCase(nome))
            {
                listaDeProdutores.add(i);
            }
        }
        return listaDeProdutores;

    }

    public Produtor procurarPorCpfCnpj(String cpfCnpj) //TODO adicionar exceptions para parametro nulo e para quando retornar nulo
    {
        Produtor p = null;
        for (Produtor i : lista)
        {
            if (i.getCpfCnpj().equalsIgnoreCase(cpfCnpj))
            {
                p = i;
                break;
            }
        }
        return p;
    }

    public List<Produtor> procurarPorCategoria(String categoria)
    {
        List<Produtor> listaDeProdutores = new ArrayList<>();
        for (Produtor i : lista)
        {
            if (i.getCategoria().equalsIgnoreCase(categoria))
            {
                listaDeProdutores.add(i);
            }
        }
        return listaDeProdutores;
    }






}
