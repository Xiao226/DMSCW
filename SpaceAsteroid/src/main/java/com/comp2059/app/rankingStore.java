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
            if (rankingList[0][0]==null)initialNeed=true;
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
    public static void addresult(String player_name,int destroyed_asteroid_number,int beaten_boss_number,String live_time,int total_score){
        for (int i=0;i<20;i++) {
            if (rankingList[i] == null){
                insertLine(i,player_name,destroyed_asteroid_number,beaten_boss_number,live_time,total_score);
                return;
            }
            if (Integer.parseInt(rankingList[i][4])>total_score){
                moveAfterWard(i);
                System.out.println(preparePrint());
                insertLine(i,player_name,destroyed_asteroid_number,beaten_boss_number,live_time,total_score);
                return;
            }
        }
    }
    public static void insertLine(int position, String player_name, int destroyed_asteroid_number, int beaten_boss_number, String live_time, int total_score){
        rankingList[position][0]=player_name;
        rankingList[position][1]= String.valueOf(destroyed_asteroid_number);
        rankingList[position][2]= String.valueOf(beaten_boss_number);
        rankingList[position][3]=live_time;
        rankingList[position][4]= String.valueOf(total_score);
    }
    public static void moveAfterWard(int start_position){
        String [][]temp=rankingList.clone();
        for (int i=start_position;i<19;i++){
            if(temp[i][0]==null){
                System.out.println("end point "+i);
                return;
            }
            rankingList[i+1]=temp[i];
        }
    }
    public static String preparePrint(){
        String result="Name, Destroyed Asreroid Number, Beaten Boss Number, Live Time, Score\n";
        for (String[]a:rankingList){
            if (a==null)return result;
            for (String b :a){
                if (b==null)break;
                result=result+b+" ";
            }
            result=result+"\n";
        }


        return result;
    }
}
