module com.silverlink.nino_codegen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.silverlink.nino_codegen to javafx.fxml;
    exports com.silverlink.nino_codegen;
}