package com.comp2059.app;

import java.io.*;

import static com.comp2059.app.informationStore.fileName;
import static com.comp2059.app.informationStore.rankingList;

public class rankingStore {
//    store structure
//    player-name destroyed-asteroid-number beaten-boss-number live-time total-score
    public static void getInformation(){
        boolean initialNeed=false;
        try {
            File file = new File(fileName);
            if (!file.exists()) file.createNewFile();
            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);
            String temp;
            for (int i =0;i<20;i++){
                temp= br.readLine();
                if (temp == null)continue;
                rankingList[i]=temp.split(" ");
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ranking file missing.");
            initialNeed=true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something wrong with the ranking file.");
            initialNeed=true;
        }
        // no data create initial data
        if (initialNeed){
            rankingList[1]= new String[]{"Fish","1:30", "20","0","66"};
            rankingList[0]= new String[]{"Smile","3:50", "233","4","233"};
        }
    }
    public static void writeTheRankingFile(){
        try {
            File file = new File(fileName);
            if (!file.exists()) file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String[]a:rankingList){
                if (a == null)continue;
                for (String b:a){
                    if (b==null)continue;
                    bw.write(b);
                    bw.write(" ");
                }
                bw.write("\n");
            }
            bw.close();
            fw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void addresult(String player_name,String destroyed_asteroid_number,String beaten_boss_number,String live_time,String total_score){
        for (int i=0;i<20;i++) {
            if (rankingList[i] == null){
                insertLine(i,player_name,destroyed_asteroid_number,beaten_boss_number,live_time,total_score);
                return;
            }
            if (Integer.parseInt(rankingList[i][4])>Integer.parseInt(total_score)){
                moveAfterWard(i);
                insertLine(i,player_name,destroyed_asteroid_number,beaten_boss_number,live_time,total_score);
                return;
            }
        }
    }
    public static void insertLine(int position, String player_name, String destroyed_asteroid_number, String beaten_boss_number, String live_time, String total_score){
        rankingList[position][0]=player_name;
        rankingList[position][1]=destroyed_asteroid_number;
        rankingList[position][2]=beaten_boss_number;
        rankingList[position][3]=live_time;
        rankingList[position][4]=total_score;
    }
    public static void moveAfterWard(int start_position){
        String [][]temp=rankingList;
        for (int i=start_position;i<20;i++){
            if (rankingList[i+1]==null)return;
            rankingList[i+1]=temp[i];
        }
    }
}
