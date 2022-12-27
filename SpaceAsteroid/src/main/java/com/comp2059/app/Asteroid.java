package com.comp2059.app;

import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;
import static com.comp2059.app.informationStore.*;
import static com.comp2059.app.gameStageF2A.*;
import static com.comp2059.app.controller.appearanceController.bigAFinal;
import static com.comp2059.app.controller.appearanceController.smallAFinal;

public class Asteroid {
    Image imgAsteroid = smallAFinal;
    Image imgBigAsteroid = bigAFinal;

    public void CreateAsteroid() {
        asteroidCounter++;
        asteroidCounter2++;
        // This is an algorithm that will spawn the asteroids, as your score gets bigger more asteroids will spawn, to increase difficulty.
        if (score < 25) {
            collideForSmall();
            collideForBig();
        } else if (score >= 25 && score < 60) {
            collideForSmall();
            collideForSmall();
            collideForBig();
        } else if (score >= 60 && score < 85) {
            collideForSmall();
            collideForSmall();
            collideForSmall();
            collideForBig();
        } else if (score >= 85) {
            collideForSmall();
            collideForSmall();
            collideForSmall();
            collideForSmall();
            collideForBig();
        }

    }

    private void collideForBig() {
        collideForAsteroid(asteroidCounter2, imgBigAsteroid, H, bigAsteroid);
    }
    private void collideForSmall() {
        collideForAsteroid(asteroidCounter, imgAsteroid, W, asteroid);
    }
    private void collideForAsteroid(int asteroidCounter2, Image imgBigAsteroid, double h, ArrayList<Node> bigAsteroid) {
        if (asteroidCounter2 % modifier == 0) {
            Node newBigAsteroid = new ImageView(imgBigAsteroid);
            newBigAsteroid.relocate((int) (Math.random() * (h + newBigAsteroid.getBoundsInLocal().getWidth())), (int) (Math.random() / (W + newBigAsteroid.getBoundsInLocal().getWidth())));
            bigAsteroid.add(newBigAsteroid);
            root.getChildren().add(newBigAsteroid);
        }
    }



