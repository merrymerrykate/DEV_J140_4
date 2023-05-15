/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.Users;
import Repository.Repository;
import View.PersonMain;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.xml.transform.Source;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * FXML Controller class
 *
 * @author kateromanova
 */
public class FXMLAuthentificationController implements Initializable {
    
     @FXML
    private Label userField;
    @FXML
    private Label passwordField;
    @FXML
    private TextField userText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button singIn;
    @FXML Label massage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    public void handleButtonActionSingIn(ActionEvent actionEvent) {
        Set<Users> users = new Repository().findUser();
        for (Users user : users) {
            if (userText.getText().equals(user.getName()) && passwordText.getText().equals(user.getPassword())) {
                massage.setText("");
                new PersonMain().init();
            } else {
                massage.setStyle("-fx-text-fill: RED");
                massage.setText("Пользователь не найден");
            }
        }
    }
    
}
