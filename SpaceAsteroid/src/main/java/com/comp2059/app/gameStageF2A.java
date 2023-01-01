package com.comp2059.app;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

import static com.comp2059.app.SpaceAsteroidApplication.gameStage;
import static com.comp2059.app.appearanceController.shipSkinFinal;
import static com.comp2059.app.informationStore.*;

/**
 * This java class is for the game stage.
 * From Team F2A.
 */
public class gameStageF2A {
    /**
     * this function is to initial the game page and set the game.
     */
    public static void showGamePage(){
        initialGame();
        txtscore = new Text(1000, 50, "Score: " + score+" + "+scoreBoss);
        txtscore.setFill(Color.WHITE);
        Font font2 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 25);
        txtscore.setFont(font2);
        gamePageTitle += userName;
        gameStage.setTitle(gamePageTitle);
        imgviewShuttle = new ImageView(shipSkinFinal);
        rocket.add(imgviewShuttle);
        Space space = new Space();
        space.Create();
        imgviewShuttle.setLayoutX(570);
        imgviewShuttle.setLayoutY(450);
        playerHp=new ProgressBar(1.0);
        playerHp.setLayoutX(570);
        playerHp.setLayoutY(550);
        root.getChildren().add(playerHp);
        root.getChildren().add(imgviewShuttle);
        root.getChildren().add(txtscore);

        Scene scene = new Scene(root, 1200, 720, Color.BLACK);
        gameStage.setScene(scene);
        gameStage.setResizable(false);
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

            /**
             * this function is for the main part of game.
             */
            @Override
            public void handle(long arg0) {
                double currX = imgviewShuttle.getLayoutX();
                double currY = imgviewShuttle.getLayoutY();
                if (imgviewShuttle.getLayoutX() < 1120 && imgviewShuttle.getLayoutX() > 0
                        && imgviewShuttle.getLayoutY() < 660 && imgviewShuttle.getLayoutY() > 0) {
                    if (goUp) currY -= delta;
                    if (goDown) currY += delta;
                    if (goLeft) currX -= delta;
                    if (goRight) currX += delta;
                }
                if (imgviewShuttle.getLayoutX() >= 1120) {
                    if (goLeft) currX -= delta;
                    currY = getCurrY(currY);
                } else if (imgviewShuttle.getLayoutX() <= 0) {
                    if (goRight) currX += delta;
                    currY = getCurrY(currY);
                } else if (imgviewShuttle.getLayoutY() <= 0) {
                    if (goDown) currY += delta;
                    currX = getCurrX(currX);
                } else if (imgviewShuttle.getLayoutY() >= 660) {
                    if (goUp) currY -= delta;
                    currX = getCurrX(currX);
                }

                imgviewShuttle.relocate(currX, currY);
                playerHp.relocate(currX,currY+100);
                Player shuttle = new Player();
                Fire fire = new Fire();
                fire.fire(dShoot);
                shuttle.collide();
                Asteroid asteroid = new Asteroid();
                asteroid.CreateAsteroid();
                asteroid.moveAsteroid();
                asteroid.collide();
                Boss boss = new Boss();
                if (timeCalculate(timeBeginGame,new Date()).matches(patternMinute)&&isBossBeaten){
                    isBossBeaten=false;
                    Boss.initialBossHp();
                    boss.CreateBoss();
                }
                boss.collide();
            }

            /**
             * This function is to set the position of player after one movement.
             * @param currX current x position of player
             * @return the result position of x after move
             */
            public double getCurrX(double currX) {
                if (imgviewShuttle.getLayoutX() < 1120 && imgviewShuttle.getLayoutX() > 0) {
                    if (goLeft) currX -= delta;
                    if (goRight) currX += delta;
                } else if (imgviewShuttle.getLayoutX() <= 0) {
                    if (goRight) currX += delta;
                } else if (imgviewShuttle.getLayoutX() >= 1120) {
                    if (goLeft) currX -= delta;
                }
                return currX;
            }

            /**
             * This function is to set the position of player after one movement.
             * @param currY current y position of player
             * @return the result position of y after move
             */
            public double getCurrY(double currY) {
                if (imgviewShuttle.getLayoutY() < 660 && imgviewShuttle.getLayoutY() > 0) {
                    if (goUp) currY -= delta;
                    if (goDown) currY += delta;
                } else if (imgviewShuttle.getLayoutY() <= 0) {
                    if (goDown) currY += delta;
                } else if (imgviewShuttle.getLayoutY() >= 660) {
                    if (goUp) currY -= delta;
                }
                return currY;
            }
        };
        timer.start();
    }

    /**
     * This function is to reset some store to avoid bug caused by reopen the game.
     */
    private static void initialGame() {
//        reset the store of used
        playHp=1.0;
        goUp = false;
        goDown = false;
        goLeft = false;
        goRight = false;
        shoot = false;
        gameOver = false;
        isBossBeaten=true;
        asteroidCounter = 0;
        asteroidCounter2 = 0;

        if (difficultLevel) {
            scoreBoss=0;
            score = 0;
            bossCounter=0;
            destroyedAsteroidNumber = 0;
            timeBeginGame = new Date();
        }
        weapons = new ArrayList<>();
        root = new Group();
        rocket = new ArrayList<>();
        bigAsteroid = new ArrayList<>();
        asteroid = new ArrayList<>();
        gameStage = new Stage();
    }

}
