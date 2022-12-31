package com.comp2059.app;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Date;

import static com.comp2059.app.SpaceAsteroidApplication.*;
import static com.comp2059.app.gameStageF2A.showGamePage;
import static com.comp2059.app.informationStore.timeBeginGame;
import static com.comp2059.app.informationStore.userName;

/**
 * This class is the controller of rule and name page.
 */
public class ruleNamePageController {
    /**
     * The text area where we get user's input.
     */
    @FXML
    TextField userNameField = new TextField();

    /**
     * Close rule page and return to start page.
     */
    @FXML
    public void onClickMoveToStartPage() {
        ruleNameStage.close();
        rankingStage.close();
        startStage.show();
    }

    /**
     * Check the input name and begin the game.
     */
    @FXML
    public void onClickMoveToPlay() {
        if (userNameField.getText().isEmpty()) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Entry Error");
            error.setContentText("Name is a required field.");
            error.show();
            return;
        }
        for (int i = 0; i < userNameField.getText().length(); i++) {
            if (Character.isDigit(userNameField.getText().charAt(i))) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Entry Error");
                error.setContentText("Name must not contain a digit");
                error.show();
                return;
            }
        }
        userName = userNameField.getText();
        ruleNameStage.close();
        timeBeginGame = new Date();
        showGamePage();
    }
}
