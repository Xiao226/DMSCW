package com.comp2059.app;

import javafx.scene.control.Label;

public record informationStore() {
    public static boolean difficultLevel = true;
    public static String rule =
            "Here are the rules of the game:\n" +
            "You control a space shuttle. There will generate some asteroids in your path." +
            "You must dodging them  or destroy them with your laser beam.\n " +
            "Controls: Left Arrow=Move Left," +
            "Right Arrow=Move Right," +
            "Up Arrow= Move Up, " +
            "Down Arrow=Move Down" +
            ", Space=Fire\n"+
            "Enter your name at the right (no special symbols are allowed) and begin your journal.";
    public static String fileName ="./src/main/resources/com/comp2059/app/ranking.txt";
    public static String additionalInformation=
                    "Welcome to F2A's game, this game is developed by Fish and Smile.\n" +
                    "You can choose to change your ship's skin by clicking the change skin bottom.\n" +
                    "You can choose to change your background by clicking the change background bottom.\n"+
                    "If everything is ready you can click the play bottom for the last preparatory work before start the game.\n ";
    public static String[][]rankingList=new String[20][5];
}
