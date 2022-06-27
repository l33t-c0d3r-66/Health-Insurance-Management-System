package com.health.insurance.controller;

import com.health.insurance.DAO.HospitalDAO;
import com.health.insurance.DAO.InsuranceContractDAO;
import com.health.insurance.DAOImpl.HospitalDAOImpl;
import com.health.insurance.DAOImpl.InsuranceContractDAOImpl;
import com.health.insurance.beans.Hospital;
import com.health.insurance.beans.InsuranceContract;
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

public class HospitalsController implements Initializable {

    @FXML
    public TableView<Hospital> tableView;
    @FXML
    public TableColumn<Hospital, String> id;
    @FXML
    public TableColumn<Hospital, String> name;
    @FXML
    public TableColumn<Hospital, String> contact;
    @FXML
    public TableColumn<Hospital, String> email;
    @FXML
    public TableColumn<Hospital, String> website;
    @FXML
    public TableColumn<Hospital, String> address;

    @FXML
    public void addHospital()
    {
        try
        {
            String fxmlFile = "/fxml/AddHospital.fxml";
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
    public void removeHospital()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HospitalDAO hospitalDAO = new HospitalDAOImpl();
        List<Hospital> hospitals = hospitalDAO.getHospitals();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory("name"));
        contact.setCellValueFactory(new PropertyValueFactory("contact"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        website.setCellValueFactory(new PropertyValueFactory<>("website"));
        //Adding data to the table
        ObservableList<Hospital> list = FXCollections.observableList(hospitals);
        tableView.setUserData(list);
    }
}
