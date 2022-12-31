package com.comp2059.app;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Date;

/**
 * This is a class which save variables.
 * <p>
 * In the build of this project, some variables are used in many different java files.
 * To simplify the import use and easier for later maintainable change, we carry those variables out to this file.
 * </p>
 *
 * @author Xiaotian Zhang(smile), Yibo Sun(fish)
 * @version The last job of 2022
 */
public record informationStore() {
    /**
     * Variable save the range of bound.
     */
    public static final double W = 1400;
    /**
     * Variable save the range of bound.
     */
    public static final double H = 820;
    /**
     * Variable save the speed of asteroid.
     * If you want to change difficulty, just change this one.
     */
    public static final int speed = 7;
    /**
     * Variable save the difficult selection result.
     * true : choose normal model, every counter will be reset if restart the game in the end page.
     * false : choose endless model, counters will not be reset, and every time reenter the game, the speed will increase.
     */
    public static boolean difficultLevel = false;
    /**
     * Variable save the file root of the store file.
     */
    public static String fileName = "./src/main/resources/com/comp2059/app/ranking.txt";
    /**
     * Variable save the result get from file, and for later insert new result.
     */
    public static String[][] rankingList = new String[20][5];
    /**
     * Variable save the beam color player choose for game.
     */
    public static Color beamColor;
    /**
     * Variable save the time player play this time.
     */
    public static int lifeUsed = 0;
    /**
     * Variable save the game page title.
     */
    public static String gamePageTitle = "Well come. ";
    /**
     * Variable save the time player begin the game.
     */
    public static Date timeBeginGame;
    /**
     * Variable save the time player failed.
     */
    public static Date timeEndGame;
    /**
     * Variable save the entered user name.
     */
    public static String userName = "Admin";
    /**
     * Variable save the total number of destroyed asteroid number.
     */
    public static int destroyedAsteroidNumber = 0;
    /**
     * Variable save the number of beaten bosses.
     */
    public static int destroyedBossNumber = 0;
    /**
     * Variable save the regular expression for the time judge for when the boss came out.
     */
    public static String patternMinute = ".*:00";
    /**
     * Variable save the score get from destroying the asteroids.
     */
    public static int score = 0; //Score being declared and initialized
    /**
     * Variable save the score get from beat bosses.
     */
    public static int scoreBoss = 0; //Score being declared and initialized
    /**
     * Variable save the control signal.
     */
    public static boolean goUp;
    /**
     * Variable save the control signal.
     */
    public static boolean goDown;
    /**
     * Variable save the control signal.
     */
    public static boolean goLeft;
    /**
     * Variable save the control signal.
     */
    public static boolean goRight;
    /**
     * Variable save the control signal.
     */
    public static boolean shoot;
    /**
     * Variable used for the whole game.
     * The game page will refresh about 10 times 1 second.
     */
    public static AnimationTimer timer;
    /**
     * Variable save a list of beams occurring in the game page.
     */
    public static ArrayList<Node> weapons = new ArrayList<>(); //This is an array list that stores the laser beams that are fired
    /**
     * Variable save a list of small asteroids.
     */
    public static ArrayList<Node> asteroid = new ArrayList<>();// This array list is used to store spawned  small asteroids
    /**
     * Variable save a list of big asteroids.
     */
    public static ArrayList<Node> bigAsteroid = new ArrayList<>(); // This array list is used to store spawned  big asteroids
    /**
     * Variable save the rocket that user control.
     */
    public static ArrayList<Node> rocket = new ArrayList<>();
    /**
     * Variable save the speed of beam.
     */
    public static int dShoot = 10;
    /**
     * Variable save the game page.
     */
    public static Group root = new Group();
    /**
     * Variable save the counter of small asteroid.
     */
    public static int asteroidCounter;
    /**
     * Variable save the counter of big asteroid.
     */
    public static int asteroidCounter2;
    /**
     * Variable control the generate rate of asteroid.
     * The smaller the number is, the faster asteroid will be generated.
     */
    public static int modifier = 150;
    /**
     * Variable save the game over signal.
     */
    public static boolean gameOver;
    /**
     * Variable for the display of score in the game page.
     */
    public static Text txtscore;
    /**
     * Variable save the player controlled model.
     */
    public static ImageView imgviewShuttle;
    /**
     * Variable that store if there is a boss in the game page.
     */
    public static boolean isBossBeaten;
    /**
     * Variable save the boss.
     */
    public static ArrayList<Node> bossArray = new ArrayList<>(); // This array list is used to store boss
    /**
     * Variable save the hp of boss.
     */
    public static int bossHP;
    /**
     * Variable save the number of beaten bosses.
     */
    public static int bossCounter = 0;

    /**
     * This function is used for calculate the time between two Date and change it to the print style.
     * Use Math function to calculate the minute and second of  the time.
     *
     * @param dateBegin The time of beginning. (Previous)
     * @param dateEnd   The time of ending. (Later)
     * @return A String containing the result like (1:00)
     */
    public static String timeCalculate(Date dateBegin, Date dateEnd) {
        String result;
        long temp = dateEnd.getTime() - dateBegin.getTime();
        int total = (int) (temp / 1000);
        int second = Math.floorMod(total, 60);
        int minute = Math.floorDiv(total, 60);
        if (second < 10) result = minute + ":0" + second;
        else result = minute + ":" + second;
        return result;
    }
}
