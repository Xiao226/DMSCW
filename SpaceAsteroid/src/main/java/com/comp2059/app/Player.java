package com.comp2059.app;

import com.comp2059.app.controller.rankingController;
import javafx.animation.PauseTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static com.comp2059.app.SpaceAsteroidApplication.*;
import static com.comp2059.app.gameStageF2A.*;
import static com.comp2059.app.informationStore.*;
import static com.comp2059.app.rankingStore.*;

public class Player {
    //This is if the shuttle collided with asteroid.
    public void collide() {
        collideForPlayer(asteroid);

        collideForPlayer(bigAsteroid);
    }

    public void collideForPlayer(ArrayList<Node> asteroid) {
        for (int i = 0; i < rocket.size(); i++) {
            for (int j = 0; j < asteroid.size(); j++) {
                if (rocket.get(i).getBoundsInParent().intersects(asteroid.get(j).getBoundsInParent())) {
                    gameOver = true;
                    Image imgExplosion = new Image(Objects.requireNonNull(getClass().getResource("img/explosion.gif")).toExternalForm());
                    ImageView imgviewExplosion = new ImageView(imgExplosion);
                    imgviewExplosion.relocate(rocket.get(i).getLayoutX(), rocket.get(i).getLayoutY());
                    root.getChildren().remove(asteroid.get(j));
                    PauseTransition wait = new PauseTransition(Duration.seconds(0.8));
                    wait.setOnFinished((e) -> root.getChildren().remove(imgviewExplosion));
                    wait.play();
                    asteroid.remove(j);
                    root.getChildren().add(imgviewExplosion);
                    root.getChildren().remove(rocket.get(i));
                    rocket.remove(i);
                    if (difficultLevel){timer.stop();}
                    Text txtGameOver = new Text(500, 360, "Gameover!");
                    txtGameOver.setFill(Color.RED);
                    Font font3 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 60);
                    txtGameOver.setFont(font3);
                    root.getChildren().add(txtGameOver);
                    Button btnQuit = new Button("Quit");
                    btnQuit.setScaleX(6);
                    btnQuit.setScaleY(4);
                    btnQuit.setTextFill(Color.YELLOW);
                    btnQuit.setTranslateX(1000);
                    btnQuit.setTranslateY(600);
                    btnQuit.setStyle("-fx-background-color: red;");
                    timeEndGame=new Date();
                    // initial the rank
                    addresult(userName,destroyedAsteroidNumber,destroyedBossNumber,timeCalculate(timeBeginGame,timeEndGame), score);
                    System.out.println(preparePrint());
                    root.getChildren().add(btnQuit);
                    btnQuit.setOnAction(e ->
                            showTheEndPage()
                    );
                }
            }
        }
    }

    public void showTheEndPage(){
        gameStage.close();
        endStage.show();
    }
}

