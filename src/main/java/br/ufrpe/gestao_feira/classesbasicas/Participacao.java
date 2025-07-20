package br.ufrpe.gestao_feira.classesbasicas;

public class Participacao {
    private Produtor produtor;
    private EdicaoFeira edicaoFeira;
    private int banca;

    public Participacao(Produtor produtor, EdicaoFeira edicaoFeira)
    {
        this.produtor = produtor;
        this.edicaoFeira = edicaoFeira;
        this.banca = -1;
    }


    public Produtor getProdutor()
    {
        return produtor;
    }

    public void setProdutor(Produtor produtor)
    {
        this.produtor = produtor;
    }

    public EdicaoFeira getEdicaoFeira()
    {
        return edicaoFeira;
    }

    public void setEdicaoFeira(EdicaoFeira edicaoFeira)
    {
        this.edicaoFeira = edicaoFeira;
    }

    public int getBanca()
    {
        return banca;
    }

    public void setBanca(int banca)
    {
        if(this.banca == -1)
        {
            this.banca = banca;
        }
        else
        {
            throw new IllegalStateException("A banca já foi definida e não pode ser alterada."); //TODO Try/Catch IllegalStateException
        }
    }

    public void inscreverEmEdicaoFutura()
    {

    }
    public void alocarBanca()
    {

    }
    public void cancelarParticipacao()
    {

    }
    public boolean verificarProdutorAtivo()
    {
        return false;
    }
    public boolean verificarPendencias()
    {
        return false;
    }
}
