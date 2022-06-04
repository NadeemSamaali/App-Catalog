import java.util.*;

/**
 * This program applies the Collatz conjecture to any natural number inputted
 * 
 * @author Nadeem Imam Samaali
 * @version 1.0.0
 * 1.0.0 | First release
 */
public class collatzconjecture {
    
    public static void main(String[] args){

        //ArrayList containing all the values outputted by the algorithm
        ArrayList<Integer> numSeq = new ArrayList<Integer>();

        String answer = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Insert the initial value : " + answer);
        answer = in.nextLine();
        int x = Integer.parseInt(answer);

        //While the value of x isn't 1, divide x by 2 if it's even or multiply by 3 and add 1 if it's odd
        while(x != 1)
        {
            if(x%2 == 0){
                x = x/2;
                numSeq.add(x);
            }

            else{
                x = 3*x +1;
                numSeq.add(x);
            }

        }

        //Print the values storred in the ArrayList
        for(int i = 0; i < numSeq.size(); i++){
            System.out.println(numSeq.get(i));
        }

        //Print out the size of the array
        System.out.println("Number of steps : " + numSeq.size());

    }


}
