package br.ufrpe.gestao_feira.repositorio;

import br.ufrpe.gestao_feira.classesbasicas.EdicaoFeira;
import br.ufrpe.gestao_feira.repositorio.abstrato.RepositorioPadrao;
import br.ufrpe.gestao_feira.repositorio.interfaces.IEdicaoFeiraRepositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EdicaoFeiraRepositorio extends RepositorioPadrao<EdicaoFeira> implements IEdicaoFeiraRepositorio
{
    private static  EdicaoFeiraRepositorio instance;

    private EdicaoFeiraRepositorio()
    {
        super();
    }

    public static synchronized EdicaoFeiraRepositorio getInstance()
    {
        if (instance == null)
        {
            instance = new EdicaoFeiraRepositorio();
        }
        return instance;
    }

    @Override
    public boolean existe(EdicaoFeira edicaoFeira)
    {
        boolean existe = false;
        if (edicaoFeira != null)
        {
            LocalDateTime data = edicaoFeira.getData();
            LocalDateTime horario = edicaoFeira.getHorario();
            String local = edicaoFeira.getLocal();
            for (EdicaoFeira ef : lista)
            {
                if (ef.getData().equals(data) && ef.getHorario().equals(horario) && ef.getLocal().equals(local))
                {
                    existe = true;
                }
            }
        }
        return existe;
    }


    public List<EdicaoFeira> procurarPorLocal(String local)
    {
        List<EdicaoFeira> listaDeEdicoes = new ArrayList<>();

        for (EdicaoFeira ef : lista)
        {
            if (ef.getLocal().equals(local))
            {
                listaDeEdicoes.add(ef);
            }
        }
        return listaDeEdicoes;
    }

    public List<EdicaoFeira> procurarPorData (LocalDateTime data)
    {
        List<EdicaoFeira> listaDeEdicoes = new ArrayList<>();

        for (EdicaoFeira ef : lista)
        {
            if (ef.getData().equals(data))
            {
                listaDeEdicoes.add(ef);
            }
        }
        return listaDeEdicoes;
    }

    public List<EdicaoFeira> procurarPorHorario (LocalDateTime horario)
    {
        List<EdicaoFeira> listaDeEdicoes = new ArrayList<>();

        for (EdicaoFeira ef : lista)
        {
            if (ef.getData().equals(horario))
            {
                listaDeEdicoes.add(ef);
            }
        }
        return listaDeEdicoes;
    }


}
