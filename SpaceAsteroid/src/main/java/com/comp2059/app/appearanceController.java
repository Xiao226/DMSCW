package com.comp2059.app;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static com.comp2059.app.SpaceAsteroidApplication.*;

public class appearanceController{
    public static Image shipSkinFinal;

    static {
        try {
            shipSkinFinal = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/blue.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Image backgroundFinal;

    static {
        try {
            backgroundFinal = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/background.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Image bigAFinal;

    static {
        try {
            bigAFinal = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/big_asteroid.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Image smallAFinal;

    static {
        try {
            smallAFinal = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/asteroid.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    ComboBox <String> skin;
    @FXML
    ComboBox <String> background;
    @FXML
    ComboBox <String> smallA;
    @FXML
    ComboBox <String> bigA;
    @FXML
    ImageView bigAs;
    @FXML
    ImageView smallAs;
    @FXML
    ImageView backG;
    @FXML
    ImageView ship;
    @FXML
    public void onClickMoveToStartPage(MouseEvent mouseEvent) throws IOException {
        appearanceStage.close();
        startStage.show();
    }

    @FXML
    public void onMouseClickSkin() throws FileNotFoundException {
        String sellect=skin.getSelectionModel().getSelectedItem();
        Image a = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/blue.png"));
        Image b = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/dark.png"));
        Image c = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/handDraw.png"));
        Image d = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/light.png"));
        Image e = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/purple.png"));
        Image f = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/shuttle.png"));
        Image selectedFhoto;
        if (sellect.equals("Hand Drew")){
            selectedFhoto=c;
        }else if (sellect.equals("Light")){
            selectedFhoto=d;
        }else if (sellect.equals("Dark")){
            selectedFhoto=b;
        }else if (sellect.equals("Purple")){
            selectedFhoto=e;
        }else if (sellect.equals("Blue")) {
            selectedFhoto =a;
        }else{
            selectedFhoto=f;
        }
        ship.setImage(selectedFhoto);
        shipSkinFinal=selectedFhoto;
    }

    @FXML
    public void onMouseClickBack() throws FileNotFoundException {
        String sellect=background.getSelectionModel().getSelectedItem();
        Image a = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/background.png"));
        Image b = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/Background1.jpg"));
        Image select;
        if (sellect.equals("Initial")){
            select=a;
        }else {
            select=b;
        }
        backG.setImage(select);
        backgroundFinal=select;
    }

    @FXML
    public void onMouseClickBig() throws FileNotFoundException {
        String sellect=bigA.getSelectionModel().getSelectedItem();
        Image a = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/big_asteroid.png"));
        Image b = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/big_asteroidf2a.png"));

        Image select;
        if (sellect.equals("Initial")){
            select=a;
        }else {
            select=b;
        }
        bigAs.setImage(select);
        bigAFinal=select;

    }

    @FXML
    public void onMouseClickSmall() throws FileNotFoundException {
        String sellect=smallA.getSelectionModel().getSelectedItem();
        Image a = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/asteroid.png"));
        Image b = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/asteroidf2a.png"));
        Image select;
        if (sellect.equals("Initial")){
            select=a;
        }else {
            select=b;
        }
        smallAs.setImage(select);
        smallAFinal=select;
    }
}
