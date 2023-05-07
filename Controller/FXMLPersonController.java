/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package Controller;

import Model.Domain;
import Model.Person;
import Repository.Repository;
import View.DomainMain;
import View.PersonMain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author kateromanova
 */
public class FXMLPersonController implements Initializable {
    
    @FXML
    private TableView<PersonDto> personTable;
    @FXML
    private TableColumn<PersonDto, Integer> idCol;
    @FXML
    private TableColumn<PersonDto, String> jobTitle;
    @FXML
    private TableColumn<PersonDto, String> firstNameLastName;
    @FXML
    private TableColumn<PersonDto, String> phone;
    @FXML
    private TableColumn<PersonDto, String> email;
    @FXML
    private TableColumn<PersonDto, Integer> countCol;


    @FXML
    private void handlerDoubleClicked(MouseEvent event) {
        if (event.getClickCount() == 2) {
           Integer id = personTable.getSelectionModel().getSelectedItem().getId();
           PersonDto personDto = new PersonDto(id);
           new DomainMain().init(personDto);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Repository repository = new Repository();
        Set<Person> persons = (Set<Person>) repository.getAllPersonWithDomain();
        Set<PersonDto> personDto = persons.stream().map(person -> new PersonDto(person)).collect(Collectors.toSet());
        ObservableList<PersonDto> odsPerson = FXCollections.observableArrayList(personDto);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        jobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        firstNameLastName.setCellValueFactory(new PropertyValueFactory<>("firstNameLastName"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        countCol.setCellValueFactory(new PropertyValueFactory<>("domainCount"));
        personTable.setItems(odsPerson);
    }
    
    
}
