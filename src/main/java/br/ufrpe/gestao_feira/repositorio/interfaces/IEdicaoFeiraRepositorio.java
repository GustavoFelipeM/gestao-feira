package br.ufrpe.gestao_feira.repositorio.interfaces;

import br.ufrpe.gestao_feira.classesbasicas.*;

import java.time.LocalDateTime;
import java.util.List;

public interface IEdicaoFeiraRepositorio extends IRepositorio<EdicaoFeira>
{
    List<EdicaoFeira> procurarPorLocal(String local);
    List<EdicaoFeira> procurarPorData (LocalDateTime data);
    List<EdicaoFeira> procurarPorHorario (LocalDateTime horario);
}
