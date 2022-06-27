package com.health.insurance.controller;

import com.health.insurance.DAO.PharmacyDAO;
import com.health.insurance.DAOImpl.PharmacyDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.Pharmacy;
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

public class PharmaciesController implements Initializable {

    @FXML
    public TableView<Pharmacy> tableView;
    @FXML
    public TableColumn<Pharmacy, String> id;
    @FXML
    public TableColumn<Pharmacy, String> name;
    @FXML
    public TableColumn<Pharmacy, String> contact;
    @FXML
    public TableColumn<Pharmacy, String> email;
    @FXML
    public TableColumn<Pharmacy, String> website;
    @FXML
    public TableColumn<Pharmacy, String> address;

    private PharmacyDAO pharmacyDAO;

    @FXML
    public void addPharmacy() {
        try {
            String fxmlFile = "/fxml/AddPharmacy.fxml";
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
    public void removePharmacy() {
        Pharmacy pharmacy = tableView.getSelectionModel().getSelectedItem();
        if(pharmacy != null) {
            boolean isRemoved = pharmacyDAO.removePharmacy(pharmacy);
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pharmacyDAO = new PharmacyDAOImpl();
        List<Pharmacy> pharmacies = pharmacyDAO.getPharmacies();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        contact.setCellValueFactory(new PropertyValueFactory("contact"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        website.setCellValueFactory(new PropertyValueFactory<>("website"));
        //Adding data to the table
        ObservableList<Pharmacy> list = FXCollections.observableList(pharmacies);
        tableView.setItems(list);
    }
}
