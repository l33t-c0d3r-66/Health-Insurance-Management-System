package com.health.insurance.controller;

import com.health.insurance.DAO.PharmacyDAO;
import com.health.insurance.DAOImpl.PharmacyDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.Pharmacy;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class AddPharmacyController {

    @FXML
    JFXTextField pharmacyName;
    @FXML
    JFXTextField address;
    @FXML
    JFXTextField contactNumber;
    @FXML
    JFXTextField email;
    @FXML
    JFXTextField website;

    @FXML
    public void addPharmacy() {
        String name = pharmacyName.getText();
        String pharmacyAddress = address.getText();
        String number = contactNumber.getText();
        String emailAddress = email.getText();
        String websiteUrl = website.getText();
        Pharmacy pharmacy = new Pharmacy(name, number, emailAddress, websiteUrl,pharmacyAddress);
        PharmacyDAO pharmacyDAO = new PharmacyDAOImpl();
        boolean isAdded = pharmacyDAO.savePharmacy(pharmacy);
        if(isAdded) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Success!");
            alert.setContentText("Record Saved Successfully");
            alert.showAndWait();
            gotoDashboard();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Failure!");
            alert.setContentText("Failed to Save Record");
            alert.showAndWait();
        }
    }

    @FXML
    public void cancel() {
        Stage stage = (Stage) email.getScene().getWindow();
        stage.close();
        gotoDashboard();
    }

    public void gotoDashboard(){
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
