package com.comp2059.app;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SpaceAsteroidController {
    private static Stage stage=new Stage();

    public static void initialTheStage(Stage primaryStage) throws IOException {
        Parent startPage = FXMLLoader.load(SpaceAsteroidController.class.getResource("JavaFX/startPage.fxml"));
        stage=primaryStage;
        primaryStage.setTitle("Welcome to F2A's Game");
        primaryStage.setScene(new Scene(startPage, 1000, 700));// size of the window
        primaryStage.show();
    }
    public void onClickMoveToNameAndRule(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/RuleAndNamePage.fxml"));
        stage.setTitle("Rule and Name");
        stage.setScene(new Scene(next, 1000, 700));// size of the window
        stage.show();
    }
    public void shotDown(MouseEvent mouseEvent) throws IOException{
        Platform.exit();
    }
}
