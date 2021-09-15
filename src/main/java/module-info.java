module com.example.uppgift2objektivering {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.uppgift2objektivering to javafx.fxml;
    exports com.example.uppgift2objektivering;
}