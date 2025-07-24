package br.ufrpe.gestao_feira.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaLogin {

    @FXML
    private TextField textFieldCpfCnpjTelaLogin;

    @FXML
    private PasswordField passwordFieldSenhaTelaLogin;

    @FXML
    private void login(ActionEvent evento) {
        String cpfCnpj = textFieldCpfCnpjTelaLogin.getText();
        String senha = passwordFieldSenhaTelaLogin.getText();

        if (cpfCnpj == null || cpfCnpj.isEmpty() || senha == null || senha.isEmpty()) {
            mostrarAlerta("Erro", "CPF/CNPJ ou senha não podem estar vazios.");
            return;
        }

        if (cpfCnpj.equals("000.000.000-00") && senha.equals("admin")) {
            abrirTela("/TelaInicialAdmin.fxml");
        } else if (senha.equals("produtor")) {
            abrirTela("/TelaInicial.fxml");
        } else {
            mostrarAlerta("Falha de login", "CPF/CNPJ ou senha inválidos.");
        }
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
            stage.setTitle("Sistema de Gestão de Feiras");
            stage.setScene(new Scene(root));
            stage.show();

            // Fecha a tela atual
            Stage telaAtual = (Stage) textFieldCpfCnpjTelaLogin.getScene().getWindow();
            telaAtual.close();
        } catch (IOException e) {
            mostrarAlerta("Erro", "Erro ao abrir a próxima tela.");
            e.printStackTrace();
        }
    }
}
