package br.ufrpe.gestao_feira.gui;

import br.ufrpe.gestao_feira.classesbasicas.EdicaoFeira;
import br.ufrpe.gestao_feira.service.EdicaoFeiraControlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CadastrarEdicaoFeira {

    @FXML private DatePicker dataPickerCadastroEdicaoFeira;
    @FXML private TextField textFieldHoraCadastroEdicaoFeira;
    @FXML private TextField textFieldLocalCadastroEdicaoFeira;
    @FXML private TextField textFieldDescricaoCadastroEdicaoFeira;

    private EdicaoFeiraControlador controlador;

    public void setControlador(EdicaoFeiraControlador controlador) {
        this.controlador = controlador;
    }

    @FXML
    private void cadastrar(ActionEvent evento) {
        try {
            LocalDate data = dataPickerCadastroEdicaoFeira.getValue();
            String horaTexto = textFieldHoraCadastroEdicaoFeira.getText();
            String local = textFieldLocalCadastroEdicaoFeira.getText();
            String descricao = textFieldDescricaoCadastroEdicaoFeira.getText();

            if (data == null || horaTexto.isEmpty() || local.isEmpty() || descricao.isEmpty()) {
                mostrarAlerta("Erro", "Todos os campos devem ser preenchidos.");
                return;
            }

            // Converte String de hora (ex: "08:00") para LocalTime
            LocalTime hora = LocalTime.parse(horaTexto);
            LocalDateTime dataHora = LocalDateTime.of(data, hora);

            // Valor fixo de número de bancas
            int numeroMaximoBancas = 10;

            EdicaoFeira edicao = new EdicaoFeira(dataHora, dataHora, local, descricao, numeroMaximoBancas);
            controlador.cadastrarEdicaoFeira(edicao);

            mostrarAlerta("Sucesso", "Edição de feira cadastrada com sucesso!");
            limparCampos();
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao cadastrar edição: " + e.getMessage());
        }
    }

    @FXML
    private void sairTela(ActionEvent evento) {
        Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void voltarTela(ActionEvent evento) {
        mostrarAlerta("Voltar", "Voltando para a tela anterior.");
    }

    @FXML
    private void gerenciarProdutores(ActionEvent evento) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GerenciarProdutores.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gerência de Produtores");
            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Erro", "Não foi possível abrir a tela de gerência de produtores.");
        }
    }

    private void limparCampos() {
        dataPickerCadastroEdicaoFeira.setValue(null);
        textFieldHoraCadastroEdicaoFeira.clear();
        textFieldLocalCadastroEdicaoFeira.clear();
        textFieldDescricaoCadastroEdicaoFeira.clear();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}