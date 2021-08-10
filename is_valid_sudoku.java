import java.util.*;

public class is_valid_sudoku{
    public static Scanner scn = new Scanner(System.in);

    public static void isValidSudoku(char[][] board) {
        int gridRowLen = (int)Math.pow(board.length,0.5);
        int gridColLen = (int)Math.pow(board[0].length,0.5);
        
        int[] nosInRowsBitwise = new int[ board.length ];
        int[] nosInColsBitwise = new int[ board[0].length ];
        int[][] nosInGridsBitwise = new int[board.length/gridRowLen] [board[0].length/gridColLen];
        
        for( int row = 0; row < board.length; row++){
            for( int col = 0; col < board[0].length; col++){
                char ch = board[ row ][ col ];
                if( ch >='1' && ch <='9' ){
                    int dig = ch - '0';
                    int mask = 1<<dig-1;
                    // if( (nosInRowsBitwise [row] & mask) != 0  )return false;
                    nosInRowsBitwise [row] |= mask;
                    // if( (nosInColsBitwise [row] & mask) != 0  )return false;
                    nosInColsBitwise [col] |= mask;
                    // if( (nosInGridsBitwise [row / gridRowLen] [col / gridColLen] & mask) != 0  )return false;
                    nosInGridsBitwise [row / gridRowLen] [col / gridColLen] |= mask;
                }
            }
        }

        for( int i = 0; i<nosInRowsBitwise; i++){
            for( int j = 1; j<=9; j++){
                if( (nosInRowsBitwise[i] & 1<<j-1 ) != 0 ){
                    System.out.print( j +" ");
                }
            }
            System.out.println();
        }

        // return true;
    }

    public static void main(String[] args){
        char[][]
    }
}