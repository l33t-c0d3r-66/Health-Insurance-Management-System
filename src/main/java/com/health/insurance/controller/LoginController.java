package com.health.insurance.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.health.insurance.DAO.UserDAO;
import com.health.insurance.DAOImpl.UserDAOImpl;
import com.health.insurance.Main;
import com.health.insurance.beans.User;
import com.health.insurance.util.FactoryProvider;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import org.hibernate.SessionFactory;

public class LoginController implements Initializable {

    @FXML
    JFXTextField userName;
    @FXML
    JFXPasswordField password;

    private SessionFactory sessionFactory;
    private UserDAO userDAO;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.sessionFactory = FactoryProvider.getSessionFactory();
        userDAO = new UserDAOImpl(sessionFactory);
    }

    @FXML
    public void signInButtonOnAction() throws IOException {
        String userNameText = userName.getText();
        String passwordText = password.getText();
        if(userNameText.isEmpty() || passwordText.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Empty Fields");
            alert.setContentText("Both Username and Password are required");
            alert.showAndWait();
        } else {
            User user = userDAO.getUser(userNameText, passwordText);
            if(user!=null) {
                String fxmlFile = "/fxml/Dashboard.fxml";
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
                Scene scene = new Scene(loader.load());
                scene.getStylesheets().add("/styles/styles.css");
                Main.primaryStage.hide();
                Main.primaryStage.setScene(scene);
                Main.primaryStage.show();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Login Failed");
                alert.setContentText("Invalid Username or Password");
                alert.showAndWait();
            }
        }

    }

    @FXML
    public void signUpButtonOnAction() throws IOException {
        String fxmlFile = "/fxml/Signup.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add("/styles/styles.css");
        Main.primaryStage.hide();
        Main.primaryStage.setScene(scene);
        Main.primaryStage.show();
    }

}
