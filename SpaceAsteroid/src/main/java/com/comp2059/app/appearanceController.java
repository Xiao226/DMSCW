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

public class appearanceController implements ItemListener{
    @FXML
    ComboBox skin;
    @FXML
    ComboBox background;
    @FXML
    ComboBox smallA;
    @FXML
    ComboBox bigA;

    @FXML
    public void onClickMoveToStartPage(MouseEvent mouseEvent) throws IOException {
        appearanceStage.close();
        startStage.show();
    }

    public void initialFourBox() throws FileNotFoundException {
//        String fileName="com/comp2059/app/img/asteroid/asteroid.png";
//        FileInputStream fileInputStream=new FileInputStream(fileName);
        String [] test = {"a","b","c","d","e"};
        bigA=new ComboBox(FXCollections
                .observableArrayList(test));
//        Image a =
    }
    public void onMouseClick() throws FileNotFoundException {
        System.out.println("clicked");
        appearanceStage.setScene(new Scene(appearancePage,1200,720));
        initialFourBox();
    }
    @Override
    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange()==ItemEvent.SELECTED){
            String s = (String) e.getItem();
            System.out.println(s);
        }
    }
}
