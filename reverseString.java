/**
 * This prgramm revereses strings by converting a string into a char array and printing each character from last to first
 * 
 * 1.0.0 | First release
 * 
 * @author Nadeem Imam Samaali
 * @version 1.0.0 
 */
public class reverseString {

    public static void main(String[] args){

        String message = "Programming is fun for everyone";

        char[] c = message.toCharArray();

        for(int i = (c.length - 1); i >= 0; i--){
            System.out.print(c[i]);
        }
    }
}