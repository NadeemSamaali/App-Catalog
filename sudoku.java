import java.util.*;

public class sudoku {
    
    public static int[][] setBoard(int N) {

        ArrayList<Integer>[] rows = new ArrayList[N];
        ArrayList<Integer>[] columns = new ArrayList[N];
        int[][] M = new int[N][N];

        for(int a = 0; a<N; a++) {
            rows[a] = new ArrayList<>();
            columns[a] = new ArrayList<>();
        }
        Random r = new Random();
           
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                
            }
        }




        return M;
    }

    public static void printBoard(int[][] M) {
        for(int i = 0; i<M.length; i++) {
            for(int j = 0; j<M.length; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printBoard(setBoard(7));
    }


}
