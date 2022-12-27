package com.comp2059.app;

import com.comp2059.app.controller.SpaceAsteroidController;
import com.comp2059.app.controller.rankingController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


import static com.comp2059.app.controller.ruleNamePageController.*;
import static com.comp2059.app.informationStore.beamColor;
import static com.comp2059.app.rankingStore.*;

public class SpaceAsteroidApplication extends Application{
    public static Stage startStage;
    public static Stage endStage;
    public static Stage ruleNameStage;
    public static Stage rankingStage;
    public static Stage appearanceStage;
    public static Stage gameStage;
    public static Parent startPage;
    public static Parent endPage;
    public static Parent ruleAndNamePage;
    public static Parent rankingPage;
    public static Parent appearancePage;
    public static Parent gamePage;
    final int wideF2A=1200;
    final int highF2A=720;



    public void start(Stage primaryStage) throws Exception{
        initialTotal();
        startStage.show();
    }
    public void initialTotal() throws IOException {
        initialStartPage();
        initialRuleAndNamePage();
        initialRankingPage();
        initialAppearancePage();
        initialEndPage();
        getInformation();
    }
    public void initialStartPage() throws IOException {
        startStage = new Stage();
        startStage.setResizable(false);
        startPage = FXMLLoader.load(getClass().getResource("JavaFX/startPage.fxml"));
        startStage.setTitle("Welcome to F2A's Game");
        startStage.setScene(new Scene(startPage, wideF2A, highF2A));// size of the window
    }
    public void initialEndPage()throws IOException {
        endStage = new Stage();
        endStage.setResizable(false);
        endPage=FXMLLoader.load(getClass().getResource("JavaFX/EndPage.fxml"));
        endStage.setTitle("Whoops you failed");
        endStage.setScene(new Scene(endPage, wideF2A, highF2A));// size of the window
    }
    public void initialRuleAndNamePage()throws IOException {
        ruleNameStage = new Stage();
        ruleNameStage.setResizable(false);
        ruleAndNamePage=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("JavaFX/RuleAndNamePage.fxml")));
        ruleNameStage.setTitle("Read the Rule and Enter Your Name");
        ruleNameStage.setScene(new Scene(ruleAndNamePage, wideF2A, highF2A));// size of the window
    }
    public void initialRankingPage()throws IOException {
        rankingStage = new Stage();
        rankingStage.setResizable(false);
        rankingPage= FXMLLoader.load(getClass().getResource("JavaFX/ranking.fxml"));
        rankingStage.setTitle("Ranking list");
        rankingStage.setScene(new Scene(rankingPage, wideF2A, highF2A));// size of the window
    }
    public void initialAppearancePage()throws IOException {
        beamColor=Color.WHITE;
        appearanceStage = new Stage();
        appearanceStage.setResizable(false);
        appearancePage=FXMLLoader.load(getClass().getResource("JavaFX/appearanceChange.fxml"));
        appearanceStage.setTitle("Choose your favourite here");
        appearanceStage.setScene(new Scene(appearancePage, wideF2A, highF2A));// size of the window
    }


    public static void main(String[] args) {
        launch(args);
    }
}