package com.comp2059.app;

import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Objects;

import static com.comp2059.app.controller.appearanceController.*;
import static com.comp2059.app.informationStore.*;

public class Boss {
    Image imgBoss = bossRain;
    int hpCount=10;
    Boss(){
        hpCount=10*(Math.floorDiv(score,25)+1);
    }

    public void CreateBoss() {
        bossCounter++;
        collideForBossUsecase();
    }

    private void collideForBossUsecase() {
        int number= Math.floorDiv(score,25);
        for (int i = 0; i < number+1; i++) {
            collideForBoss(asteroidCounter, new Boss(), W, asteroid);
        }
    }

    private void collideForBoss(int asteroidCounter2, Boss bossImage, double h, ArrayList<Node> bigAsteroid) {
        if (asteroidCounter2 % modifier == 0) {
            Node newBoss = new ImageView(bossImage.imgBoss);
            newBoss.relocate(570, 100);
            bigAsteroid.add(newBoss);
            root.getChildren().add(newBoss);
        }
    }


    //This is if the laser beam collided with asteroid it will cause and explosion and you will gain two points
    public void collide() {
        for (int i = 0; i < weapons.size(); i++) {
            for (int j = 0; j < bossArray.size(); j++) {
                if (weapons.get(i).getBoundsInParent().intersects(bossPosition.get(j).getBoundsInParent())) {
                    collideCheck(i, j, bossPosition,bossArray);
                    score += 20;
                    destroyedBossNumber += 1;
                    txtscore.setText("Score: " + score);
                }
            }
        }
    }

    public void collideCheck(int i, int j, ArrayList<Node> boss,ArrayList<Boss> bossA) {
        Image imgExplosion = new Image(Objects.requireNonNull(getClass().getResource("img/explosion.gif")).toExternalForm());
        ImageView imgViewExplosion = new ImageView(imgExplosion);
        imgViewExplosion.relocate(boss.get(j).getLayoutX(), boss.get(j).getLayoutY());
        bossA.get(j).hpCount-=1;
        if (bossA.get(j).hpCount==0){
            root.getChildren().remove(boss.get(j));
            boss.remove(j);
            bossA.remove(j);
        }else {
            boss.get(j).relocate((int) (Math.random() * (H + boss.get(j).getBoundsInLocal().getWidth())), (int) (Math.random() / (W + boss.get(j).getBoundsInLocal().getWidth())));
        }
        root.getChildren().add(imgViewExplosion);
        PauseTransition wait = new PauseTransition(Duration.seconds(0.8)); // This is so the explosion doesn't infinitely loop.
        wait.setOnFinished((e) -> root.getChildren().remove(imgViewExplosion));
        wait.play();
        root.getChildren().remove(weapons.get(i));
        weapons.remove(i);
    }
}
