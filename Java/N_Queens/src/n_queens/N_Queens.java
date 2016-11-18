package n_queens;
import java.util.Scanner;
/**
 *
 * @author jameswilliams
 */
public class N_Queens {
    static int bSize;
    static char board[][];
    // read line in (integer < alphabet lenghth)
    // then run n-queens on board
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter the board size: ");
        int in = reader.nextInt();
        System.out.println("You chose a " +in+"x"+in+" size chess board\n");
        bSize = in; 
        N_Queens board = new N_Queens(bSize); 
        addQueens(0);
    }
    // creating new board, set to bSize*bSize
    // then fill it with 'X' for empty spaces
    public N_Queens(int bSize){
        this.bSize = bSize; 
        board = new char[bSize][bSize];
        for (int i = 0; i < bSize; i++)
            for (int j = 0; j < bSize; j++)
                board[i][j] = 'X';
    }
    // prints the array / board
    static void printBoard(){
        char layout[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        System.out.print(" _|");
        for (int i = 0; i < board.length; i++) {
            System.out.print("_"+layout[i]);
        }
        for (int i = 0; i < board.length; i++) {
            System.out.println("");
            for (int j = 0; j < board.length; j++) {
                if(j == 0)  
                    System.out.format("%2d|",(i+1));
                System.out.print(" "+board[i][j]);
            }
        }
        System.out.println("\n");
    }
    static boolean addQueens(int c){
//        printBoard(); 
        int r=0; boolean inPlay = false;
        if (c == bSize-1){
            printBoard();
        }
        else{ 
            do{
                if(!spotCheck(r,c)) // bad spot, no can do
                    r++; 
                else{ // spot seems legit, play queen
                    board[r][c] = 'Q';
                    if (board[r][c+1] != 'Q'){
                        inPlay = false;  
//                        printBoard(); 
                        addQueens(c+1);
                    }
                    if(!inPlay){
                        board[r][c] = 'X';
                        r++; 
                    }
                }
            }while(r < bSize-1 && !inPlay); 
        } 
        return inPlay; 
    }
    static boolean spotCheck(int r, int c){
        return (!rowCheck(r, c) && !angleCheck(r,c)); 
    }
    static boolean rowCheck(int r, int c){
        // check if Queens are on r
        for (int col = 0; col < c; col++) {
            if(board[r][col] == 'Q')
                return true;
        }
        return false; 
    }
    // (debug for end of board vals)
    static boolean angleCheck(int r, int c){
        // going up (debug for end of board vals)
        for (int col = 0; col > c; col++) {
           if(r+col >= bSize)
               break; 
           if(board[r+col][c-col] == 'Q')
               return true; 
        }
        // going down (debug for end of board vals)
        for (int col = 0; col < c; col++) {
            if (r <= col) 
                break; 
            if (board[r-col][c-col] == 'Q')
                return true; 
        }
        return false; 
    }
}
