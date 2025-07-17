module br.ufrpe.gestao_feira.gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens br.ufrpe.gestao_feira.gui to javafx.fxml;
    exports br.ufrpe.gestao_feira.gui;
}