package com.health.insurance.controller;

import com.health.insurance.DAO.InsuredPersonDAO;
import com.health.insurance.DAOImpl.InsuredPersonDAOImpl;
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

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class InsuredPersonsController implements Initializable {
    @FXML
    public TableView<InsuredPerson> tableView;
    @FXML
    public TableColumn<InsuredPerson, String> id;
    @FXML
    public TableColumn<InsuredPerson, String> name;
    @FXML
    public TableColumn<InsuredPerson, String> type;
    @FXML
    public TableColumn<InsuredPerson, String> number;
    @FXML
    public TableColumn<InsuredPerson, String> address;

    @FXML
    public void buyInsurance() throws IOException {
        String fxmlFile = "/fxml/BuyInsurance.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        InsuredPersonDAO insuredPersonDAO = new InsuredPersonDAOImpl();
        List<InsuredPerson> insuredPersonList = insuredPersonDAO.getInsuredPersons();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        type.setCellValueFactory(new PropertyValueFactory("type"));
        number.setCellValueFactory(new PropertyValueFactory("number"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        //Adding data to the table
        ObservableList<InsuredPerson> list = FXCollections.observableList(insuredPersonList);
        tableView.setUserData(list);

    }
}

