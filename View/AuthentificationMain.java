/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Set;

/**
 *
 * @author kateromanova
 */
public class AuthentificationMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent gp = FXMLLoader.load(getClass().getResource("../FXML/FXMLAuthentication.fxml"));

        Scene scene = new Scene(gp,400,300);
        scene.getStylesheets().add("CSS/AuthenticationPersonStyle.css");
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}
