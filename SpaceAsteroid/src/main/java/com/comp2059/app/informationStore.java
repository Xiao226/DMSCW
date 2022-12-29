package com.comp2059.app;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Date;

public record informationStore() {
    public static boolean difficultLevel = false;
    public static String fileName = "./src/main/resources/com/comp2059/app/ranking.txt";
    public static String additionalInformation =
            "Welcome to F2A's game, this game is developed by Fish and Smile.\n" +
                    "You can choose to change your ship's skin by clicking the change skin bottom.\n" +
                    "You can choose to change your background by clicking the change background bottom.\n" +
                    "If everything is ready you can click the play bottom for the last preparatory work before start the game.\n ";
    public static String[][] rankingList = new String[20][5];
    public static Color beamColor;
    public static int lifeUsed = 0;
    public static String gamePageTitle = "Well come. ";
    public static Date timeBeginGame;
    public static Date timeEndGame;
    public static String userName = "Admin";
    public static int destroyedAsteroidNumber = 0;
    public static int destroyedBossNumber = 0;

    public static String timeCalculate(Date dateBegin, Date dateEnd) {
        long temp = dateEnd.getTime() - dateBegin.getTime();
        int total = (int) (temp / 1000);
        int second = Math.floorMod(total, 60);
        int minute = Math.floorDiv(total, 60);
        String result = minute + ":" + second;
        return result;
    }

    public static final double W = 1400;
    public static final double H = 820;
    public static final int speed=7;// control the speed of asteroid
    public static int score = 0; //Score being declared and initialized
    public static boolean goUp;
    public static boolean goDown;
    public static boolean goLeft;
    public static boolean goRight;
    public static boolean shoot;
    public static AnimationTimer timer;
    public  static ArrayList<Node> weapons = new ArrayList<>(); //This is an array list that stores the laser beams that are fired
    public static ArrayList<Node> asteroid = new ArrayList<>();// This array list is used to store spawned  small asteroids
    public static ArrayList<Node> bigAsteroid = new ArrayList<>(); // This array list is used to store spawned  big asteroids
    public static ArrayList<Node> rocket = new ArrayList<>();
    public static int dShoot = 10;
    public static Group root = new Group();
    public static int asteroidCounter;
    public  static int asteroidCounter2;
    public static int modifier = 150;
    public  static boolean gameOver;
    public  static Text txtscore;
    public  static ImageView imgviewShuttle;
    public static final double L = 800;

}
