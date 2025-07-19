package br.ufrpe.gestao_feira.repositorio.interfaces;

import br.ufrpe.gestao_feira.classesbasicas.EdicaoFeira;
import br.ufrpe.gestao_feira.classesbasicas.Participacao;
import br.ufrpe.gestao_feira.classesbasicas.Produtor;

import java.util.List;

public interface IParticipacaoRepositorio extends IRepositorio<Participacao>
{
    List<Participacao> procurarProdutor(Produtor produtor);
    List<Participacao> procurarEdicao(EdicaoFeira edicao);
}
