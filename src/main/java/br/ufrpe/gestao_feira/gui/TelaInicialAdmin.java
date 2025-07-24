package br.ufrpe.gestao_feira.gui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaInicialAdmin {

    @FXML
    private void cadastrarEdicaoFeira(ActionEvent evento) {
        mostrarAlerta("Ação", "Abrir tela para cadastrar edição da feira.");
        // abrirTela("/caminho/para/TelaCadastroEdicaoFeira.fxml");
    }

    @FXML
    private void abrirRelatoriosFeira(ActionEvent evento) {
        mostrarAlerta("Ação", "Abrir tela de relatórios da feira.");
        // abrirTela("/caminho/para/TelaRelatorios.fxml");
    }

    @FXML
    private void abrirConfig(ActionEvent evento) {
        mostrarAlerta("Ação", "Abrir configurações do sistema.");
        // abrirTela("/caminho/para/TelaConfiguracoes.fxml");
    }

    @FXML
    private void sairTela(ActionEvent evento) {
        Stage stage = (Stage) ((javafx.scene.Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void abrirTela(String caminhoFXML) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(caminhoFXML));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlerta("Erro", "Erro ao abrir a tela: " + caminhoFXML);
        }
    }
}