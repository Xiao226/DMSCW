package com.comp2059.app;

import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

import static com.comp2059.app.controller.appearanceController.bigAFinal;
import static com.comp2059.app.controller.appearanceController.smallAFinal;
import static com.comp2059.app.gameStageF2A.*;
import static com.comp2059.app.informationStore.*;

public class Asteroid {
    Image imgAsteroid = smallAFinal;
    Image imgBigAsteroid = bigAFinal;

    public void CreateAsteroid() {
        asteroidCounter++;
        asteroidCounter2++;
        // This is an algorithm that will spawn the asteroids, as your score gets bigger more asteroids will spawn, to increase difficulty.
        collideForBig(score);
        collideForSmall(score);

    }

    private void collideForBig(int score) {
        // every time the score increase 25 the big number increase 1
        if (score<25) collideForAsteroid(asteroidCounter2, imgBigAsteroid, H, bigAsteroid);
        else {
            int time=Math.floorDiv(score,25);
            for (int i = 0; i < time+1; i++) {
                collideForAsteroid(asteroidCounter2, imgBigAsteroid, H, bigAsteroid);
            }
        }
    }

    private void collideForSmall(int score) {
        if (score<25){
            for (int i = 0; i < 2; i++) {
                collideForAsteroid(asteroidCounter, imgAsteroid, W, asteroid);
            }
        }else {
            int time=Math.floorDiv(score,25);
            for (int i = 0; i < (time+1)*2; i++) {
                collideForAsteroid(asteroidCounter, imgAsteroid, W, asteroid);
            }
        }

    }

    private void collideForAsteroid(int asteroidCounter2, Image imgAsteroid, double h, ArrayList<Node> bigAsteroid) {
        if (asteroidCounter2 % modifier == 0) {
            Node newAsteroid = new ImageView(imgAsteroid);
            newAsteroid.relocate((int) (Math.random() * (h + newAsteroid.getBoundsInLocal().getWidth())), (int) (Math.random() / (W + newAsteroid.getBoundsInLocal().getWidth())));
            bigAsteroid.add(newAsteroid);
            root.getChildren().add(newAsteroid);
        }
    }


    //This methods cause the asteroids to move vertically downwards, the higher your score is the faster the asteroids will move; to increase difficulty
    public void moveAsteroid() {
        if (score < 40) {
            moveAsteroidSingle(asteroid,speed);
            moveAsteroidSingle(bigAsteroid,speed-1);
        } else if (score >= 40 && score < 70) {
            moveAsteroidSingle(asteroid,speed+2);
            moveAsteroidSingle(bigAsteroid,speed+1);
        } else if (score >= 70 && score < 100) {
            moveAsteroidSingle(asteroid,speed+4);
            moveAsteroidSingle(bigAsteroid,speed+3);
        } else if (score >= 100) {
                moveAsteroidSingle(asteroid,speed+7);
                moveAsteroidSingle(bigAsteroid,speed+6);
        }
    }
    private void moveAsteroidSingle(ArrayList<Node> arrayAsteroid,int speed_Situation){
        for (int i = 0; i < arrayAsteroid.size(); i++) {
            if (arrayAsteroid.get(i).getLayoutX() > -arrayAsteroid.get(i).getBoundsInLocal().getWidth()) {
                arrayAsteroid.get(i).relocate(arrayAsteroid.get(i).getLayoutX(), arrayAsteroid.get(i).getLayoutY() + speed_Situation);
            } else {
                root.getChildren().remove(arrayAsteroid.get(i));
                arrayAsteroid.remove(i);
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
                    destroyedAsteroidNumber += 1;
                    txtscore.setText("Score: " + score);
                }
            }
        }
        for (int i = 0; i < weapons.size(); i++) {
            for (int j = 0; j < bigAsteroid.size(); j++) {
                if (weapons.get(i).getBoundsInParent().intersects(bigAsteroid.get(j).getBoundsInParent())) {
                    collideCheck(i, j, bigAsteroid);
                    score += 4;
                    destroyedAsteroidNumber += 1;
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
