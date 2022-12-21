package com.comp2059.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.comp2059.app.SpaceAsteroidController.stage;

public class SpaceAsteroidApplication extends Application{
    public static Parent startPage;
    public static Parent endPage;
    public static Parent ruleAndNamePage;
    public static Parent rankingPage;
    public static Parent skinPage;
    public static Parent backgroundPage;
    public static Parent gamePage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        initialPages();
    }
    public void initialPages() throws IOException {
        initialStartPage();
        initialRuleAndNamePage();
        initialGamePage();
        initialRankingPage();
        initialSkinPage();
        initialBackgroundPage();
        initialEndPage();
    }
    public void initialStartPage() throws IOException {
        startPage = FXMLLoader.load(SpaceAsteroidController.class.getResource("JavaFX/startPage.fxml"));
        stage.setTitle("Welcome to F2A's Game");
        stage.setScene(new Scene(startPage, 1000, 700));// size of the window
        stage.show();
    }
    public void initialEndPage()throws IOException {
        endPage=FXMLLoader.load(getClass().getResource("JavaFX/EndPage.fxml"));

    }
    public void initialRuleAndNamePage()throws IOException {
        ruleAndNamePage=FXMLLoader.load(getClass().getResource("JavaFX/RuleAndNamePage.fxml"));

    }
    public void initialRankingPage()throws IOException {
        rankingPage= FXMLLoader.load(getClass().getResource("JavaFX/ranking.fxml"));

    }
    public void initialSkinPage()throws IOException {
        skinPage=FXMLLoader.load(getClass().getResource("JavaFX/spaceShipSkin.fxml"));

    }
    public void initialBackgroundPage()throws IOException {
        backgroundPage=FXMLLoader.load(getClass().getResource("JavaFX/backgroundChange.fxml"));

    }
    public void initialGamePage()throws IOException {
        gamePage = FXMLLoader.load(getClass().getResource("JavaFX/gamePage.fxml"));

    }

    public static void main(String[] args) {
        launch(args);
    }
}