package com.health.insurance.controller;

import com.health.insurance.DAO.PharmacyDAO;
import com.health.insurance.DAOImpl.PharmacyDAOImpl;
import com.health.insurance.beans.Pharmacy;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
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
    public void addPharmacy()
    {
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
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Failure!");
            alert.setContentText("Failed to Save Record");
            alert.showAndWait();
        }
    }

    @FXML
    public void cancel()
    {
        Stage stage = (Stage) email.getScene().getWindow();
        stage.close();
    }

}
