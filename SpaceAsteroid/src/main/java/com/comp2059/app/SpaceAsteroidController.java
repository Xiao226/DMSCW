package com.comp2059.app;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static com.comp2059.app.SpaceAsteroidApplication.*;
import static com.comp2059.app.gameStageF2A.showGamePage;
import static com.comp2059.app.informationStore.*;

/**
 * This class is for most part control.
 */
public class SpaceAsteroidController {
    /**
     * the choose place of game module.
     */
    @FXML
    ComboBox<String> module114514;

    /**
     * close start page, move to next page.
     */
    @FXML
    public void onClickMoveToNameAndRule() {
        startStage.close();
        ruleNameStage.show();
    }

    /**
     * Set the action on select module.
     */
    @FXML
    public void onMouseClickModel() {
        String sellect = module114514.getSelectionModel().getSelectedItem();
        if (sellect.equals("Normal")) {
            difficultLevel = true;
        } else difficultLevel = false;
    }

    /**
     * Go to choose appearance page.
     */
    @FXML
    public void onClickMoveToAppearanceChange() {
        startStage.close();
        appearanceStage.show();
    }

    /**
     * Go to ranking showing page.
     */
    @FXML
    public void onClickMoveToRanking() {
        startStage.close();
        rankingStage.show();
    }

    /**
     * shut down the whole project.
     */
    @FXML
    public void shotDown() {
        Platform.exit();
    }

}
