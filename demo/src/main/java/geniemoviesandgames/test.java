package geniemoviesandgames;

import java.io.FileWriter;
import java.util.ArrayList;

public class test {
    public static void main(String[] args){
        String phrase;
        String LoanType = "2-day";
        String itemType = "Game";
        String fileToEdit = "../GenieMoviesAndGames/demo/src/main/resources/geniemoviesandgames/test.txt";
        ArrayList<Integer>numList = new ArrayList<>(null);

        phrase = "C123" + "," + "hello" + "," + itemType + "," + LoanType + ","
                + "3" + "," + "4";
        try {
            FileWriter fw = new FileWriter(fileToEdit,true);
        
            fw.write("\n"+phrase);
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(numList.size());

    }
}
