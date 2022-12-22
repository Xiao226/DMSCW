package com.comp2059.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpaceAsteroidApplication extends Application{
    public static Stage startStage;
    public static Stage endStage;
    public static Stage ruleNameStage;
    public static Stage rankingStage;
    public static Stage skinStage;
    public static Stage backgroundStage;
    public static Stage gameStage;
    public static Parent startPage;
    public static Parent endPage;
    public static Parent ruleAndNamePage;
    public static Parent rankingPage;
    public static Parent skinPage;
    public static Parent backgroundPage;
    public static Parent gamePage;
    final int wideF2A=1200;
    final int highF2A=720;

    public void start(Stage primaryStage) throws Exception{
        initialPages();
        startStage.show();
    }
    public void initialPages() throws IOException {
        initialStartPage();
        initialRuleAndNamePage();
        initialGamePage("This is your first try, have fun.");
//        "welcome back to the game again"
        initialRankingPage();
        initialSkinPage();
        initialBackgroundPage();
        initialEndPage();
    }
    public void initialStartPage() throws IOException {
        startStage = new Stage();
        startPage = FXMLLoader.load(SpaceAsteroidController.class.getResource("JavaFX/startPage.fxml"));
        startStage.setTitle("Welcome to F2A's Game");
        startStage.setScene(new Scene(startPage, wideF2A, highF2A));// size of the window
    }
    public void initialEndPage()throws IOException {
        endStage = new Stage();
        endPage=FXMLLoader.load(getClass().getResource("JavaFX/EndPage.fxml"));
        endStage.setTitle("Whoops you failed");
        endStage.setScene(new Scene(endPage, wideF2A, highF2A));// size of the window
    }
    public void initialRuleAndNamePage()throws IOException {
        ruleNameStage = new Stage();
        ruleAndNamePage=FXMLLoader.load(getClass().getResource("JavaFX/RuleAndNamePage.fxml"));
        ruleNameStage.setTitle("Read the Rule and Enter Your Name");
        ruleNameStage.setScene(new Scene(ruleAndNamePage, wideF2A, highF2A));// size of the window
    }
    public void initialRankingPage()throws IOException {
        rankingStage = new Stage();
        rankingPage= FXMLLoader.load(getClass().getResource("JavaFX/ranking.fxml"));
        rankingStage.setTitle("Ranking list");
        rankingStage.setScene(new Scene(rankingPage, wideF2A, highF2A));// size of the window
    }
    public void initialSkinPage()throws IOException {
        skinStage = new Stage();
        skinPage=FXMLLoader.load(getClass().getResource("JavaFX/spaceShipSkin.fxml"));
        skinStage.setTitle("Change your ship's skin here");
        skinStage.setScene(new Scene(skinPage, wideF2A, highF2A));// size of the window
    }
    public void initialBackgroundPage()throws IOException {
        backgroundStage = new Stage();
        backgroundPage=FXMLLoader.load(getClass().getResource("JavaFX/backgroundChange.fxml"));
        backgroundStage.setTitle("Change your background here");
        backgroundStage.setScene(new Scene(backgroundPage, wideF2A, highF2A));// size of the window
    }
    public void initialGamePage(String title)throws IOException {
        gameStage = new Stage();
        gamePage = FXMLLoader.load(SpaceAsteroidApplication.class.getResource("JavaFX/gamePage.fxml"));
        gameStage.setTitle(title);
        gameStage.setScene(new Scene(gamePage, wideF2A, highF2A));// size of the window
    }

    public static void main(String[] args) {
        System.out.println("main?");
        launch(args);
    }
}