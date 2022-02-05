import java.time.LocalTime;
import java.util.*;

/**
 * TypeMaster is a program that calculates typing speed of user.
 * 
 * 1.0.0 | First release
 * @version 1.0.0
 */

public class TypeMaster {
    
    //Word array
    static String[] word = {"this", "orange", "without", "command",
    "enveloppe", "insectarium", "lantern", "follow", "dinosaur",
    "instructor", "building", "tall", "commence", "university",
    "village", "video", "media", "throughout", "apparently", "velocity",
    "commercial", "computer", "cat", "plant", "nature", "if", "so", "very",
    "refresh", "science", "brother", "sister", "family"};

    //Word placement array
    static ArrayList<Integer> wordPlacement = new ArrayList<Integer>();


    public static void main(String[] args){

        Random r = new Random();
        int wordNum;

        System.out.println("# # # Welcome to TypeMaster # # #\n\n>> Type these words as fast as possible\n");
        
        //Printing the word sequence
        for(int i = 0; i < 10; i++){
            wordNum = r.nextInt(word.length);

            //Check for duplicate placements
            while(wordPlacement.contains(wordNum))
                wordNum = r.nextInt(word.length);

            wordPlacement.add(wordNum);
            System.out.print(word[wordNum] + " ");
        }

        //Calculating typing speed
        System.out.println();
        double start = LocalTime.now().toNanoOfDay();
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        double end = LocalTime.now().toNanoOfDay();
        double timeElapsed = end - start;
        double seconds = timeElapsed / 1000000000.0;
        int numChar = answer.length();
        int wpm = (int)(((numChar/5) / seconds) * 60);
        System.out.println("\n>> Your speed is " + wpm + " words per minute");

         

    }
    
    

}
