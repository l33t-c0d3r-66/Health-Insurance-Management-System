package com.health.insurance.controller;

import com.health.insurance.DAO.PhysicianDAO;
import com.health.insurance.DAOImpl.PhysicianDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.Physician;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

    private PhysicianDAO physicianDAO;

    @FXML
    public void addPhysician() {
        try {
            String fxmlFile = "/fxml/AddPhysicians.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            Main.primaryStage.setScene(scene);
            Main.primaryStage.show();
            Main.primaryStage.setMinWidth(780);
            Main.primaryStage.setMinHeight(580);
            Main.primaryStage.setMaxWidth(780);
            Main.primaryStage.setMaxHeight(700);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        physicianDAO = new PhysicianDAOImpl();
        List<Physician> physicians = physicianDAO.getPhysicians();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        contact.setCellValueFactory(new PropertyValueFactory("contact"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        //Adding data to the table
        ObservableList<Physician> list = FXCollections.observableList(physicians);
        tableView.setItems(list);
    }

    @FXML
    public void back() {
        try {
            String fxmlFile = "/fxml/Dashboard.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            Main.primaryStage.setScene(scene);
            Main.primaryStage.hide();
            Main.primaryStage.show();
            Main.primaryStage.setMinWidth(780);
            Main.primaryStage.setMinHeight(580);
            Main.primaryStage.setMaxWidth(780);
            Main.primaryStage.setMaxHeight(700);

        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void removePhysician(){
        Physician physician = tableView.getSelectionModel().getSelectedItem();
        if(physician != null) {
            boolean isRemoved = physicianDAO.removePhysician(physician);
            if(isRemoved) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Success!");
                alert.setContentText("Record Deleted Successfully");
                alert.showAndWait();
                initialize(null, null);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Failure!");
                alert.setContentText("Failed to Delete Record");
                alert.showAndWait();
            }

        }
    }
}
