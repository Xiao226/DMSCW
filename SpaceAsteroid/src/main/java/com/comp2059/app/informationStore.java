package com.comp2059.app;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.Date;

public record informationStore() {
    public static boolean difficultLevel = false;
    public static String fileName ="./src/main/resources/com/comp2059/app/ranking.txt";
    public static String additionalInformation=
                    "Welcome to F2A's game, this game is developed by Fish and Smile.\n" +
                    "You can choose to change your ship's skin by clicking the change skin bottom.\n" +
                    "You can choose to change your background by clicking the change background bottom.\n"+
                    "If everything is ready you can click the play bottom for the last preparatory work before start the game.\n ";
    public static String[][]rankingList=new String[20][5];
    public static Color beamColor;
    public static int lifeUsed=0;
    public static String gamePageTitle="Well come. ";
    public static Date timeBeginGame;
    public static Date timeEndGame;
    public static String userName="Admin";
    public static int destroyedAsteroidNumber=0;
    public static int destroyedBossNumber=0;

    public static String timeCalculate(Date dateBegin,Date dateEnd){
        long temp = dateEnd.getTime()-dateBegin.getTime();
        int total= (int) (temp/1000);
        int second=Math.floorMod(total,60);
        int minute=Math.floorDiv(total,60);
        String result = minute+":"+second;
        return result;
    }
}
