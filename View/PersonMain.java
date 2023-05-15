/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.stage.Modality;

/**
 *
 * @author kateromanova
 */
public class PersonMain extends Stage {
    
   public void init() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXML/FXMLPerson.fxml"));

            Scene scene = new Scene(root);
            scene.getStylesheets().add("CSS/AuthenticationPersonStyle.css");
            setTitle("Person");
            setScene(scene);
            setResizable(false);
            initModality(Modality.APPLICATION_MODAL);
            show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
