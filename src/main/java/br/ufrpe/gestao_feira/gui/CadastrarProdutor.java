package br.ufrpe.gestao_feira.gui;

import br.ufrpe.gestao_feira.classesbasicas.Produtor;
import br.ufrpe.gestao_feira.repositorio.interfaces.*;
import br.ufrpe.gestao_feira.service.ProdutorControlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CadastrarProdutor {

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCpfCnpj;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoCategoria;

    @FXML
    private Label labelMensagem;

    private ProdutorControlador produtorControlador;

    public void inicializar(IProdutorRepositorio produtorRepositorio, IProdutoRepositorio produtoRepositorio, IParticipacaoRepositorio participacaoRepositorio)
    {
        this.produtorControlador = new ProdutorControlador(produtorRepositorio, produtoRepositorio, participacaoRepositorio);
    }

    @FXML
    private void salvarProdutor(ActionEvent event) {
        try {
            String nome = campoNome.getText();
            String cpfCnpj = campoCpfCnpj.getText();
            String telefone = campoTelefone.getText();
            String email = campoEmail.getText();
            String categoria = campoCategoria.getText();

            Produtor produtor = new Produtor(nome, cpfCnpj, telefone, email, categoria);
            produtorControlador.cadastrarProdutor(produtor);

            labelMensagem.setText("Produtor cadastrado com sucesso!");
            limparCampos();
        } catch (Exception e) {
            labelMensagem.setText("Erro ao cadastrar: " + e.getMessage());
        }
    }

    private void limparCampos() {
        campoNome.clear();
        campoCpfCnpj.clear();
        campoTelefone.clear();
        campoEmail.clear();
        campoCategoria.clear();
    }
}
