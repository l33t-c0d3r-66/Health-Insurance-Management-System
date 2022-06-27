package com.health.insurance.controller;

import com.health.insurance.DAO.PhysicianDAO;
import com.health.insurance.DAOImpl.PhysicianDAOImpl;
import com.health.insurance.beans.Physician;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class PhysiciansController implements Initializable {

    @FXML
    public TableView<Physician> tableView;
    @FXML
    public TableColumn<Physician, String> id;
    @FXML
    public TableColumn<Physician, String> name;
    @FXML
    public TableColumn<Physician, String> contact;
    @FXML
    public TableColumn<Physician, String> email;
    @FXML
    public TableColumn<Physician, String> address;

    @FXML
    public void addPhysician()
    {
        try
        {
            String fxmlFile = "/fxml/AddPhysicians.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            Stage stage= new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setMinWidth(780);
            stage.setMinHeight(580);
            stage.setMaxWidth(780);
            stage.setMaxHeight(700);

        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PhysicianDAO physicianDAO = new PhysicianDAOImpl();
        List<Physician> physicians = physicianDAO.getPhysicians();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        contact.setCellValueFactory(new PropertyValueFactory("contact"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        //Adding data to the table
        ObservableList<Physician> list = FXCollections.observableList(physicians);
        tableView.setUserData(list);
    }
}
