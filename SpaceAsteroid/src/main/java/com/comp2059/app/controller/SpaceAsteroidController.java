package com.comp2059.app.controller;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static com.comp2059.app.gameStageF2A.showGamePage;
import static com.comp2059.app.informationStore.*;
import static com.comp2059.app.SpaceAsteroidApplication.*;

public class SpaceAsteroidController {
    public static Stage stage;

    @FXML
    public void onClickMoveToNameAndRule(MouseEvent mouseEvent) throws IOException {
        startStage.close();
        stage=ruleNameStage;
        ruleNameStage.show();
    }
    @FXML
    ComboBox<String> module114514;
    @FXML
    public void onMouseClickModel(){
        String sellect = module114514.getSelectionModel().getSelectedItem();
        if (sellect.equals("Normal")){
            difficultLevel=true;
        }else difficultLevel=false;
    }
    @FXML
    public void onClickMoveToAppearanceChange(MouseEvent mouseEvent) throws IOException {
        startStage.close();
        stage=appearanceStage;
        appearanceStage.show();
    }
    @FXML
    public void onClickMoveToRanking(MouseEvent mouseEvent) throws IOException {
        startStage.close();
        rankingStage.show();
    }

    @FXML
    public void onClickMoveToEndPage(MouseEvent mouseEvent) throws IOException {
        gameStage.close();
        endStage.show();
    }
    @FXML
    public void onClickReMoveToGame(MouseEvent mouseEvent) throws IOException {
        endStage.close();
        lifeUsed+=1;
        gamePageTitle="This is your "+(lifeUsed+1)+" try. Enjoy it.";
        showGamePage();
//        start();
    }
    @FXML
    public void onClickMoveToStartPage(MouseEvent mouseEvent) throws IOException {
        ruleNameStage.close();
        rankingStage.close();
        startStage.show();
    }

    @FXML
    public void shotDown(MouseEvent mouseEvent) throws IOException{
        Platform.exit();
    }

}
