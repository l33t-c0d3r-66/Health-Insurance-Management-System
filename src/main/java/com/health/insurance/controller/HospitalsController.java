package com.health.insurance.controller;

import com.health.insurance.DAO.HospitalDAO;
import com.health.insurance.DAOImpl.HospitalDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.Hospital;
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

public class HospitalsController implements Initializable {

    @FXML
    public TableView<Hospital> tableView;
    @FXML
    public TableColumn<Hospital, String> id;
    @FXML
    public TableColumn<Hospital, String> name;
    @FXML
    public TableColumn<Hospital, String> contact;
    @FXML
    public TableColumn<Hospital, String> email;
    @FXML
    public TableColumn<Hospital, String> website;
    @FXML
    public TableColumn<Hospital, String> address;

    private HospitalDAO hospitalDAO;

    @FXML
    public void addHospital() {
        try {
            String fxmlFile = "/fxml/AddHospital.fxml";
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

    @FXML
    public void removeHospital() {
        Hospital hospital = tableView.getSelectionModel().getSelectedItem();
        if(hospital != null) {
            boolean isRemoved = hospitalDAO.removeHospital(hospital);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hospitalDAO = new HospitalDAOImpl();
        List<Hospital> hospitals = hospitalDAO.getHospitals();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        contact.setCellValueFactory(new PropertyValueFactory("contact"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        website.setCellValueFactory(new PropertyValueFactory<>("website"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        //Adding data to the table
        ObservableList<Hospital> list = FXCollections.observableList(hospitals);
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
}
