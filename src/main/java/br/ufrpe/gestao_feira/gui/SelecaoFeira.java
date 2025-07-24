package br.ufrpe.gestao_feira.gui;

import br.ufrpe.gestao_feira.classesbasicas.EdicaoFeira;
import br.ufrpe.gestao_feira.service.EdicaoFeiraControlador;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelecaoFeira {

    @FXML
    private ComboBox<String> comboBoxEdicoesFeiraSelecaoFeiras;

    private final EdicaoFeiraControlador controlador = new EdicaoFeiraControlador();
    private Map<String, EdicaoFeira> mapaEdicoes = new HashMap<>();

    @FXML
    private void initialize() {
        List<EdicaoFeira> edicoes = controlador.listar();

        for (EdicaoFeira edicao : edicoes) {
            String chave = gerarDescricao(edicao);
            comboBoxEdicoesFeiraSelecaoFeiras.getItems().add(chave);
            mapaEdicoes.put(chave, edicao);
        }
    }

    @FXML
    private void comboBoxSelecionada(ActionEvent evento) {
        String selecao = comboBoxEdicoesFeiraSelecaoFeiras.getValue();
        if (selecao != null) {
            mostrarAlerta("Feira Selecionada", "Você selecionou: " + selecao);
        }
    }

    @FXML
    private void enviar(ActionEvent evento) {
        String chave = comboBoxEdicoesFeiraSelecaoFeiras.getValue();
        if (chave == null) {
            mostrarAlerta("Erro", "Por favor, selecione uma edição de feira.");
            return;
        }

        EdicaoFeira edicaoSelecionada = mapaEdicoes.get(chave);
        mostrarAlerta("Confirmado", "Edição selecionada:\n" + gerarDescricao(edicaoSelecionada));
        // Aqui você pode armazenar ou navegar com essa edição
    }

    @FXML
    private void sairTela(ActionEvent evento) {
        Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void voltarTela(ActionEvent evento) {
        mostrarAlerta("Ação", "Voltar para a tela anterior.");
    }

    @FXML
    private void abrirConfig(ActionEvent evento) {
        mostrarAlerta("Ação", "Abrir configurações.");
    }

    private String gerarDescricao(EdicaoFeira edicao) {
        return edicao.getData() + " - " + edicao.getLocal(); // Ajuste conforme seu modelo
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}