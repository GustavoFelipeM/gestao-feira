package br.ufrpe.gestao_feira.gui;

import br.ufrpe.gestao_feira.classesbasicas.Produto;
import br.ufrpe.gestao_feira.classesbasicas.Produtor;
import br.ufrpe.gestao_feira.service.ProdutoControlador;
import br.ufrpe.gestao_feira.service.ProdutorControlador;
import br.ufrpe.gestao_feira.exceptions.ProdutorInexistenteException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CadastrarProduto {

    @FXML private TextField textFieldNomeCadastroProdutos;
    @FXML private TextField textFieldDescricaoCadastroProdutos;
    @FXML private TextField textFieldPrecoCadastroProdutos;
    @FXML private TextField textFieldCategoriaCadastroProdutos;
    @FXML private TextField textFieldProdutorCadastroProdutos;

    private ProdutoControlador produtoControlador;
    private ProdutorControlador produtorControlador;

    // ✅ Injeção de dependência dos controladores
    public void setControladores(ProdutoControlador produtoCtrl, ProdutorControlador produtorCtrl) {
        this.produtoControlador = produtoCtrl;
        this.produtorControlador = produtorCtrl;
    }

    @FXML
    private void cadastrar(ActionEvent evento) {
        try {
            String nome = textFieldNomeCadastroProdutos.getText();
            String descricao = textFieldDescricaoCadastroProdutos.getText();
            double preco = Double.parseDouble(textFieldPrecoCadastroProdutos.getText());
            String categoria = textFieldCategoriaCadastroProdutos.getText();
            String cpfProdutor = textFieldProdutorCadastroProdutos.getText();

            // Buscar o produtor real pelo CPF
            Produtor produtor = produtorControlador.buscarPorCpfCnpj(cpfProdutor);

            Produto produto = new Produto(nome, descricao, categoria, preco);

            produtoControlador.cadastrarProduto(produto, produtor);

            mostrarAlerta("Sucesso", "Produto cadastrado com sucesso!");
            limparCampos();

        } catch (ProdutorInexistenteException e) {
            mostrarAlerta("Erro", "Produtor com CPF informado não encontrado.");
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Preço inválido.");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private void limparCampos() {
        textFieldNomeCadastroProdutos.clear();
        textFieldDescricaoCadastroProdutos.clear();
        textFieldPrecoCadastroProdutos.clear();
        textFieldCategoriaCadastroProdutos.clear();
        textFieldProdutorCadastroProdutos.clear();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
