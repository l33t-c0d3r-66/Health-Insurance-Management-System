package com.health.insurance.controller;

import com.health.insurance.DAO.InsuranceContractDAO;
import com.health.insurance.DAO.InsuredPersonDAO;
import com.health.insurance.DAOImpl.InsuranceContractDAOImpl;
import com.health.insurance.DAOImpl.InsuredPersonDAOImpl;
import com.health.insurance.beans.InsuranceContract;
import com.health.insurance.beans.InsuredPerson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class InsuranceContractController implements Initializable
{
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

    @FXML
    public void addContractOnAction()
    {
        try
        {
            String fxmlFile = "/fxml/CreateContract.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setMinWidth(780);
            stage.setMinHeight(580);
            stage.setMaxWidth(780);
            stage.setMaxHeight(700);

        }catch(Exception e) {
            System.out.println(e);
        }
    }
    @FXML
    public void removeContract()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InsuranceContractDAO insuranceContractDAO = new InsuranceContractDAOImpl();
        List<InsuranceContract> insuranceContracts = insuranceContractDAO.getInsuranceContracts();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        term.setCellValueFactory(new PropertyValueFactory("term"));
        contractAmount.setCellValueFactory(new PropertyValueFactory("contractAmount"));
        faceAmount.setCellValueFactory(new PropertyValueFactory<>("faceAmount"));
        interest.setCellValueFactory(new PropertyValueFactory<>("interest"));
        //Adding data to the table
        ObservableList<InsuranceContract> list = FXCollections.observableList(insuranceContracts);
        tableView.setUserData(list);
    }
}
