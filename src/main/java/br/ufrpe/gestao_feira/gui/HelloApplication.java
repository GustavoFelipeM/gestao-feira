package br.ufrpe.gestao_feira.gui;

import br.ufrpe.gestao_feira.repositorio.interfaces.*;
import br.ufrpe.gestao_feira.repositorio.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Instâncias únicas dos repositórios
        IProdutorRepositorio produtorRepo = ProdutorRepositorio.getInstance();
        IProdutoRepositorio produtoRepo = ProdutoRepositorio.getInstance();
        IParticipacaoRepositorio participacaoRepo = ParticipacaoRepositorio.getInstance();
        IVendaRepositorio vendaRepo = VendaRepositorio.getInstance();
        IItemVendaRepositorio  itemVendaRepo = ItemVendaRepositorio.getInstance();
        IEdicaoFeiraRepositorio  edicaoFeiraRepo = EdicaoFeiraRepositorio.getInstance();

        // Carrega a tela inicial
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/TelaPrincipal.fxml"));
        Parent root = loader.load();

        // Injeta dependências no controlador principal (se necessário)
        TelaPrincipalController controller = loader.getController();
        controller.inicializar(produtorRepo, produtoRepo, participacaoRepo, vendaRepo);

        // Exibe a janela
        primaryStage.setTitle("Sistema de Feira");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}