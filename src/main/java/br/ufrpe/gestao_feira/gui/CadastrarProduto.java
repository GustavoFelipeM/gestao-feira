package br.ufrpe.gestao_feira.gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class CadastrarProduto {

    @FXML private TextField textFieldNomeCadastroProdutos;
    @FXML private TextField textFieldDescricaoCadastroProdutos;
    @FXML private TextField textFieldPrecoCadastroProdutos;
    @FXML private TextField textFieldCategoriaCadastroProdutos;
    @FXML private TextField textFieldProdutorCadastroProdutos;

    @FXML
    private void cadastrar(ActionEvent evento) {
        String nome = textFieldNomeCadastroProdutos.getText();
        String descricao = textFieldDescricaoCadastroProdutos.getText();
        String preco = textFieldPrecoCadastroProdutos.getText();
        String categoria = textFieldCategoriaCadastroProdutos.getText();
        String produtor = textFieldProdutorCadastroProdutos.getText();

        if (nome.isEmpty() || descricao.isEmpty() || preco.isEmpty() || categoria.isEmpty() || produtor.isEmpty()) {
            mostrarAlerta("Erro", "Todos os campos devem ser preenchidos.");
            return;
        }

        // Aqui você pode adicionar lógica real de salvar o produto
        mostrarAlerta("Sucesso", "Produto cadastrado com sucesso!");
        limparCampos();
    }

    @FXML
    private void sairTela(ActionEvent evento) {
        Stage stage = (Stage) ((Node) evento.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void voltarTela(ActionEvent evento) {
        // Aqui você pode abrir a tela anterior, por exemplo: TelaInicial.fxml
        mostrarAlerta("Ação", "Voltar à tela anterior.");
    }

    @FXML
    private void abrirConfig(ActionEvent evento) {
        mostrarAlerta("Ação", "Abrir tela de configurações.");
    }

    private void limparCampos() {
        textFieldNomeCadastroProdutos.clear();
        textFieldDescricaoCadastroProdutos.clear();
        textFieldPrecoCadastroProdutos.clear();
        textFieldCategoriaCadastroProdutos.clear();
        textFieldProdutorCadastroProdutos.clear();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
