package com.comp2059.app;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import static com.comp2059.app.informationStore.*;
import static com.comp2059.app.SpaceAsteroidApplication.*;

public class SpaceAsteroidController {
    private Stage stage;

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
    public void onClickMoveToPlay(MouseEvent mouseEvent) throws IOException {
        ruleNameStage.close();
        showGamePage();
    }
    @FXML
    public void onClickMoveToEndPage(MouseEvent mouseEvent) throws IOException {
        gameStage.close();
        endStage.show();
    }
    @FXML
    public void onClickReMoveToGame(MouseEvent mouseEvent) throws IOException {
        endStage.close();
        showGamePage();
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
