import java.util.*;

/**
* This program is a simple Pipopipette (aka. dots and dashes) game against a computer player that places its lines randomly
* @author Nadeem Imam Samaali
* 
* @version 1.0.0
* 1.0.0 | First release
*/

public class Pipopipette {


    static ArrayList<Integer> Positions = new ArrayList<Integer>();
    static ArrayList<Integer> amountOfP = new ArrayList<Integer>();
    static ArrayList<Integer> amountOfC = new ArrayList<Integer>();

    static boolean gameover = false;
    static boolean programClosed = false;

    //Creating and 'empty' gameboard
    static char[][] gameboard = {{'.',' ','a',' ','.',' ','b',' ','.'},
                                 {'c',' ',' ',' ','d',' ',' ',' ','e'},
                                 {'.',' ','f',' ','.',' ','g',' ','.'},
                                 {'h',' ',' ',' ','i',' ',' ',' ','j'},
                                 {'.',' ','k',' ','.',' ','l',' ','.'}};

    static String playerType;

    public static void main(String[] args){


        System.out.println("\n======================\nWelcome to Pipopipette\n======================\n");

        Scanner in = new Scanner(System.in);

        resetGameBoard(gameboard);
        printGameBoard(gameboard);

        while(!programClosed){

            while(!gameover){

                String answer = "";
                playerType = "player";
    
                System.out.println();
            
                System.out.println("Enter your placement (a to l) : " + answer);
                answer = in.nextLine();
                int playerPos = numeralPlacement(answer);

                //Check to see if the inputed answer is legal
                while(playerPos == 0){
                    answer = " ";
                    System.out.println(">> This placement does not exist");
                    System.out.println(">> Enter valid placement (a to l) : " + answer);
                    answer = in.nextLine();
                    playerPos = numeralPlacement(answer);
                }

                //Check to see if the placement entered is already taken
                while(Positions.contains(playerPos)){
                    System.out.print("\n>>Sorry! Placement already taken. \n>>Enter valid placement (a to l) : ");
                    playerPos = numeralPlacement(in.nextLine());
                }
    
                //Place a line according to the position entered and a zone of a square is closed
                System.out.println("\n>> you have placed a line");
                placeLine(playerPos, gameboard);
                placeZone(gameboard, playerType);
                printGameBoard(gameboard);

                //CPU can place lines only of the board isn't full
                if(Positions.size() < 12){

                    playerType = "cpu";

                    //Creating a random integer for the cpu's placement
                    Random rand = new Random();
                    int cpuPos = rand.nextInt(12) + 1;
                    
                    //Checking to see if the placement entered is already taken
                    while(Positions.contains(cpuPos)){
                        cpuPos = rand.nextInt(12) + 1;
                    }

                    //Place a line according to the position entered and a zone of a square is closed
                    System.out.println("\n>> cpu has placed a line");
                    placeLine(cpuPos,gameboard);
                    placeZone(gameboard, playerType);
                    printGameBoard(gameboard);

                }
    
                //Exit game once the board is full
                if(Positions.size() >= 12){
                    System.out.println();
                    gameover = true;
                    System.out.println("");
                    resetGameBoard(gameboard);
                }
            }

            //Display winning or loosing message
            String winMessage = checkWinner();
            System.out.println(winMessage);
            programClosed = true;
        }        
    }

