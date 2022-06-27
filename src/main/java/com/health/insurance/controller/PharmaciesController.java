package com.health.insurance.controller;

import com.health.insurance.DAO.InsuranceContractDAO;
import com.health.insurance.DAO.PharmacyDAO;
import com.health.insurance.DAOImpl.InsuranceContractDAOImpl;
import com.health.insurance.DAOImpl.PharmacyDAOImpl;
import com.health.insurance.beans.InsuranceContract;
import com.health.insurance.beans.Pharmacy;
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

public class PharmaciesController implements Initializable {

    @FXML
    public TableView<Pharmacy> tableView;
    @FXML
    public TableColumn<Pharmacy, String> id;
    @FXML
    public TableColumn<Pharmacy, String> name;
    @FXML
    public TableColumn<Pharmacy, String> contact;
    @FXML
    public TableColumn<Pharmacy, String> email;
    @FXML
    public TableColumn<Pharmacy, String> website;
    @FXML
    public TableColumn<Pharmacy, String> address;


    @FXML
    public void addPharmacy()
    {
        try
        {
            String fxmlFile = "/fxml/AddPharmacy.fxml";
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
    public void removePharmacy()
    {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PharmacyDAO pharmacyDAO = new PharmacyDAOImpl();
        List<Pharmacy> pharmacies = pharmacyDAO.getPharmacies();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        contact.setCellValueFactory(new PropertyValueFactory("contact"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        website.setCellValueFactory(new PropertyValueFactory<>("website"));
        //Adding data to the table
        ObservableList<Pharmacy> list = FXCollections.observableList(pharmacies);
        tableView.setUserData(list);
    }
}
