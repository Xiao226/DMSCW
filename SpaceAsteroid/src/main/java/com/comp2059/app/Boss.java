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

    public static void initialBossHp(){
        bossHP=Math.floorDiv(score,5);
    }

    public void CreateBoss() {
        bossCounter++;
        Node newBoss = new ImageView(imgBoss);
        newBoss.relocate(570, 100);
        bossArray.add(newBoss);
        root.getChildren().add(newBoss);
    }

    //This is if the laser beam collided with asteroid it will cause and explosion and you will gain two points
    public void collide() {
        for (int i = 0; i < weapons.size(); i++) {
            for (int j = 0; j<bossArray.size();j++) {
                if (weapons.get(i).getBoundsInParent().intersects(bossArray.get(j).getBoundsInParent())) {
                    collideCheckBoss(i,j);
                    score += 20;
                    txtscore.setText("Score: " + score);
                }
            }
        }
    }

    public void collideCheckBoss(int i, int j) {
        Image imgExplosion = new Image(Objects.requireNonNull(getClass().getResource("img/explosion.gif")).toExternalForm());
        ImageView imgViewExplosion = new ImageView(imgExplosion);
        imgViewExplosion.relocate(bossArray.get(j).getLayoutX(), bossArray.get(j).getLayoutY());
        bossHP-=1;
        if (bossHP==0){
            destroyedBossNumber += 1;
            isBossBeaten=true;
            root.getChildren().remove(bossArray.get(j));
            bossArray.remove(j);
        }else {
            bossArray.get(j).relocate((int) (Math.random() * (H + bossArray.get(j).getBoundsInLocal().getWidth())), (int) (Math.random() / (W + bossArray.get(j).getBoundsInLocal().getWidth())));
        }
        root.getChildren().add(imgViewExplosion);
        PauseTransition wait = new PauseTransition(Duration.seconds(0.8)); // This is so the explosion doesn't infinitely loop.
        wait.setOnFinished((e) -> root.getChildren().remove(imgViewExplosion));
        wait.play();
        root.getChildren().remove(weapons.get(i));
        weapons.remove(i);
    }
}
