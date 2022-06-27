package com.health.insurance.controller;

import com.health.insurance.DAO.InsuranceContractDAO;
import com.health.insurance.DAOImpl.InsuranceContractDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.InsuranceContract;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
        Stage stage = (Stage) contractName.getScene().getWindow();
        stage.close();
        gotoDashboard();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        contractTerm.getItems().addAll("1","2","3","4","5");
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
