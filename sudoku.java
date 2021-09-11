public class sudoku{
    public static void solveSudoku(char[][] board) {
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
                    // if( (nosInColsBitwise [col] & mask) != 0  )return false;
                    nosInColsBitwise [col] |= mask;
                    // if( (nosInGridsBitwise [row / gridRowLen] [col / gridColLen] & mask) != 0  )return false;
                    nosInGridsBitwise [row / gridRowLen] [col / gridColLen] |= mask;
                }
            }
        }
        boolean[][] wasGivenEmpty = new boolean[ board.length ][ board[0].length ];
        for( int row = 0; row < wasGivenEmpty.length; row++){
            for( int col = 0; col < wasGivenEmpty[0].length; col++){
                if( board [row] [col] == '.'){
                    wasGivenEmpty [row] [col] =true;
                }
            }
        }
        // System.out.println(wasGivenEmpty.length);
        // System.out.println(wasGivenEmpty[0].length);
        sudokuHelper( board, wasGivenEmpty, 0, 0, nosInRowsBitwise, nosInColsBitwise, nosInGridsBitwise);
    }
    public static boolean sudokuHelper( char[][]board, boolean[][] wasGivenEmpty, int row, int col, int[] nosInRowsBitwise, int[] nosInColsBitwise, int[][] nosInGridsBitwise){
        // System.out.println(row + " " + col);
        if( row == board.length){
            return true;
        }
        int nextRow = ( row * wasGivenEmpty[0].length + col + 1 ) / wasGivenEmpty[0].length;
        int nextCol = ( row * wasGivenEmpty[0].length + col + 1 ) % wasGivenEmpty[0].length;
        if( !wasGivenEmpty [row] [col]){
            return sudokuHelper( board, wasGivenEmpty, nextRow, nextCol, nosInRowsBitwise, nosInColsBitwise, nosInGridsBitwise);
        }
        boolean solved = false;
        int gridRowLen = (int)Math.pow(board.length,0.5);
        int gridColLen = (int)Math.pow(board[0].length,0.5);
        for( int num = 1; num <= 9; num++){
            int mask = 1<<(num-1);
            if((nosInRowsBitwise[row] & mask)==0&&(nosInColsBitwise[col] & mask)==0&&(nosInGridsBitwise[row/gridRowLen][col/gridColLen]&mask)==0){
                board[row][col]=(char)(num - 0 + '0');
                nosInRowsBitwise[row] |= mask;
                nosInColsBitwise[col] |= mask;
                nosInGridsBitwise[row/gridRowLen][col/gridColLen] |= mask;
                solved = solved || sudokuHelper( board, wasGivenEmpty, nextRow, nextCol, nosInRowsBitwise, nosInColsBitwise, nosInGridsBitwise);
                if( !solved){
                    board[row][col]='.';
                    nosInRowsBitwise[row] &= ~mask;
                    nosInColsBitwise[col] &= ~mask;
                    nosInGridsBitwise[row/gridRowLen][col/gridColLen] &= ~mask;
                }
            }
        }
        return solved;
    }

    public static void main(String[] args){
        char[][] board = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','.','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'},
        };
        solveSudoku(board);
        for(int i = 0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}