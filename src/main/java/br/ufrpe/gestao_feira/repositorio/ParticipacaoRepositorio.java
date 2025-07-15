package br.ufrpe.gestao_feira.repositorio;

import br.ufrpe.gestao_feira.classesbasicas.EdicaoFeira;
import br.ufrpe.gestao_feira.classesbasicas.Participacao;
import br.ufrpe.gestao_feira.classesbasicas.Produtor;
import br.ufrpe.gestao_feira.repositorio.abstrato.RepositorioPadrao;

import java.util.ArrayList;
import java.util.List;


public class ParticipacaoRepositorio extends RepositorioPadrao<Participacao>
{

    public List<Participacao> procurarProdutor(Produtor produtor)
    {
        List<Participacao> participacoes = new ArrayList<Participacao>();

        for (Participacao p : lista)
        {
            if(p.getProdutor().equals(produtor))
            {
                participacoes.add(p);
            }
        }

        return participacoes;
    }

    public List<Participacao> procurarEdicao(EdicaoFeira edicao)
    {
        List<Participacao> participacoes = new ArrayList<>();

        for (Participacao p : lista)
        {
            if (p.getEdicaoFeira().equals(edicao))
            {
                participacoes.add(p);
            }
        }
        return participacoes;
    }



}
