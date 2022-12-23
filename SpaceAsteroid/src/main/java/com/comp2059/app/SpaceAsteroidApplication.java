package com.comp2059.app;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static com.comp2059.app.appearanceController.*;
import static com.comp2059.app.informationStore.*;


public class SpaceAsteroidApplication extends Application{
    public static Stage startStage;
    public static Stage endStage;
    public static Stage ruleNameStage;
    public static Stage rankingStage;
    public static Stage appearanceStage;
    public static Stage gameStage;
    public static Parent startPage;
    public static Parent endPage;
    public static Parent ruleAndNamePage;
    public static Parent rankingPage;
    public static Parent appearancePage;
    public static Parent gamePage;
    final int wideF2A=1200;
    final int highF2A=720;

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
    static Image imgShuttle;
    static ImageView imgviewShuttle;

    public void start(Stage primaryStage) throws Exception{
        initialPages();
        startStage.show();
    }
    public void initialPages() throws IOException {
        initialStartPage();
        initialRuleAndNamePage();
//        initialGamePage("This is your first try, have fun.");
//        "welcome back to the game again"
        initialRankingPage();
        initialAppearancePage();
        initialEndPage();
    }
    public void initialStartPage() throws IOException {
        startStage = new Stage();
        startStage.setResizable(false);
        startPage = FXMLLoader.load(SpaceAsteroidController.class.getResource("JavaFX/startPage.fxml"));
        startStage.setTitle("Welcome to F2A's Game");
        startStage.setScene(new Scene(startPage, wideF2A, highF2A));// size of the window
    }
    public void initialEndPage()throws IOException {
        endStage = new Stage();
        endStage.setResizable(false);
        endPage=FXMLLoader.load(getClass().getResource("JavaFX/EndPage.fxml"));
        endStage.setTitle("Whoops you failed");
        endStage.setScene(new Scene(endPage, wideF2A, highF2A));// size of the window
    }
    public void initialRuleAndNamePage()throws IOException {
        ruleNameStage = new Stage();
        ruleNameStage.setResizable(false);
        ruleAndNamePage=FXMLLoader.load(getClass().getResource("JavaFX/RuleAndNamePage.fxml"));
        ruleNameStage.setTitle("Read the Rule and Enter Your Name");
        ruleNameStage.setScene(new Scene(ruleAndNamePage, wideF2A, highF2A));// size of the window
    }
    public void initialRankingPage()throws IOException {
        rankingStage = new Stage();
        rankingStage.setResizable(false);
        rankingPage= FXMLLoader.load(getClass().getResource("JavaFX/ranking.fxml"));
        rankingStage.setTitle("Ranking list");
        rankingStage.setScene(new Scene(rankingPage, wideF2A, highF2A));// size of the window
    }
    public void initialAppearancePage()throws IOException {

        appearanceStage = new Stage();
        appearanceStage.setResizable(false);
        appearancePage=FXMLLoader.load(getClass().getResource("JavaFX/appearanceChange.fxml"));
        appearanceStage.setTitle("Choose your favourite here");
        appearanceStage.setScene(new Scene(appearancePage, wideF2A, highF2A));// size of the window
    }

//    public void initialGamePage(String title)throws IOException {
//        gameStage = new Stage();
//        gameStage.setResizable(false);
//        gamePage = FXMLLoader.load(SpaceAsteroidApplication.class.getResource("JavaFX/gamePage.fxml"));
//        gameStage.setTitle(title);
//        gameStage.setScene(new Scene(gamePage, wideF2A, highF2A));// size of the window
//    }


    public static void showGamePage() throws IOException{
        extracted();
        txtscore = new Text(1000, 50, "Score: " + score);
        txtscore.setFill(Color.WHITE);
        Font font2 = Font.font("Segoui UI", FontWeight.BOLD, FontPosture.REGULAR, 25);
        txtscore.setFont(font2);
        gameStage.setTitle("Space Asteroids");
        imgviewShuttle = new ImageView(shipSkinFinal);
        rocket.add(imgviewShuttle);
        Space space = new Space();
        space.Create();

        imgviewShuttle.setLayoutX(570);
        imgviewShuttle.setLayoutY(450);

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
                        rect2.setFill(Color.RED);
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

    private static void extracted() {
        goUp = false;
        goDown = false;
        goLeft = false;
        goRight = false;
        shoot = false;
        gameOver = false;
        asteroidCounter = 0;
        asteroidCounter2 = 0;
        if (difficultLevel){ score = 0; }
        weapons = new ArrayList<>();
        root = new Group();
        rocket = new ArrayList<>();
        bigAsteroid = new ArrayList<>();
        asteroid = new ArrayList<>();
        gameStage = new Stage();
    }

    //Inner Classes start here
    public static class Player {
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

    public static class Asteroid {
        Image imgAsteroid = smallAFinal;
        Image imgBigAsteroid = bigAFinal;

        public void CreateAsteroid() {
            asteroidCounter++;
            asteroidCounter2++;
            //This is an algorithm that will spawn the asteroids, as your score gets bigger more asteroids will spawn, to increase difficulty.
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

        private void collideForAsteroid(int asteroidCounter2, Image imgBigAsteroid, double h, ArrayList<Node> bigAsteroid) {
            if (asteroidCounter2 % modifier == 0) {
                Node newBigAsteroid = new ImageView(imgBigAsteroid);
                newBigAsteroid.relocate((int) (Math.random() * (h + newBigAsteroid.getBoundsInLocal().getWidth())), (int) (Math.random() / (W + newBigAsteroid.getBoundsInLocal().getWidth())));
                bigAsteroid.add(newBigAsteroid);
                root.getChildren().add(newBigAsteroid);
            }
        }

        private void collideForSmall() {
            collideForAsteroid(asteroidCounter, imgAsteroid, W, asteroid);
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
                        txtscore.setText("Score: " + score);
                    }
                }
            }
            for (int i = 0; i < weapons.size(); i++) {
                for (int j = 0; j < bigAsteroid.size(); j++) {
                    if (weapons.get(i).getBoundsInParent().intersects(bigAsteroid.get(j).getBoundsInParent())) {
                        collideCheck(i, j, bigAsteroid);
                        score += 4;
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

    public static class Fire {
        //This method causes the laser beam to move vertically upwards
        public void fire(int deltas) {
            for (int i = 0; i < weapons.size(); i++) {
                if (weapons.get(i).getLayoutX() < W) {
                    weapons.get(i).relocate(weapons.get(i).getLayoutX(), weapons.get(i).getLayoutY() - deltas);
                } else weapons.remove(i);
            }
        }
    }

    public static class Space {
        //This classes will add the background image to the stage
        Image background = backgroundFinal;
        ImageView imgbackground = new ImageView(background);

        public void Create() {
            root.getChildren().add(imgbackground);
        }
    }



    public static void main(String[] args) {
//        System.out.println("main?");
        launch(args);
    }
}