    /**
     * Method printing the gameboard
     * 
     * @param gameboard
     */
    public static void printGameBoard(char[][] gameboard){
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                System.out.print(gameboard[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * This method converts an alphabetical entry into a numeral value
     * 
     * @param answer : alphabetical value of a placement
     * @return the numeral value of a letter placement. Will return 0 if the alphabetical placement
     * doesn't exit
     */
    public static Integer numeralPlacement(String answer){

        switch(answer){
            case "a":
            return 1;
            case "b":
            return 2;
            case "c":
            return 3;
            case "d":
            return 4;
            case "e":
            return 5;
            case "f":
            return 6;
            case "g":
            return 7;
            case "h":
            return 8;
            case "i":
            return 9;
            case "j":
            return 10;
            case "k":
            return 11;
            case "l":
            return 12;
            default:
            return 0;
        }
        
    }

    /**
     * Method placing lines in between the dots of the gameboard
     * @param placement
     * @param gameboard
     */
    public static void placeLine(int placement, char[][] gameboard){

       Positions.add(placement);

        switch(placement){
            case 1:
                gameboard[0][2] = '_';
            break;
            case 2:
                gameboard[0][6] = '_';
            break;
            case 3:
                gameboard[1][0] = '|';
            break;
            case 4:
                gameboard[1][4] = '|';
            break;
            case 5:
                gameboard[1][8] = '|';
            break;
            case 6:
                gameboard[2][2] = '_';
            break;
            case 7:
                gameboard[2][6] = '_';
            break;
            case 8:
                gameboard[3][0] = '|';
            break;
            case 9:
                gameboard[3][4] = '|';
            break;
            case 10:
                gameboard[3][8] = '|';
            break;
            case 11:
                gameboard[4][2] = '_';
            break;
            case 12:
                gameboard[4][6] = '_';
            break;
            
        }
        
    }

    /**
     * Method resetting the gameboard
     * @param gameboard
     */
    public static void resetGameBoard(char[][] gameboard){
        gameboard[0][2] = 'a';
        gameboard[0][6] = 'b';
        gameboard[1][0] = 'c';
        gameboard[1][4] = 'd';
        gameboard[1][8] = 'e';
        gameboard[2][2] = 'f';
        gameboard[2][6] = 'g';
        gameboard[3][0] = 'h';
        gameboard[3][4] = 'i';
        gameboard[3][8] = 'j';
        gameboard[4][2] = 'k';
        gameboard[4][6] = 'l';
    }

    /**
     * This method will determine to whom belongs each of the zones 
     * in the gameboard according to the lines palced in game. It will indentify
     * the square zones accordingly with the tiles 'C' or 'P'
     * 
     * @param gameboard 
     * @param playerType
     */
    public static void placeZone(char[][] gameboard, String playerType){

        //Lists of square zones
        List zoneA = Arrays.asList(1,3,4,6);
        List zoneB = Arrays.asList(2,4,5,7);
        List zoneC = Arrays.asList(6,8,9,11);
        List zoneD = Arrays.asList(7,9,10,12);

        //Placing tile for zone A
        if(gameboard[1][2] == ' '){
            if(Positions.containsAll(zoneA)){
                if(playerType == "player"){
                    gameboard[1][2] = 'P';
                    amountOfP.add(1);
                }
                else if(playerType == "cpu"){
                    gameboard[1][2] = 'C';
                    amountOfC.add(1);
                }
            }
        }

        //Placing tile for zone B
        if(gameboard[1][6] == ' '){
            if(Positions.containsAll(zoneB)){
                if(playerType == "player"){
                    gameboard[1][6] = 'P';
                    amountOfP.add(1);
                }
                else if(playerType == "cpu"){
                    gameboard[1][6] = 'C';
                    amountOfC.add(1);
                }
            }
        }

        //Placing tile for zone C
        if(gameboard[3][2] == ' '){
            if(Positions.containsAll(zoneC)){
                if(playerType == "player"){
                    gameboard[3][2] = 'P';
                    amountOfP.add(1);
                }
                else if(playerType == "cpu"){
                    gameboard[3][2] = 'C';
                    amountOfC.add(1);
                }
            }
        }

        //Placing tile for zone D
        if(gameboard[3][6] == ' '){
            if(Positions.containsAll(zoneD)){
                if(playerType == "player"){
                    gameboard[3][6] = 'P';
                    amountOfP.add(1);
                }
                else if(playerType == "cpu"){
                    gameboard[3][6] = 'C';
                    amountOfC.add(1);
                }
            }
        }
    }

    /**
     * Method checking if the player won, lost or tied with the cpu.
     * @return winning, losing or tying message
     */
    public static String checkWinner(){

        if(amountOfC.size() > amountOfP.size()){
            return "You lost!";
        } else if(amountOfC.size() < amountOfP.size()){
            return "Congratulations! You won!";
        } else if(amountOfC.size() == amountOfP.size()){
            return "It's a tie";
        }

        return " ";
    }


    
}
