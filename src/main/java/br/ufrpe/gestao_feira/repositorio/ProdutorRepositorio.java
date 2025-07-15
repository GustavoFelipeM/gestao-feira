package br.ufrpe.gestao_feira.repositorio;

import br.ufrpe.gestao_feira.classesbasicas.Produtor;
import br.ufrpe.gestao_feira.repositorio.abstrato.RepositorioPadrao;

import java.util.ArrayList;
import java.util.List;

public class ProdutorRepositorio extends RepositorioPadrao<Produtor>
{
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
    public void add(Produtor obj)
    {
        if (!existe(obj))
        {
            lista.add(obj);
        }

        else
        {
            //TODO Criar exception caso o produtor já esteja cadastrado;

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

    public void procurarPorCpfCnpj(String cpfCnpj)
    {
        procurarPorNome(cpfCnpj);
    }

    public void procurarPorCategoria(String categoria)
    {
        procurarPorNome(categoria);
    }






}
