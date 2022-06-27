package com.health.insurance.controller;

import com.health.insurance.DAO.InsuredPersonDAO;
import com.health.insurance.DAOImpl.InsuredPersonDAOImpl;
import com.health.insurance.Main;
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

    private InsuredPersonDAO insuredPersonDAO;
    @FXML
    public void buyInsurance() throws IOException {
        String fxmlFile = "/fxml/BuyInsurance.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load());
        Main.primaryStage.setScene(scene);
        Main.primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        insuredPersonDAO = new InsuredPersonDAOImpl();
        List<InsuredPerson> insuredPersonList = insuredPersonDAO.getInsuredPersons();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        type.setCellValueFactory(new PropertyValueFactory("type"));
        number.setCellValueFactory(new PropertyValueFactory("number"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        //Adding data to the table
        ObservableList<InsuredPerson> list = FXCollections.observableList(insuredPersonList);
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

