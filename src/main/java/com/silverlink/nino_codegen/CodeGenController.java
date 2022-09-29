package com.silverlink.nino_codegen;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CodeGenController implements Initializable {

    @FXML private MenuItem mnIt_Nuevo;
    @FXML private TextField txt_ProyNombre = new TextField();
    @FXML private TextArea txtf_ProyDescripcion = new TextArea();
    @FXML private Button btnAceptar;
    @FXML Stage stage;
    @FXML private ImageView imgMinimize;
    @FXML private ImageView imgMaximize;
    @FXML private ImageView imgClose;
    @FXML public Label lblTitle = new Label("");

    Stage primaryStage = Main.getInstance().primaryStage;

    private double x, y;
    boolean isInitialized = false;

    public void mnIt_NuevoOnAction() throws IOException {
//        if(!isInitialized){
//            isInitialized = true;
            Parent nuevoProyecto = FXMLLoader.load(getClass().getResource("CodeGen_NuevoProyecto2.fxml"));
            Scene nuevoProyScene = new Scene(nuevoProyecto);
            nuevoProyScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
//            stage.initModality(Modality.WINDOW_MODAL);
//            stage.initOwner(Main.getInstance().primaryStage);
            stage.setTitle("Nuevo Proyecto");
            stage.setScene(nuevoProyScene);
//        }
        stage.show();
    }

    public void nvoProyecto_btnAceptarOnAction(MouseEvent e){
        Stage primaryStage = Main.getInstance().primaryStage;
        primaryStage.setTitle(primaryStage.getTitle() + " - " + txt_ProyNombre.getText());
        lblTitle.setText(lblTitle.getText() + " - " + txt_ProyNombre.getText());
        System.out.println(primaryStage.getTitle());
        System.out.println(lblTitle.getText());
        Stage thisStage = (Stage)((Node) e.getSource()).getScene().getWindow();
        thisStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblTitle.setText("Nino CodeGen");
//        txt_ProyNombre.textProperty().bind(lblTitle.textProperty());
//        lblTitle.textProperty().bind(txt_ProyNombre.textProperty());
//        txt_ProyNombre.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
//                lblTitle.setText(lblTitle.getText() + " - " + txt_ProyNombre.getText());
//            }
//        });

//        lblTitle.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
//                lblTitle.setText(txt_ProyNombre.getText());
//            }
//        });
    }

    @FXML
    public void dragged(MouseEvent e){
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        stage.setX(e.getScreenX() - x);
        stage.setY(e.getScreenY() - y);
    }

    @FXML
    public void pressed(MouseEvent e){
        x = e.getSceneX();
        y = e.getSceneY();
    }

    public void imgMinimizeOnPressed(){imgMinimize.setFitHeight(imgMinimize.getFitHeight()-5);}
    public void imgMinimizeOnReleased(){imgMinimize.setFitHeight(imgMinimize.getFitHeight()+5);}
    public void imgMaximizeOnPressed(){imgMaximize.setFitHeight(imgMaximize.getFitHeight()-5);}
    public void imgMaximizeOnReleased(MouseEvent e) {
        double lastPosX = e.getSceneX();
        double lastPosY = e.getSceneY();
        imgMaximize.setFitHeight(imgMaximize.getFitHeight() + 5);
        if(primaryStage.isMaximized()) {
            primaryStage.setMaximized(false);
            primaryStage.setX(lastPosX);
            primaryStage.setY(lastPosY);
        }
        else primaryStage.setMaximized(true);
    }
    public void imgCloseOnPressed(){imgClose.setFitHeight(imgClose.getFitHeight()-5);}
    public void imgCloseOnReleased(MouseEvent e){imgClose.setFitHeight(imgClose.getFitHeight()+5);
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
                                    stage.close();}
}
