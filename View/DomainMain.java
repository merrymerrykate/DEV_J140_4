/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.FXMLDomainController;
import Controller.PersonDto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author kateromanova
 */
public class DomainMain extends Stage {
    
    public void init(PersonDto personDto){
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FXML/FXMLDomain.fxml"));
            root = loader.load();
            ((FXMLDomainController)loader.getController()).initDomainsTable(personDto);

            Scene scene = new Scene(root);
            scene.getStylesheets().add("CSS/domainsStyle1.css");
            setTitle("Domains");
            setScene(scene);
            initModality(Modality.APPLICATION_MODAL);
            setResizable(false);
            showAndWait();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
