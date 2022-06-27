package com.health.insurance.controller;

import com.health.insurance.DAO.InsuranceContractDAO;
import com.health.insurance.DAOImpl.InsuranceContractDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.InsuranceContract;
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


public class InsuranceContractController implements Initializable {
    @FXML
    public TableView<InsuranceContract> tableView;
    @FXML
    public TableColumn<InsuranceContract, String> id;
    @FXML
    public TableColumn<InsuranceContract, String> name;
    @FXML
    public TableColumn<InsuranceContract, String> term;
    @FXML
    public TableColumn<InsuranceContract, String> contractAmount;
    @FXML
    public TableColumn<InsuranceContract, String> faceAmount;
    @FXML
    public TableColumn<InsuranceContract, String> interest;

    private InsuranceContractDAO insuranceContractDAO;

    @FXML
    public void addContractOnAction() {
        try {
            String fxmlFile = "/fxml/CreateContract.fxml";
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
    public void removeContract() {
        InsuranceContract insuranceContract = tableView.getSelectionModel().getSelectedItem();
        if(insuranceContract != null) {
            boolean isRemoved = insuranceContractDAO.removeInsuranceContract(insuranceContract);
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
        insuranceContractDAO = new InsuranceContractDAOImpl();
        List<InsuranceContract> insuranceContracts = insuranceContractDAO.getInsuranceContracts();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        term.setCellValueFactory(new PropertyValueFactory("term"));
        contractAmount.setCellValueFactory(new PropertyValueFactory("contractAmount"));
        faceAmount.setCellValueFactory(new PropertyValueFactory<>("faceAmount"));
        interest.setCellValueFactory(new PropertyValueFactory<>("interest"));
        //Adding data to the table
        ObservableList<InsuranceContract> list = FXCollections.observableList(insuranceContracts);
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
