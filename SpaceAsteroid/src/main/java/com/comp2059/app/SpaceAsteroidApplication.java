package com.comp2059.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpaceAsteroidApplication extends Application{
    public static Stage startStage;
    public static Stage endStage=new Stage();
    public static Stage ruleNameStage=new Stage();
    public static Stage rankingStage=new Stage();
    public static Stage skinStage=new Stage();
    public static Stage backgroundStage=new Stage();
    public static Stage gameStage=new Stage();
    public static Parent startPage;
    public static Parent endPage;
    public static Parent ruleAndNamePage;
    public static Parent rankingPage;
    public static Parent skinPage;
    public static Parent backgroundPage;
    public static Parent gamePage;
    int wideF2A=1200;
    int highF2A=720;
    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("start");
        initialPages();
        System.out.println("start finish");
    }
    public void initialPages() throws IOException {
        System.out.println("initial stage begin");
        initialStartPage();
        System.out.println("initial start succ");
        initialRuleAndNamePage();
        System.out.println("initial rue succ");
        initialGamePage("This is your first try, have fun.");
//        "welcome back to the game again"
        System.out.println("initial game succ");
        initialRankingPage();
        System.out.println("initial rank succ");
        initialSkinPage();
        System.out.println("initial skin succ");
        initialBackgroundPage();
        System.out.println("initial back succ");
        initialEndPage();
        System.out.println("initial end succ");
    }
    public void initialStartPage() throws IOException {
        startStage = new Stage();
        startPage = FXMLLoader.load(SpaceAsteroidController.class.getResource("JavaFX/startPage.fxml"));
        startStage.setTitle("Welcome to F2A's Game");
        startStage.setScene(new Scene(startPage, wideF2A, highF2A));// size of the window
    }
    public void initialEndPage()throws IOException {
        endPage=FXMLLoader.load(getClass().getResource("JavaFX/EndPage.fxml"));
        endStage.setTitle("Whoops you failed");
        endStage.setScene(new Scene(endPage, wideF2A, highF2A));// size of the window
    }
    public void initialRuleAndNamePage()throws IOException {
        ruleAndNamePage=FXMLLoader.load(getClass().getResource("JavaFX/RuleAndNamePage.fxml"));
        ruleNameStage.setTitle("Read the Rule and Enter Your Name");
        ruleNameStage.setScene(new Scene(ruleAndNamePage, wideF2A, highF2A));// size of the window
    }
    public void initialRankingPage()throws IOException {
        rankingPage= FXMLLoader.load(getClass().getResource("JavaFX/ranking.fxml"));
        rankingStage.setTitle("Ranking list");
        rankingStage.setScene(new Scene(rankingPage, wideF2A, highF2A));// size of the window
    }
    public void initialSkinPage()throws IOException {
        skinPage=FXMLLoader.load(getClass().getResource("JavaFX/spaceShipSkin.fxml"));
        skinStage.setTitle("Change your ship's skin here");
        skinStage.setScene(new Scene(skinPage, wideF2A, highF2A));// size of the window
    }
    public void initialBackgroundPage()throws IOException {
        backgroundPage=FXMLLoader.load(getClass().getResource("JavaFX/backgroundChange.fxml"));
        backgroundStage.setTitle("Change your background here");
        backgroundStage.setScene(new Scene(backgroundPage, wideF2A, highF2A));// size of the window
    }
    public void initialGamePage(String title)throws IOException {
        gamePage = FXMLLoader.load(SpaceAsteroidApplication.class.getResource("JavaFX/gamePage.fxml"));
        gameStage.setTitle(title);
        gameStage.setScene(new Scene(gamePage, wideF2A, highF2A));// size of the window
    }

    public static void main(String[] args) {
        System.out.println("main?");
        launch(args);
    }
}