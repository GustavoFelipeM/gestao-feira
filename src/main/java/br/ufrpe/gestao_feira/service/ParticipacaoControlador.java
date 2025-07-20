package br.ufrpe.gestao_feira.service;

import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.exceptions.ProdutorInativoException;
import br.ufrpe.gestao_feira.repositorio.interfaces.IParticipacaoRepositorio;

public class ParticipacaoControlador
{
    private final IParticipacaoRepositorio repostorioParticipacao;

    public ParticipacaoControlador (IParticipacaoRepositorio repostorioParticipacao)
    {
        this.repostorioParticipacao = repostorioParticipacao;
    }
    public void agendarParticipacao(Produtor produtor, EdicaoFeira edicao) throws Exception
    {
        if (produtor == null || edicao == null)
        {
            throw new IllegalArgumentException("Produtor e edição não podem ser nulos.");
        }

        if (!produtor.getAtivo())
        {
            throw new ProdutorInativoException(produtor);
        }

        Participacao[] participacoes = edicao.getParticipacoes();

        for (Participacao p : participacoes)
        {
            if(p != null && p.getProdutor().equals(produtor))
            {
                throw new IllegalStateException("Produtor já inscrito nesta edição");
            }
        }

        if (edicao.checarMaximoBancas())
        {
            throw new IllegalStateException("Não é possível adicionar mais produtores, limite de bancas atingido");
        }

        for (int i = 0; i<participacoes.length; i++)
        {
            if (participacoes[i] == null)
            {
                Participacao nova = new Participacao(produtor, edicao);
                nova.setBanca(i);
                participacoes[i] = nova;
                repostorioParticipacao.add(nova);
                return;
            }
        }

    }
    public void cancelarParticipacao(Produtor produtor, EdicaoFeira edicaoFeira) throws Exception
    {
        if (produtor == null || edicaoFeira == null)
        {
            throw new IllegalArgumentException("Produtor ou edição não podem ser nulos.");
        }
        Participacao[] participacoes = edicaoFeira.getParticipacoes();
        for (int i = 0; i < participacoes.length; i++)
        {
            Participacao p = participacoes[i];
            if (p != null && p.getProdutor().equals(produtor))
            {
                participacoes[i] = null;
                repostorioParticipacao.remove(p);
                return;
            }
        }
        throw new IllegalStateException("Participação não encontrada para cancelamento");
    }
}
