package com.health.insurance.controller;

import com.health.insurance.DAO.PhysicianDAO;
import com.health.insurance.DAOImpl.PhysicianDAOImpl;
import com.health.insurance.beans.Physician;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class AddPhysicianController {
    @FXML
    JFXTextField physicianName;
    @FXML
    JFXTextField address;
    @FXML
    JFXTextField contactNumber;
    @FXML
    JFXTextField email;

    @FXML
    public void addPhysician()
    {
        String name = physicianName.getText();
        String physicianAddress = address.getText();
        String number = contactNumber.getText();
        String emailAddress = email.getText();

        Physician physician = new Physician(name, number, emailAddress, physicianAddress);
        PhysicianDAO physicianDAO = new PhysicianDAOImpl();
        boolean isAdded = physicianDAO.savePhysician(physician);
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