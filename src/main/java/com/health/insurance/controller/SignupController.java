package com.health.insurance.controller;

import com.health.insurance.DAO.HospitalDAO;
import com.health.insurance.DAO.UserDAO;
import com.health.insurance.DAOImpl.HospitalDAOImpl;
import com.health.insurance.DAOImpl.UserDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.Hospital;
import com.health.insurance.beans.User;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import java.io.IOException;

public class SignupController {

    @FXML
    JFXTextField userName;
    @FXML
    JFXPasswordField password;
    @FXML
    JFXPasswordField password1;

    public void createAccount()
    {
        String userNameText = userName.getText();
        String passwordText = password.getText();
        String confirmPassword = password1.getText();

        if(passwordText.equals(confirmPassword)) {
            User user = new User(userNameText,passwordText);
            UserDAO userDAO = new UserDAOImpl();
            boolean isAdded = userDAO.saveUser(user);
            if (isAdded) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Success!");
                alert.setContentText("Record Saved Successfully");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Failure!");
                alert.setContentText("Failed to Save Record");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Password Mismatch");
            alert.setContentText("Password Doesn't match.");
            alert.showAndWait();
        }

    }

    @FXML
    public void signIn() throws IOException {
        String fxmlFile = "/fxml/Login.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add("/styles/styles.css");
        Main.primaryStage.hide();
        Main.primaryStage.setScene(scene);
        Main.primaryStage.show();
    }
}