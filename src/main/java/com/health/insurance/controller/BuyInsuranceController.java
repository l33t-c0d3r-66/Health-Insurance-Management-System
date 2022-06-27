package com.health.insurance.controller;

import com.health.insurance.DAO.InsuranceContractDAO;
import com.health.insurance.DAO.InsuredPersonDAO;
import com.health.insurance.DAOImpl.InsuranceContractDAOImpl;
import com.health.insurance.DAOImpl.InsuredPersonDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.InsuranceContract;
import com.health.insurance.beans.InsuredPerson;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BuyInsuranceController implements Initializable {

    @FXML
    JFXTextField personName;
    @FXML
    JFXTextField address;
    @FXML
    JFXTextField contactNumber;
    @FXML
    JFXTextField email;
    @FXML
    JFXComboBox<String> insurance;

    @FXML
    public void buyInsurance() {
        String pName = personName.getText();
        String pAddress = address.getText();
        String cNumber = contactNumber.getText();
        String type = insurance.getSelectionModel().getSelectedItem();

        InsuredPerson insuredPerson = new InsuredPerson(pName, type, cNumber,pAddress);
        InsuredPersonDAO insuredPersonDAO = new InsuredPersonDAOImpl();
        boolean isAdded = insuredPersonDAO.saveInsuredPerson(insuredPerson);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InsuranceContractDAO insuranceContractDAO = new InsuranceContractDAOImpl();
        List<InsuranceContract> insuranceContracts = insuranceContractDAO.getInsuranceContracts();
        for(InsuranceContract insuranceContract: insuranceContracts) {
            insurance.getItems().add(insuranceContract.getId() + " " +insuranceContract.getName());
        }
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
