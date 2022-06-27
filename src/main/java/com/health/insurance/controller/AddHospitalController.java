package com.health.insurance.controller;

import com.health.insurance.DAO.HospitalDAO;
import com.health.insurance.DAOImpl.HospitalDAOImpl;
import com.health.insurance.beans.Hospital;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class AddHospitalController {

    @FXML
    JFXTextField hospitalName;
    @FXML
    JFXTextField address;
    @FXML
    JFXTextField contactNumber;
    @FXML
    JFXTextField email;
    @FXML
    JFXTextField website;

    @FXML
    public void addHospital() {
        String name = hospitalName.getText();
        String hospitalAddress = address.getText();
        String number = contactNumber.getText();
        String emailAddress = email.getText();
        String websiteUrl = website.getText();
        Hospital hospital = new Hospital(name, number, emailAddress, websiteUrl,hospitalAddress);
        HospitalDAO hospitalDAO = new HospitalDAOImpl();
        boolean isAdded = hospitalDAO.saveHospital(hospital);
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
    public void cancel() {
        Stage stage = (Stage) email.getScene().getWindow();
        stage.close();
    }

}
