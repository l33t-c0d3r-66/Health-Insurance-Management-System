package com.health.insurance.controller;

import com.health.insurance.DAO.InsuranceContractDAO;
import com.health.insurance.DAOImpl.InsuranceContractDAOImpl;
import com.health.insurance.beans.InsuranceContract;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateContractController implements Initializable {
    @FXML
    JFXTextField contractName;
    @FXML
    JFXComboBox<String> contractTerm;
    @FXML
    JFXTextField interest;
    @FXML
    JFXTextField contractAmount;
    @FXML
    JFXTextField faceAmount;

    @FXML
    public void saveContract() {
        String name = contractName.getText();
        String term = contractTerm.getSelectionModel().getSelectedItem();
        String interestPercent = interest.getText();
        String contractAmountText = contractAmount.getText();
        String faceAmountText= faceAmount.getText();
        InsuranceContract insuredContract = new InsuranceContract(name, term, contractAmountText, faceAmountText, interestPercent);
        InsuranceContractDAO insuranceContractDAO = new InsuranceContractDAOImpl();
        boolean isAdded = insuranceContractDAO.saveInsuranceContract(insuredContract);
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
        Stage stage = (Stage) contractName.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contractTerm.getItems().addAll("1","2","3","4","5");
    }
}
