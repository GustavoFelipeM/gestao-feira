package br.ufrpe.gestao_feira.repositorio.abstrato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RepositorioPadrao<ClasseBasica>
{
    protected ArrayList<ClasseBasica> lista;

    public RepositorioPadrao()
    {
        this.lista = new ArrayList<>();
    }

    public boolean existe(ClasseBasica obj)
    {
        boolean existe = false;
        if (obj != null)
        {
            for (ClasseBasica c : lista)
            {
                if (obj.equals(c))
                {
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }

    public void add(ClasseBasica obj)
    {
        if (!existe(obj))
        {
            lista.add(obj);
        }
    }

    public void remove(ClasseBasica obj)
    {
        if (existe(obj))
        {
            lista.remove(obj);
        }
    }

    public List<ClasseBasica> recuperarTudo()
    {
        return Collections.unmodifiableList(this.lista);
    }




}

