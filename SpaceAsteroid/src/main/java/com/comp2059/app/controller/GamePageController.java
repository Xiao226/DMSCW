package com.comp2059.app.controller;

import com.comp2059.app.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.comp2059.app.SpaceAsteroidApplication.*;
import static com.comp2059.app.informationStore.*;

public class GamePageController {
    @FXML
    static
    Text scoretxt;
    @FXML
    static
    ImageView shuttle;
    static boolean goUp;
    static boolean goDown;
    static boolean goLeft;
    static boolean goRight;
    static boolean shoot;
    static AnimationTimer timer;
    static ArrayList<Node> weapons = new ArrayList<>(); //This is an array list that stores the laser beams that are fired
    static ArrayList<Node> asteroid = new ArrayList<>();// This array list is used to store spawned  small asteroids
    static ArrayList<Node> bigAsteroid = new ArrayList<>(); // This array list is used to store spawned  big asteroids
    static ArrayList<Node> rocket = new ArrayList<>();
    final double L = 800;
    static final double W = 1400;
    static final double H = 820;
    static int dShoot = 10;
    static Group root = new Group();
    static int asteroidCounter;
    static int asteroidCounter2;
    static int modifier = 150;
    static boolean gameOver;
    static Text txtscore;
    static int score = 0; //Score being declared and initialized
    static ImageView imgviewShuttle;
    public static void start() throws IOException {
        initialGame();
        scoretxt=txtscore;
        shuttle=imgviewShuttle;
        gamePage = FXMLLoader.load(gameStageF2A.class.getResource("JavaFX/gamePage.fxml"));
        gameStage.setTitle(gamePageTitle);
        rocket.add(shuttle);
        Space space=new Space();
        space.Create();
        Scene scene = new Scene(gamePage, 1200, 720, Color.BLACK);
        gameStage.setResizable(false);
        gameStage.setScene(scene);
        gameStage.show();
        //Using the Key event with booleans to get the game controls to work.
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP -> goUp = true;
                case DOWN -> goDown = true;
                case LEFT -> goLeft = true;
                case RIGHT -> goRight = true;
                case SPACE -> {
                    if (gameOver) {
                        return;
                    }
                    if (!shoot) {
                        Rectangle rect2 = new Rectangle();
                        rect2.setWidth(5.0f);
                        rect2.setHeight(10.0f);
                        //接口
                        rect2.setFill(beamColor);
                        rect2.relocate(imgviewShuttle.getLayoutX() + 45, imgviewShuttle.getLayoutY() - 5);
                        weapons.add(rect2);
                        root.getChildren().add(rect2);
                        shoot = true;
                    }
                }
                default -> {
                }
            }
        });
        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP -> goUp = false;
                case DOWN -> goDown = false;
                case LEFT -> goLeft = false;
                case RIGHT -> goRight = false;
                case SPACE -> shoot = false;
                default -> {
                }
            }
        });

        timer = new AnimationTimer() {
            double delta = 4;

            @Override
            public void handle(long arg0) {
                double currX = imgviewShuttle.getLayoutX();
                double currY = imgviewShuttle.getLayoutY();
                if (imgviewShuttle.getLayoutX() < 1120 && imgviewShuttle.getLayoutX()>0
                        && imgviewShuttle.getLayoutY() < 660  && imgviewShuttle.getLayoutY() > 0)
                {
                    if (goUp) currY -= delta;
                    if (goDown) currY += delta;
                    if (goLeft) currX -= delta;
                    if (goRight) currX += delta;
                }
                if (imgviewShuttle.getLayoutX() >= 1120) {
                    if (goLeft) currX -= delta;
                    currY = getCurrY(currY);
                }
                else if (imgviewShuttle.getLayoutX() <= 0) {
                    if (goRight) currX += delta;
                    currY = getCurrY(currY);
                }
                else if (imgviewShuttle.getLayoutY() <= 0) {
                    if (goDown) currY += delta;
                    currX = getCurrX(currX);
                }
                else if (imgviewShuttle.getLayoutY() >= 660) {
                    if (goUp) currY -= delta;
                    currX = getCurrX(currX);
                }

                imgviewShuttle.relocate(currX, currY);
                Player shuttle = new Player();
                Fire fire = new Fire();
                fire.fire(dShoot);
                shuttle.collide();
                Asteroid asteroid = new Asteroid();
                asteroid.CreateAsteroid();
                asteroid.moveAsteroid();
                asteroid.collide();
            }

            public double getCurrX(double currX) {
                if (imgviewShuttle.getLayoutX() < 1120  && imgviewShuttle.getLayoutX() > 0){
                    if (goLeft) currX -= delta;
                    if (goRight) currX += delta;
                }else if (imgviewShuttle.getLayoutX() <= 0){
                    if (goRight) currX += delta;
                }else if (imgviewShuttle.getLayoutX() >= 1120){
                    if (goLeft) currX -= delta;
                }
                return currX;
            }

            public double getCurrY(double currY) {
                if (imgviewShuttle.getLayoutY() < 660  && imgviewShuttle.getLayoutY() > 0){
                    if (goUp) currY -= delta;
                    if (goDown) currY += delta;
                }else if (imgviewShuttle.getLayoutY() <= 0){
                    if (goDown) currY += delta;
                }else if (imgviewShuttle.getLayoutY() >= 660){
                    if (goUp) currY -= delta;
                }
                return currY;
            }
        };
        timer.start();
    }
    private static void initialGame() {
//        reset the store of used
        goUp = false;
        goDown = false;
        goLeft = false;
        goRight = false;
        shoot = false;
        gameOver = false;
        asteroidCounter = 0;
        asteroidCounter2 = 0;
        if (difficultLevel){
            score = 0;
            destroyedAsteroidNumber=0;
            timeBeginGame=new Date();
        }
        weapons = new ArrayList<>();
        root = new Group();
        rocket = new ArrayList<>();
        bigAsteroid = new ArrayList<>();
        asteroid = new ArrayList<>();
        gameStage = new Stage();
    }
}
