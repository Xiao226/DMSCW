package com.comp2059.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.comp2059.app.informationStore.beamColor;
import static com.comp2059.app.rankingStore.getInformation;

/**
 * This class is to initial each page.
 */
public class SpaceAsteroidApplication extends Application {
    /**
     * save the start stage.
     */
    public static Stage startStage;
    /**
     * save the end stage.
     */
    public static Stage endStage;
    /**
     * save the rule and name stage.
     */
    public static Stage ruleNameStage;
    /**
     * save the ranking stage.
     */
    public static Stage rankingStage;
    /**
     * save the choose appearance stage.
     */
    public static Stage appearanceStage;
    /**
     * save the game stage.
     */
    public static Stage gameStage;
    /**
     * save the info stage.
     */
    public static Stage info;
    /**
     * save the size of page.
     */
    public final int wideF2A = 1200;
    /**
     * save the size of page.
     */
    public final int highF2A = 720;

    /**
     * The start of whole project.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start project.
     * @throws Exception can't find file exception.
     */
    public void start(Stage primaryStage) throws Exception {
        initialTotal();
        startStage.show();
    }

    /**
     * Start to initial different page.
     * @throws IOException
     */
    public void initialTotal() throws IOException {
        initialStartPage();
        initialRuleAndNamePage();
        initialRankingPage();
        initialAppearancePage();
        initialEndPage();
        getInformation();
        initialInfoPage();
    }

    /**
     * Initial the start page.
     * @throws IOException can't find file exception.
     */
    public void initialStartPage() throws IOException {
        startStage = new Stage();
        startStage.setResizable(false);
        /**
         * save the content of start stage.
         */
        Parent startPage = FXMLLoader.load(getClass().getResource("JavaFX/startPage.fxml"));
        startStage.setTitle("Welcome to F2A's Game");
        startStage.setScene(new Scene(startPage, wideF2A, highF2A));// size of the window
    }
    /**
     * Initial the start page.
     * @throws IOException can't find file exception.
     */
    public void initialInfoPage() throws IOException {
        info = new Stage();
        info.setResizable(false);
        /**
         * save the content of info stage.
         */
        Parent infoPage = FXMLLoader.load(getClass().getResource("JavaFX/info.fxml"));
        info.setTitle("Welcome");
        info.setScene(new Scene(infoPage, wideF2A, highF2A));// size of the window
    }
    /**
     * Initial the end page.
     * @throws IOException can't find file exception.
     */
    public void initialEndPage() throws IOException {
        endStage = new Stage();
        endStage.setResizable(false);
        /**
         * save the content of end stage.
         */
        Parent endPage = FXMLLoader.load(getClass().getResource("JavaFX/EndPage.fxml"));
        endStage.setTitle("Whoops you failed");
        endStage.setScene(new Scene(endPage, wideF2A, highF2A));// size of the window
    }

    /**
     * Initial the rule and name page.
     * @throws IOException can't find file exception.
     */
    public void initialRuleAndNamePage() throws IOException {
        ruleNameStage = new Stage();
        ruleNameStage.setResizable(false);
        /**
         * save the content of rule and name stage.
         */
        Parent ruleAndNamePage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("JavaFX/RuleAndNamePage.fxml")));
        ruleNameStage.setTitle("Read the Rule and Enter Your Name");
        ruleNameStage.setScene(new Scene(ruleAndNamePage, wideF2A, highF2A));// size of the window
    }

    /**
     * Initial the ranking page.
     * @throws IOException can't find file exception.
     */
    public void initialRankingPage() throws IOException {
        rankingStage = new Stage();
        rankingStage.setResizable(false);
        /**
         * save the content of ranking stage.
         */
        Parent rankingPage = FXMLLoader.load(getClass().getResource("JavaFX/ranking.fxml"));
        rankingStage.setTitle("Ranking list");
        rankingStage.setScene(new Scene(rankingPage, wideF2A, highF2A));// size of the window
    }

    /**
     * Initial the appearance page.
     * @throws IOException can't find file exception.
     */
    public void initialAppearancePage() throws IOException {
        beamColor = Color.WHITE;
        appearanceStage = new Stage();
        appearanceStage.setResizable(false);
        /**
         * save the content of choose appearance stage.
         */
        Parent appearancePage = FXMLLoader.load(getClass().getResource("JavaFX/appearanceChange.fxml"));
        appearanceStage.setTitle("Choose your favourite here");
        appearanceStage.setScene(new Scene(appearancePage, wideF2A, highF2A));// size of the window
    }
}