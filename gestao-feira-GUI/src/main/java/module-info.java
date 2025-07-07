module com.gestaofeiragui.gestaofeiragui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.gestaofeiragui.gestaofeiragui to javafx.fxml;
    exports com.gestaofeiragui.gestaofeiragui;
}