    //This methods cause the asteroids to move vertically downwards, the higher your score is the faster the asteroids will move; to increase difficulty
    public void moveAsteroid() {
        if (score < 40) {
            for (int i = 0; i < asteroid.size(); i++) {
                if (asteroid.get(i).getLayoutX() > -asteroid.get(i).getBoundsInLocal().getWidth()) {
                    asteroid.get(i).relocate(asteroid.get(i).getLayoutX(), asteroid.get(i).getLayoutY() + 7);
                } else {
                    root.getChildren().remove(asteroid.get(i));
                    asteroid.remove(i);
                }
            }
            for (int j = 0; j < bigAsteroid.size(); j++) {
                if (bigAsteroid.get(j).getLayoutX() > -bigAsteroid.get(j).getBoundsInLocal().getWidth()) {
                    bigAsteroid.get(j).relocate(bigAsteroid.get(j).getLayoutX(), bigAsteroid.get(j).getLayoutY() + 6);
                } else {
                    root.getChildren().remove(bigAsteroid.get(j));
                    bigAsteroid.remove(j);
                }
            }
        } else if (score >= 40 && score < 70) {
            for (int i = 0; i < asteroid.size(); i++) {
                if (asteroid.get(i).getLayoutX() > -asteroid.get(i).getBoundsInLocal().getWidth()) {
                    asteroid.get(i).relocate(asteroid.get(i).getLayoutX(), asteroid.get(i).getLayoutY() + 9);
                } else {
                    root.getChildren().remove(asteroid.get(i));
                    asteroid.remove(i);
                }
            }
            for (int j = 0; j < bigAsteroid.size(); j++) {
                if (bigAsteroid.get(j).getLayoutX() > -bigAsteroid.get(j).getBoundsInLocal().getWidth()) {
                    bigAsteroid.get(j).relocate(bigAsteroid.get(j).getLayoutX(), bigAsteroid.get(j).getLayoutY() + 8);
                } else {
                    root.getChildren().remove(bigAsteroid.get(j));
                    bigAsteroid.remove(j);
                }
            }
        } else if (score >= 70 && score < 100) {
            for (int i = 0; i < asteroid.size(); i++) {
                if (asteroid.get(i).getLayoutX() > -asteroid.get(i).getBoundsInLocal().getWidth()) {
                    asteroid.get(i).relocate(asteroid.get(i).getLayoutX(), asteroid.get(i).getLayoutY() + 11);
                } else {
                    root.getChildren().remove(asteroid.get(i));
                    asteroid.remove(i);
                }
            }
            for (int j = 0; j < bigAsteroid.size(); j++) {
                if (bigAsteroid.get(j).getLayoutX() > -bigAsteroid.get(j).getBoundsInLocal().getWidth()) {
                    bigAsteroid.get(j).relocate(bigAsteroid.get(j).getLayoutX(), bigAsteroid.get(j).getLayoutY() + 10);
                } else {
                    root.getChildren().remove(bigAsteroid.get(j));
                    bigAsteroid.remove(j);
                }
            }
        } else if (score >= 100) {
            for (int i = 0; i < asteroid.size(); i++) {
                if (asteroid.get(i).getLayoutX() > -asteroid.get(i).getBoundsInLocal().getWidth()) {
                    asteroid.get(i).relocate(asteroid.get(i).getLayoutX(), asteroid.get(i).getLayoutY() + 14);
                } else {
                    root.getChildren().remove(asteroid.get(i));
                    asteroid.remove(i);
                }
            }
            for (int j = 0; j < bigAsteroid.size(); j++) {
                if (bigAsteroid.get(j).getLayoutX() > -bigAsteroid.get(j).getBoundsInLocal().getWidth()) {
                    bigAsteroid.get(j).relocate(bigAsteroid.get(j).getLayoutX(), bigAsteroid.get(j).getLayoutY() + 13);
                } else {
                    root.getChildren().remove(bigAsteroid.get(j));
                    bigAsteroid.remove(j);
                }
            }
        }
    }

    //This is if the laser beam collided with asteroid it will cause and explosion and you will gain two points
    public void collide() {
        for (int i = 0; i < weapons.size(); i++) {
            for (int j = 0; j < asteroid.size(); j++) {
                if (weapons.get(i).getBoundsInParent().intersects(asteroid.get(j).getBoundsInParent())) {
                    collideCheck(i, j, asteroid);
                    score += 2;
                    destroyedAsteroidNumber+=1;
                    txtscore.setText("Score: " + score);
                }
            }
        }
        for (int i = 0; i < weapons.size(); i++) {
            for (int j = 0; j < bigAsteroid.size(); j++) {
                if (weapons.get(i).getBoundsInParent().intersects(bigAsteroid.get(j).getBoundsInParent())) {
                    collideCheck(i, j, bigAsteroid);
                    score += 4;
                    destroyedAsteroidNumber+=1;
                    txtscore.setText("Score: " + score);
                }
            }
        }
    }

    public void collideCheck(int i, int j, ArrayList<Node> asteroid) {
        Image imgExplosion = new Image(Objects.requireNonNull(getClass().getResource("img/explosion.gif")).toExternalForm());
        ImageView imgViewExplosion = new ImageView(imgExplosion);
        imgViewExplosion.relocate(asteroid.get(j).getLayoutX(), asteroid.get(j).getLayoutY());
        root.getChildren().remove(asteroid.get(j));
        asteroid.remove(j);
        root.getChildren().add(imgViewExplosion);
        PauseTransition wait = new PauseTransition(Duration.seconds(0.8)); // This is so the explosion doesn't infinitely loop.
        wait.setOnFinished((e) -> root.getChildren().remove(imgViewExplosion));
        wait.play();
        root.getChildren().remove(weapons.get(i));
        weapons.remove(i);
    }
}
