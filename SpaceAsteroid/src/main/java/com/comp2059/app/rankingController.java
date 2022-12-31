package com.comp2059.app;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static com.comp2059.app.SpaceAsteroidApplication.*;
import static com.comp2059.app.gameStageF2A.showGamePage;
import static com.comp2059.app.informationStore.*;
import static com.comp2059.app.rankingStore.*;

/**
 * This class is the controller of ranking page.
 */
public class rankingController {
    /**
     * Display the ranking list.
     */
    @FXML
    Label ranking = new Label();
    /**
     * Display the user's records.
     */
    @FXML
    Label records = new Label();
    /**
     * Display  guide information.
     */
    @FXML
    Label words=new Label();

    /**
     * Add current record into the ranking list and display it.
     */
    @FXML
    public void onClickInsert() {
        ranking.setText(preparePrint());
        addresult(userName, destroyedAsteroidNumber, destroyedBossNumber, timeCalculate(timeBeginGame, timeEndGame), (score+scoreBoss));
        ranking.setText(preparePrint());
    }

    /**
     * Get ranking list and display it.
     */
    @FXML
    public void onClickRefresh() {
        ranking.setText(preparePrint());
        words.setText("Your Record: ");
        records.setText(userName+", "+destroyedAsteroidNumber+", "+ destroyedBossNumber+ ", "+timeCalculate(timeBeginGame, timeEndGame)+", "+ (score+scoreBoss));
    }

    /**
     * Display ranking list.
     */
    @FXML
    public void onClickRefreshSingle() {
        ranking.setText(preparePrint());
    }

    /**
     * Close current page and return to Start page.
     */
    @FXML
    public void onClickMoveToStartPage() {
        ruleNameStage.close();
        rankingStage.close();
        startStage.show();
    }

    /**
     * Shut down the whole project.
     */
    @FXML
    public void shotDown() {
        writeTheRankingFile();
        Platform.exit();
    }

    /**
     * Restart the game.
     */
    @FXML
    public void onClickReMoveToGame() {
        endStage.close();
        lifeUsed += 1;
        gamePageTitle = "This is your " + (lifeUsed + 1) + " try. Enjoy it.";
        showGamePage();
    }


}
