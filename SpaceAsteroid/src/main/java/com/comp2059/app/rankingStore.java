package com.comp2059.app;

import java.io.*;

import static com.comp2059.app.informationStore.fileName;
import static com.comp2059.app.informationStore.rankingList;

/**
 * This class contain some methods used to store the ranking information.
 * Store structure:
 * player-name, destroyed-asteroid-number, beaten-boss-number, live-time, total-score
 */
public class rankingStore {
    /**
     * This function is to read data from the ranking.txt file.
     * If the file is empty or do not exist it will create 3 first line of ranking.
     */
    public static void getInformation() {
        boolean initialNeed = false;
        try {
            File file = new File(fileName);
            if (!file.exists()) file.createNewFile();
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            String temp;
            for (int i = 0; i < 20; i++) {
                temp = br.readLine();
                if (temp == null) continue;
                rankingList[i] = temp.split(" ");
            }
            if (rankingList[0][0] == null) initialNeed = true;
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ranking file missing.");
            initialNeed = true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something wrong with the ranking file.");
            initialNeed = true;
        }
        // no data create initial data
        if (initialNeed) {
            rankingList[2] = new String[]{"Admin", "0", "0", "0:0", "0"};
            rankingList[1] = new String[]{"Fish", "20", "0", "1:30", "60"};
            rankingList[0] = new String[]{"Smile", "233", "4", "3:50", "233"};
        }
    }

    /**
     * This function will write the stored ranking information into the file.
     */
    public static void writeTheRankingFile() {
        try {
            File file = new File(fileName);
            if (!file.exists()) file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String[] a : rankingList) {
                if (a == null) continue;
                for (String b : a) {
                    if (b == null) continue;
                    bw.write(b);
                    bw.write(" ");
                }
                bw.write("\n");
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This function is used to insert the new record into the ranking.
     * @param player_name user's name.
     * @param destroyed_asteroid_number destroyed asteroid number from the game.
     * @param beaten_boss_number beaten boss number from the game.
     * @param live_time total time user survive in the game.
     * @param total_score total score of game from asteroid and boss.
     */
    public static void addresult(String player_name, int destroyed_asteroid_number, int beaten_boss_number, String live_time, int total_score) {
        String[] newest = new String[5];
        newest[0] = player_name;
        newest[1] = String.valueOf(destroyed_asteroid_number);
        newest[2] = String.valueOf(beaten_boss_number);
        newest[3] = live_time;
        newest[4] = String.valueOf(total_score);
        for (int i = 0; i < 20; i++) {
            if (rankingList[i][0] == null) {
                rankingList[i] = newest;
                return;
            }
            if (Integer.parseInt(rankingList[i][4]) < total_score) {
                if (i != 19) moveBackOneLine(i);
                rankingList[i] = newest;
                return;
            } else if (Integer.parseInt(rankingList[i][4]) == total_score) {
                if (compareTime(live_time, rankingList[i][3])) {
                    if (i != 19) moveBackOneLine(i);
                    rankingList[i] = newest;
                    return;
                }

            }

        }
    }

    /**
     * This function will move the lines below the right place one line after.
     * @param start_position the start position.
     */
    public static void moveBackOneLine(int start_position) {
        for (int j = 19; j > start_position; j--) {
            rankingList[j] = rankingList[j - 1];
        }
    }

    /**
     * From list style into String style, ready for use.
     * @return In style string.
     */
    public static String preparePrint() {
        String result = "Name, Destroyed Asteroid Number, Beaten Boss Number, Live Time, Score\n";
        for (String[] a : rankingList) {
            if (a == null) return result;
            for (String b : a) {
                if (b == null) break;
                result = result + b + " ";
            }
            result = result + "\n";
        }
        return result;
    }

    /**
     * Judge two String type time is same or not.
     * @param in one time.
     * @param old another time.
     * @return true or false.
     */
    public static boolean compareTime(String in, String old) {
        String[] inList = in.split(":");
        String[] oldList = old.split(":");
        if (Integer.parseInt(inList[0]) > Integer.parseInt(oldList[0])) {
            return true;
        } else if (Integer.parseInt(inList[0]) == Integer.parseInt(oldList[0])) {
            if (Integer.parseInt(inList[1]) > Integer.parseInt(oldList[1])) return true;
            else return false;
        } else return false;
    }
}
