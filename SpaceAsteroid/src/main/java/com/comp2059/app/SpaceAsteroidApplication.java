package com.comp2059.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static com.comp2059.app.SpaceAsteroidController.initialTheStage;

public class SpaceAsteroidApplication extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        initialTheStage(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}