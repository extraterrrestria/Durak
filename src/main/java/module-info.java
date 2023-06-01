module com.example.sampleproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.sampleproject to javafx.fxml;
    exports com.example.sampleproject;
    exports com.example.sampleproject.model;
    opens com.example.sampleproject.model to javafx.fxml;
}