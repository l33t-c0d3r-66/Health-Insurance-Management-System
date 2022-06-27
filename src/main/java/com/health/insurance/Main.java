package com.health.insurance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/fxml/Login.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Health Insurance Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(650);
        primaryStage.setMaxWidth(900);
        primaryStage.setMaxHeight(700);
        Main.primaryStage = primaryStage;
    }
}
