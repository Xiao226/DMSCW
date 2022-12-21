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

import static com.comp2059.app.SpaceAsteroidApplication.*;

public class SpaceAsteroidController {
    public static Stage stage=new Stage();
    

    @FXML
    public void onClickMoveToNameAndRule(MouseEvent mouseEvent) throws IOException {
        stage.setTitle("Read the Rule and Enter Your Name");
        stage.setScene(new Scene(ruleAndNamePage, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToSkinChange(MouseEvent mouseEvent) throws IOException {
        stage.setTitle("Change your ship's skin here");
        stage.setScene(new Scene(skinPage, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToBackgroundChange(MouseEvent mouseEvent) throws IOException {
        stage.setTitle("Change your background here");
        stage.setScene(new Scene(backgroundPage, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToRanking(MouseEvent mouseEvent) throws IOException {
        stage.setTitle("Ranking list");
        stage.setScene(new Scene(rankingPage, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToPlay(MouseEvent mouseEvent) throws IOException {
        stage.setTitle("This is your first try, have fun.");
        stage.setScene(new Scene(gamePage, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToEndPage(MouseEvent mouseEvent) throws IOException {
        stage.setTitle("Whoops you failed");
        stage.setScene(new Scene(endPage, 1000, 700));// size of the window
    }
    @FXML
    public void onClickReMoveToGame(MouseEvent mouseEvent) throws IOException {
        stage.setTitle("welcome back to the game again");// try to add a counter here
        stage.setScene(new Scene(gamePage, 1000, 700));// size of the window
    }
    @FXML
    public void onClickMoveToStartPage(MouseEvent mouseEvent) throws IOException {
        stage.setTitle("Welcome to F2A's game");
        stage.setScene(new Scene(startPage, 1000, 700));// size of the window
    }
    @FXML
    public void shotDown(MouseEvent mouseEvent) throws IOException{
        Platform.exit();
    }

}
