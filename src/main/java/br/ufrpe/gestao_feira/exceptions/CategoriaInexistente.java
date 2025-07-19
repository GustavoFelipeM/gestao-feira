package br.ufrpe.gestao_feira.exceptions;

public class CategoriaInexistente extends Exception
{
    String categoriaInexistente;
    public CategoriaInexistente(String categoria)
    {
        super("Produto ou produtor não encontrado com a seguinte categoria: " + categoria);
        this.categoriaInexistente = categoria;
    }
    public String getCategoriaInexistente()
    {
        return categoriaInexistente;
    }
}
