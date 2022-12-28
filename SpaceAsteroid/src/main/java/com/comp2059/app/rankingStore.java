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
            rankingList[2]= new String[]{"Admin", "0","0","0:0","0"};
            rankingList[1]= new String[]{"Fish", "20","0","1:30","60"};
            rankingList[0]= new String[]{"Smile", "233","4","3:50","233"};
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
        String[]newest = new String[5];
        newest[0]=player_name;
        newest[1]= String.valueOf(destroyed_asteroid_number);
        newest[2]= String.valueOf(beaten_boss_number);
        newest[3]=live_time;
        newest[4]= String.valueOf(total_score);
        for (int i =0;i<20;i++){
            if (rankingList[i][0]==null){
                rankingList[i]=newest;
                return;
            }
            if (Integer.parseInt(rankingList[i][4])<total_score){
                if (i!=19) moveBackOneLine(i);
                rankingList[i]=newest;
                return;
            }else if (Integer.parseInt(rankingList[i][4])==total_score){
                if (compareTime(live_time,rankingList[i][3])){
                    if (i!=19) moveBackOneLine(i);
                    rankingList[i]=newest;
                    return;
                }

            }

        }
    }
    public static void moveBackOneLine(int start_position){
        int max_len=0;
        for (int i=0;i<20;i++){
            if (rankingList[i]==null){
                break;
            }
            System.out.println(rankingList[i][0]);
            max_len=i;

        }
        for (int j = max_len+1;j>start_position;j--){
            rankingList[j]=rankingList[j-1];
        }
    }

    public static String preparePrint(){
        String result="Name, Destroyed Asteroid Number, Beaten Boss Number, Live Time, Score\n";
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
    public static boolean compareTime(String in,String old){
        String [] inList= in.split(":");
        String[]oldList=old.split(":");
        if (Integer.parseInt(inList[0])>Integer.parseInt(oldList[0])){
            return true;
        }else if (Integer.parseInt(inList[0])==Integer.parseInt(oldList[0])){
            if (Integer.parseInt(inList[1])>Integer.parseInt(oldList[1]))return true;
            else return false;
        }else return false;
    }
}
