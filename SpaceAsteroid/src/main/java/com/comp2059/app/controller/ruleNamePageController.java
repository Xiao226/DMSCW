package com.comp2059.app.controller;

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

public class ruleNamePageController {
    @FXML
    TextField userNameField = new TextField();


    @FXML
    public void onClickMoveToStartPage(MouseEvent mouseEvent) throws IOException {
        ruleNameStage.close();
        rankingStage.close();
        startStage.show();
    }

    @FXML
    public void onClickMoveToPlay(MouseEvent mouseEvent) throws IOException {
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
//        start();
    }

    @FXML
    private void handleTextFieldAction() {
        System.out.println(userNameField.getText());
    }
}
