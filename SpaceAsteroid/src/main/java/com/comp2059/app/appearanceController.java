package com.comp2059.app;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.comp2059.app.SpaceAsteroidApplication.appearanceStage;
import static com.comp2059.app.SpaceAsteroidApplication.startStage;
import static com.comp2059.app.informationStore.beamColor;

/**
 * This class is the controller for appearance page.
 */
public class appearanceController {
    /**
     * This is the store of ship image.
     */
    public static Image shipSkinFinal;
    /**
     * This is the store of background image.
     */
    public static Image backgroundFinal;
    /**
     * This is the store of big asteroid image.
     */
    public static Image bigAFinal;
    /**
     * This is the store of small asteroid image.
     */
    public static Image smallAFinal;
    /**
     * This is the store of boss image.
     */
    public static Image bossRain;

    // set initial image
    static {
        try {
            shipSkinFinal = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/blue.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // set initial image
    static {
        try {
            backgroundFinal = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/background.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // set initial image
    static {
        try {
            bigAFinal = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/big_asteroid.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // set initial image
    static {
        try {
            smallAFinal = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/asteroid.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // set initial image
    static {
        try {
            bossRain = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/boss/boss.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * the pattern from FXML file.
     * used to list the values of ship's skin.
     */
    @FXML
    ComboBox<String> skin;
    /**
     * the pattern from FXML file.
     * used to list the values of background.
     */
    @FXML
    ComboBox<String> background;
    /**
     * the pattern from FXML file.
     * used to list the values of color of beam.
     */
    @FXML
    ComboBox<String> color;
    /**
     * the pattern from FXML file.
     * used to list the values of small asteroid.
     */
    @FXML
    ComboBox<String> smallA;
    /**
     * the pattern from FXML file.
     * used to list the values of big asteroid.
     */
    @FXML
    ComboBox<String> bigA;
    /**
     * the pattern from FXML file.
     * used to show the effect of current big asteroid.
     */
    @FXML
    ImageView bigAs;
    /**
     * the pattern from FXML file.
     * used to show the effect of current small asteroid.
     */
    @FXML
    ImageView smallAs;
    /**
     * the pattern from FXML file.
     * used to show the effect of current background.
     */
    @FXML
    ImageView backG;
    /**
     * the pattern from FXML file.
     * used to show the effect of current ship.
     */
    @FXML
    ImageView ship;
    /**
     * the pattern from FXML file.
     * used to show the effect of current beam.
     */
    @FXML
    Rectangle beam;

    /**
     * This function is to set the action of return to the start page.
     */
    @FXML
    public void onClickMoveToStartPage() {
        appearanceStage.close();
        startStage.show();
    }

    /**
     * Set the ComboBox's values of ship skins and get user's selection.
     * @throws FileNotFoundException can't find image.
     */
    @FXML
    public void onMouseClickSkin() throws FileNotFoundException {
        String sellect = skin.getSelectionModel().getSelectedItem();
        Image a = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/blue.png"));
        Image b = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/dark.png"));
        Image c = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/handDraw.png"));
        Image d = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/light.png"));
        Image e = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/purple.png"));
        Image f = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/shuttle.png"));
        Image g = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/ship/super.png"));

        Image selectedFhoto;
        if (sellect.equals("Hand Drew")) {
            selectedFhoto = c;
        } else if (sellect.equals("Light")) {
            selectedFhoto = d;
        } else if (sellect.equals("Dark")) {
            selectedFhoto = b;
        } else if (sellect.equals("Purple")) {
            selectedFhoto = e;
        } else if (sellect.equals("Blue")) {
            selectedFhoto = a;
        }else if (sellect.equals("Super")) {
            selectedFhoto = g;
        } else {
            selectedFhoto = f;
        }
        ship.setImage(selectedFhoto);
        shipSkinFinal = selectedFhoto;
    }
    /**
     * Set the ComboBox's values of background and get user's selection.
     * @throws FileNotFoundException can't find image.
     */
    @FXML
    public void onMouseClickBack() throws FileNotFoundException {
        String sellect = background.getSelectionModel().getSelectedItem();
        Image a = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/background.png"));
        Image b = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/Background1.jpg"));
        Image c = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/space1.png"));
        Image d = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/space2.jpg"));
        Image e = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/space3.jpg"));
        Image f = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/space4.jpg"));
        Image g = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/space5.jpg"));
        Image h = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/background/space6.png"));


        Image select;
        if (sellect.equals("Initial")) {
            select = a;
        }else if (sellect.equals("Space Photo 1")){
            select=c;
        }else if (sellect.equals("Space Photo 2")){
            select=d;
        }else if (sellect.equals("Space Photo 3")){
            select=e;
        }else if (sellect.equals("Space Photo 4")){
            select=f;
        }else if (sellect.equals("Space Photo 5")){
            select=g;
        }else if (sellect.equals("Space Photo 6")){
            select=h;
        }else{
            select = b;
        }
        backG.setImage(select);
        backgroundFinal = select;
    }

    /**
     * Set the ComboBox's values of beam color and get user's selection.
     * @throws FileNotFoundException can't find image.
     */
    @FXML
    public void onMouseClickColor() {
        String sellect = color.getSelectionModel().getSelectedItem();
        switch (sellect) {
            case "BLUE" -> beamColor = Color.BLUE;
            case "BLACK" -> beamColor = Color.BLACK;
            case "GREY" -> beamColor = Color.GREY;
            case "GREEN" -> beamColor = Color.GREEN;
            case "GOLD" -> beamColor = Color.GOLD;
            case "YELLOW" -> beamColor = Color.YELLOW;
            case "TOMATO" -> beamColor = Color.TOMATO;
            case "WHITE" -> beamColor = Color.WHITE;
            default -> beamColor = Color.PINK;
        }
        beam.setFill(beamColor);
    }

    /**
     * Set the ComboBox's values of big asteroid and get user's selection.
     * @throws FileNotFoundException can't find image.
     */
    @FXML
    public void onMouseClickBig() throws FileNotFoundException {
        String sellect = bigA.getSelectionModel().getSelectedItem();
        Image a = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/big_asteroid.png"));
        Image b = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/big_asteroidf2a.png"));
        Image c = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/enemy2big.png"));
        Image d = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/enemy3big.png"));
        Image select;
        if (sellect.equals("Initial")) {
            select = a;
        }else if(sellect.equals("Enemy 1")){
            select=c;
        }else if(sellect.equals("Enemy 2")){
            select=d;
        }else{
            select = b;
        }
        bigAs.setImage(select);
        bigAFinal = select;

    }

    /**
     * Set the ComboBox's values of small asteroid and get user's selection.
     * @throws FileNotFoundException can't find image.
     */
    @FXML
    public void onMouseClickSmall() throws FileNotFoundException {
        String sellect = smallA.getSelectionModel().getSelectedItem();
        Image a = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/asteroid.png"));
        Image b = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/asteroidf2a.png"));
        Image c = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/enemy2.png"));
        Image d = new Image(new FileInputStream("src/main/resources/com/comp2059/app/img/asteroid/enemy3.png"));
        Image select;
        if (sellect.equals("Initial")) {
            select = a;
        }else if(sellect.equals("Enemy 1")){
            select=c;
        }else if(sellect.equals("Enemy 2")){
            select=d;
        } else {
            select = b;
        }
        smallAs.setImage(select);
        smallAFinal = select;
    }
}
