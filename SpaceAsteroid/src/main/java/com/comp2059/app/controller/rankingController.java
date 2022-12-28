package com.comp2059.app.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static com.comp2059.app.SpaceAsteroidApplication.*;
import static com.comp2059.app.gameStageF2A.score;
import static com.comp2059.app.gameStageF2A.showGamePage;
import static com.comp2059.app.informationStore.*;
import static com.comp2059.app.rankingStore.*;

public class rankingController {
    @FXML
    TextArea ranking = new TextArea();

    @FXML
    public void onClickInsert() {
        ranking.setText(preparePrint());
        addresult(userName, destroyedAsteroidNumber, destroyedBossNumber, timeCalculate(timeBeginGame, timeEndGame), score);
        ranking.setText(preparePrint());
    }

    @FXML
    public void onClickRefresh() {
        ranking.setText(preparePrint());
    }

    @FXML
    public void onClickMoveToStartPage(MouseEvent mouseEvent) throws IOException {
        ruleNameStage.close();
        rankingStage.close();
        startStage.show();
    }

    @FXML
    public void shotDown(MouseEvent mouseEvent) throws IOException {
        writeTheRankingFile();
        Platform.exit();
    }

    @FXML
    public void onClickReMoveToGame(MouseEvent mouseEvent) throws IOException {
        endStage.close();
        lifeUsed += 1;
        gamePageTitle = "This is your " + (lifeUsed + 1) + " try. Enjoy it.";
        showGamePage();
//        start();
    }


}
