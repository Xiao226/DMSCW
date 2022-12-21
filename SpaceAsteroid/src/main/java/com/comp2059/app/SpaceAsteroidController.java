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
    
    @FXML
    public static void initialTheStage(Stage primaryStage) throws IOException {
        Parent startPage = FXMLLoader.load(SpaceAsteroidController.class.getResource("JavaFX/startPage.fxml"));
        stage.setTitle("Welcome to F2A's Game");
        stage.setScene(new Scene(startPage, 1000, 700));// size of the window
        stage.show();
    }
    @FXML
    public void onClickMoveToNameAndRule(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/RuleAndNamePage.fxml"));
        stage.setTitle("Read the Rule and Enter Your Name");
        stage.setScene(new Scene(next, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToSkinChange(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/spaceShipSkin.fxml"));
        stage.setTitle("Change your ship's skin here");
        stage.setScene(new Scene(next, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToBackgroundChange(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/backgroundChange.fxml"));
        stage.setTitle("Change your background here");
        stage.setScene(new Scene(next, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToRanking(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/ranking.fxml"));
        stage.setTitle("Ranking list");
        stage.setScene(new Scene(next, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToPlay(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/gamePage.fxml"));
        stage.setTitle("This is your first try, have fun.");
        stage.setScene(new Scene(next, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToEndPage(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/EndPage.fxml"));
        stage.setTitle("Whoops you failed");
        stage.setScene(new Scene(next, 1000, 700));// size of the window
    }
    @FXML
    public void onClickReMoveToGame(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/gamePage.fxml"));
        stage.setTitle("welcome back to the game again");// try to add a counter here
        stage.setScene(new Scene(next, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToStartPage(MouseEvent mouseEvent) throws IOException {
        Parent next = FXMLLoader.load(getClass().getResource("JavaFX/startPage.fxml"));
        stage.setTitle("Welcome to F2A's game");
        stage.setScene(new Scene(next, 1000, 700));// size of the window
    }
    @FXML
    public void shotDown(MouseEvent mouseEvent) throws IOException{
        Platform.exit();
    }

}
