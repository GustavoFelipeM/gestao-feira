package br.ufrpe.gestao_feira.classesbasicas;

import java.time.LocalDateTime;

public class EdicaoFeira {
    private LocalDateTime data;
    private LocalDateTime horario;
    private String local;
    private String descricao;
    private Participacao[] participacoes;



    public EdicaoFeira(LocalDateTime data,  LocalDateTime horario, String local, String descricao, int numeroMaximoBancas)
    {
        this.data = data;
        this.horario = horario;
        this.local = local;
        this.descricao = descricao;
        this.participacoes = new Participacao[numeroMaximoBancas];
    }

    public LocalDateTime getData()
    {
        return data;
    }
    public void setData(LocalDateTime data)
    {
        this.data = data;
    }
    public LocalDateTime getHorario()
    {
        return horario;
    }
    public void setHorario(LocalDateTime horario)
    {
        this.horario = horario;
    }
    public String getLocal()
    {
        return local;
    }
    public void setLocal(String local)
    {
        this.local = local;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public Participacao[] getParticipacoes()
    {
        return participacoes;
    }


   public boolean checarMaximoBancas()
    {
        int quantidade = 0;
        boolean estaCheio = false;
        for (int i = 0; i<participacoes.length; i++)
        {
            quantidade++;

            if (quantidade == participacoes.length)
            {
                estaCheio = true;
            }
        }
        return estaCheio;
    }


}
