package br.ufrpe.gestao_feira.exceptions;

public class NomeInexistente extends Exception
{
    String nomeInexistente;
    public NomeInexistente(String nome)
    {
        super("Nenhum produtor chamado " + nome + " encontrado");
        this.nomeInexistente = nome;
    }

    public String getNomeInexistente()
    {
        return nomeInexistente;
    }
}
