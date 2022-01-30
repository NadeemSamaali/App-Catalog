import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This program is a simple TicTacToe game against a computer player
 * @author Nadeem Imam Samaali
 * @version 1.0.0
 */
public class TicTacToe {

    //Arraylists containing the numeral value of the human player and cpu's placements
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args){
        
        //creating the gameboard
        char[][] gameBoard = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};
        
        printGameboard(gameBoard);

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("\n>>Enter you placement (1-9) :");
            int playerPos = input.nextInt();
            
            //Checking to see if the placement entered is already taken
            boolean validPlayerMove = checkValidMove(playerPos, gameBoard);
            while(validPlayerMove == false){
                System.out.print("\n>>Sorry! Placement already taken. \n>>Enter new placement :");
                playerPos = input.nextInt();
                validPlayerMove = checkValidMove(playerPos, gameBoard);
            }

            placePiece(playerPos, gameBoard, "human");

            printGameboard(gameBoard);

            //Creating a random integer for the cpu's placement
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            
            //Checking to see if the placement entered is already taken
            boolean validCpuMove = checkValidMove(cpuPos, gameBoard);
            while(validCpuMove == false){
                cpuPos = rand.nextInt(9) + 1;
                validCpuMove = checkValidMove(cpuPos, gameBoard);
            }
            
            System.out.println("\n>>CPU has entered placement");
            placePiece(cpuPos, gameBoard, "cpu");
            printGameboard(gameBoard);
            String result = checkWinner();


            //Reseting the gameboard and the player/cpu position arrays when winning or loosing
            if(result != " "){
                resetGameBoard(gameBoard);
                playerPositions.clear();
                cpuPositions.clear();
                System.out.println(result);
                System.out.println("\n>>The game board has been reset!");
            }
        }      
    }

    /**
     * Method printing the gameboard
     * @param gameBoard : making a refenrence to the gameboard created to the main class
     */
    public static void printGameboard(char[][] gameBoard){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(gameBoard[i][j]);}
        System.out.println();}
    }

    /**
     * Method placing Xs or Os in the gameboard depending on who is playing
     * @param pos : is a number between 1 and 9 and refers to the 9 tiles of the gameBoard
     * @param gameBoard : reference to the gameboard in the main class
     * @param playerType : could be "human" or "cpu"
     */
    public static void placePiece(int pos, char[][] gameBoard, String playerType){
        char symbol = ' ';
        
        //Determinating what symbol to place according to player type
        if(playerType == "human"){
            symbol = 'X';
            playerPositions.add(pos);
        } else if (playerType == "cpu"){
            symbol = 'O';
            cpuPositions.add(pos);
        }
        
        //Placing an X or O depending on who's playing
        switch(pos)
        {
            case 1:
                gameBoard[0][0] = symbol;
            break;
            case 2:
                gameBoard[0][2] = symbol;
            break;
            case 3:
                gameBoard[0][4] = symbol;
            break;
            case 4:
                gameBoard[2][0] = symbol;
            break;
            case 5:
                gameBoard[2][2] = symbol;
            break;
            case 6:
                gameBoard[2][4] = symbol;
            break;
            case 7:
                gameBoard[4][0] = symbol;
            break;
            case 8:
                gameBoard[4][2] = symbol;
            break;
            case 9:
                gameBoard[4][4] = symbol;
            break;
        }
    }

    /**
     * Method checking who won the game depending on the numeral placements of the human player and the cpu
     * @return : return's who won the game depending on the winning contidions
     */
    public static String checkWinner()
    {
        //Creating a list for all winning combinations
        List tRow = Arrays.asList(1,2,3);
        List mRow = Arrays.asList(4,5,6);
        List bRow = Arrays.asList(7,8,9);

        List lCol = Arrays.asList(1,4,7);
        List mCol = Arrays.asList(2,5,8);
        List rCol = Arrays.asList(3,6,9);

        List dia1 = Arrays.asList(1,5,9);
        List dia2 = Arrays.asList(7,5,3);

        //Adding the winning conditions into an arraylist
        List<List> winning = new ArrayList<>();
        winning.add(tRow);
        winning.add(mRow);
        winning.add(bRow);
        winning.add(lCol);
        winning.add(mCol);
        winning.add(rCol);
        winning.add(dia1);
        winning.add(dia2);

        //Check for winner
        for(List l : winning){
            if(playerPositions.containsAll(l)){
                return "\n>>Congratulations you won!";
            } else if(cpuPositions.containsAll(l)){
                return "\n>>You lost! Try again.";
            } else if (cpuPositions.size() + playerPositions.size() == 9){
                return "\n>>Tie";
            }}

        return " ";
    }

    /**
     * Method checking if the placement inputted by the human player or the cpu is already taken or not
     * @param pos : position of the human player / cpu
     * @param gameBoard : reference to the gameboard in the main class
     * @return : winning message, loosing message, tie message or nothing
     */
    public static boolean checkValidMove(int pos, char[][] gameBoard)
    {
        switch(pos){
            case 1:
                if(gameBoard[0][0] == ' ')
                    return true;
                else
                    return false;
            case 2:
                if(gameBoard[0][2] == ' ')
                    return true;
                else
                    return false;
            case 3:
                if(gameBoard[0][4] == ' ')
                    return true;
                else
                    return false;
            case 4:
                if(gameBoard[2][0] == ' ')
                    return true;
                else
                    return false;
            case 5:
                if(gameBoard[2][2] == ' ')
                    return true;
                else
                    return false;
            case 6:
                if(gameBoard[2][4] == ' ')
                    return true;
                else
                    return false;
            case 7:
                if(gameBoard[4][0] == ' ')
                    return true;
                else
                    return false;
            case 8:
                if(gameBoard[4][2] == ' ')
                    return true;
                else
                    return false;
            case 9:
                if(gameBoard[4][4] == ' ')
                    return true;
                else
                    return false;
            default:
            return false;
        }
        
    }

    /**
     * Method resetting the gameboard
     * @param gameBoard : reference to the gameboard in the main class
     */
    public static void resetGameBoard(char[][] gameBoard)
    {
        gameBoard[0][0] = ' ';
        gameBoard[0][2] = ' ';
        gameBoard[0][4] = ' ';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';
        gameBoard[4][0] = ' ';
        gameBoard[4][2] = ' ';
        gameBoard[4][4] = ' ';
    }
    

}
