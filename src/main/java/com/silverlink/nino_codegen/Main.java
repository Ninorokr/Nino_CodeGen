package com.silverlink.nino_codegen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("CodeGen2.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.initStyle(StageStyle.UNDECORATED);
        this.primaryStage.setTitle("Nino Code Generator");
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}