package br.ufrpe.gestao_feira.service;

import br.ufrpe.gestao_feira.classesbasicas.*;
import br.ufrpe.gestao_feira.repositorio.interfaces.IEdicaoFeiraRepositorio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EdicaoFeiraControlador {
    private final IEdicaoFeiraRepositorio edicaoFeiraRepositorioControlador;

    public EdicaoFeiraControlador(IEdicaoFeiraRepositorio edicaoFeiraRepositorioControlador) {
        this.edicaoFeiraRepositorioControlador = edicaoFeiraRepositorioControlador;
    }

    public void cadastrarEdicaoFeira(EdicaoFeira edicaoFeira) {
        if (edicaoFeira == null) {
            throw new IllegalArgumentException("Edição não pode ser nula");
        }
        if (edicaoFeira.getData() == null || edicaoFeira.getHorario() == null || edicaoFeira.getLocal() == null || edicaoFeira.getParticipacoes().length <= 0) {
            throw new IllegalArgumentException("Campos obrigatórios não preenchidos");
        }
        try {
            edicaoFeiraRepositorioControlador.add(edicaoFeira);
        } catch (Exception e) {
            throw new RuntimeException("Edicao Feira já cadastrada");
        }
    }

    //TODO Caso nescessário adicionar o método de checagem de bancas disponível aqui também

    public List<EdicaoFeira> buscarPorData(LocalDateTime data) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ser nula");
        }
        return edicaoFeiraRepositorioControlador.procurarPorData(data);
    }

    public List<EdicaoFeira> buscarPorHorario(LocalDateTime horario) {
        if (horario == null) {
            throw new IllegalArgumentException("Horario não pode ser nulo");
        }
        return edicaoFeiraRepositorioControlador.procurarPorHorario(horario);
    }

    public List<EdicaoFeira> buscarPorLocal(String local) {
        if (local == null || local.isBlank()) {
            throw new IllegalArgumentException("Local não pode ser nulo");
        }
        return edicaoFeiraRepositorioControlador.procurarPorLocal(local);
    }

    public List<EdicaoFeira> listarEdicoesAnteriores() {
        List<EdicaoFeira> listaDeEdicoesPassadas = new ArrayList<>();
        LocalDateTime dataAtual = LocalDateTime.now();

        for (EdicaoFeira edicaoFeira : edicaoFeiraRepositorioControlador.recuperarTudo()) {
            if (edicaoFeira.getData().isBefore(dataAtual)) {
                listaDeEdicoesPassadas.add(edicaoFeira);
            }
        }
        if (listaDeEdicoesPassadas.isEmpty()) {
            throw new RuntimeException("Não há edições anteriores cadastradas");
        }
        return listaDeEdicoesPassadas;
    }

    public List<Produtor> listarProdutoresParticipantes(EdicaoFeira edicaoFeira) {
        List<Produtor> listaDeProdutores = new ArrayList<>();
        for (Participacao p : edicaoFeira.getParticipacoes()) {
            if (p != null) {
                listaDeProdutores.add(p.getProdutor());
            }
        }
        if (listaDeProdutores.isEmpty()) {
            throw new RuntimeException("Não há produtores participantes cadastrados para essa edição");
        }
        return listaDeProdutores;
    }
}

