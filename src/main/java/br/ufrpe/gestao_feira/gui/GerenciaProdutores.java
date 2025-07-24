package br.ufrpe.gestao_feira.gui;

import br.ufrpe.gestao_feira.classesbasicas.Produtor;
import br.ufrpe.gestao_feira.service.ProdutorControlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciaProdutores {

    @FXML private ComboBox<String> comboBoxProdutoresGerenciaProdutores;
    @FXML private ComboBox<String> comboBoxAtivarDesativarGerenciaProdutores;

    private ProdutorControlador produtorControlador;
    private final Map<String, String> mapaNomeCpf = new HashMap<>();

    public void setControlador(ProdutorControlador controlador) {
        this.produtorControlador = controlador;
        carregarProdutores();
        configurarComboEstado();
    }

    private void carregarProdutores() {
        comboBoxProdutoresGerenciaProdutores.getItems().clear();
        mapaNomeCpf.clear();

        try {
            List<Produtor> lista = produtorControlador.buscarTodos();

            for (Produtor p : lista) {
                String display = p.getNome() + " - " + p.getCpfCnpj();
                comboBoxProdutoresGerenciaProdutores.getItems().add(display);
                mapaNomeCpf.put(display, p.getCpfCnpj());
            }
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao carregar produtores: " + e.getMessage());
        }
    }

    private void configurarComboEstado() {
        comboBoxAtivarDesativarGerenciaProdutores.getItems().addAll("Ativar", "Inativar");
    }

    @FXML
    private void enviar(ActionEvent evento) {
        String produtorSelecionado = comboBoxProdutoresGerenciaProdutores.getValue();
        String estadoSelecionado = comboBoxAtivarDesativarGerenciaProdutores.getValue();

        if (produtorSelecionado == null || estadoSelecionado == null) {
            mostrarAlerta("Atenção", "Selecione um produtor e o estado desejado.");
            return;
        }

        String cpf = mapaNomeCpf.get(produtorSelecionado);

        try {
            if (estadoSelecionado.equals("Ativar")) {
                produtorControlador.ativarProdutor(cpf);
            } else {
                produtorControlador.inativarProdutor(cpf);
            }
            mostrarAlerta("Sucesso", "Produtor atualizado com sucesso.");
        } catch (Exception e) {
            mostrarAlerta("Erro", "Erro ao atualizar produtor: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
