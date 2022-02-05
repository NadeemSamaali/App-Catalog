import java.time.LocalTime;
import java.util.*;

/**
 * TypeMaster is a program that calculates typing speed and accuracy of user.
 * 
 * 1.0.0 | First release
 * 1.1.0 | Programm can now calculate and output typing accuracy
 * 1.1.1 | Added more words
 * 1.1.2 | Program will remove extra characters from input if it exceeds the wordSequence length
 * @version 1.1.2
 */

public class TypeMaster {
    
    //Word array
    static String[] word = {"this", "orange", "without", "command",
    "envelope", "insectarium", "lantern", "follow", "dinosaur",
    "instructor", "building", "tall", "commence", "university",
    "village", "video", "media", "throughout", "apparently", "velocity",
    "commercial", "computer", "cat", "plant", "nature", "if", "so", "very",
    "refresh", "science", "brother", "sister", "family", "know", "eat", "throw",
    "speak", "quotient", "helicopter", "information", "sausage", "neighbour", "vehicle",
    "shirt", "pants", "wardrobe", "go", "outside", "inside", "over", "under", "a",
    "many", "religion", "transit", "public", "education", "forest", "color", "leaf", "rock",
    "zebra", "yogurt", "veganism", "utopia", "Loona", "apple", "tidings", "reality"};

    //Word placement array
    static ArrayList<Integer> wordPlacement = new ArrayList<Integer>();

    static String wordSequence = "";
    static String answer;

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
            wordSequence += word[wordNum] + " ";
        }
        wordSequence = wordSequence.substring(0, (wordSequence.length() - 1));
        System.out.println(wordSequence);

        //Calculating typing speed
        double start = LocalTime.now().toNanoOfDay();
        Scanner input = new Scanner(System.in);
        answer = input.nextLine();
        double end = LocalTime.now().toNanoOfDay();
        double timeElapsed = end - start;
        double seconds = timeElapsed / 1000000000.0;
        int numChar = answer.length();
        int wpm = (int)(((numChar/5) / seconds) * 60);


        while(answer.length() > wordSequence.length()){
            answer = answer.substring(0, (answer.length() - 1));
        }

        char[] wordSequenceChar = wordSequence.toCharArray();
        char[] answerChar = answer.toCharArray();


        System.out.println("\n# # # RESULTS # # #\n|| Your speed is " + wpm + " words per minute");
        System.out.println("|| Your typing accuracy is : " + getAccuracy(wordSequenceChar, answerChar) + "%");
    }
    
    /**
     * This method allows to calculate the typing accuracy of the users by converting the computer
     * generated word sequence and the user input into character arrays. Then, this method will compare
     * each caracter of the two character arrays to look for similarities and differences. For every
     * character that is indentical, the method will record a correct character. The amount of correct
     * characters will be compared with the total amount of characters and output an accuracy percentage
     * 
     * @param wordSequenceChar reference to the wordSequenceChar array in the main class
     * @param answerChar reference to the answerChar array in the main class
     * @return accuracy
     * @version 1.0.0
     */
    public static Double getAccuracy(char[] wordSequenceChar, char[] answerChar){

        double accuracy;

        double correctChar = 0;
        double totalChar = wordSequenceChar.length;

        for(int j = 0; j < answerChar.length; j++){
            if(wordSequenceChar[j] == answerChar[j])
                correctChar++;
        }

        accuracy = (correctChar / totalChar)*100;

        return accuracy;
    }

}
