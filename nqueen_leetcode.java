import java.util.*;

public class nqueen_leetcode{
        public static List<List<String>> solveNQueens(int n) {
            List<String> chessBoard = new ArrayList<>();
            boolean[] colNotSafe =new boolean[ n ];
            boolean[] rowPlusColNotSafe =new boolean[ n + n - 1];
            boolean[] rowMinusColPlusNminus1NotSafe =new boolean[ n + n - 1];
            List<List<String>> chessBoards = new ArrayList<>();//
            int ans = nQueens( n, 0, colNotSafe, rowPlusColNotSafe, rowMinusColPlusNminus1NotSafe, chessBoard, chessBoards);//
            // List<List<String>> chessBoards = nQueens( n, 0, colNotSafe, rowPlusColNotSafe, rowMinusColPlusNminus1NotSafe, chessBoard);
            return chessBoards;
        }
        public static int nQueens( int n, int row, boolean[] colNotSafe, boolean[] rowPlusColNotSafe, boolean[] rowMinusColPlusNminus1NotSafe, List<String> chessBoard, List<List<String>>chessBoards ){//
        // public static List<List<String>> nQueens( int n, int row, boolean[] colNotSafe, boolean[] rowPlusColNotSafe, boolean[] rowMinusColPlusNminus1NotSafe, List<String> chessBoard){

            if( row == n){

                List<String> newChessBoard = new ArrayList<>();

                for( String rowString : chessBoard ){
                    newChessBoard.add( rowString );
                }

                chessBoards.add( newChessBoard );

                return 1;
            }
            
            int ans = 0;
            // List<List<String>>ans=new ArrayList<>();

            for( int col = 0; col < n; col++){

                if( !colNotSafe[ col ] && !rowPlusColNotSafe[ row + col ] && !rowMinusColPlusNminus1NotSafe[ row - col + n - 1 ]){

                    colNotSafe[ col ] = rowPlusColNotSafe[ row + col ] = rowMinusColPlusNminus1NotSafe [ row - col + n - 1 ] = true;

                    String rowString = "";
                    for( int i = 0; i < n; i++){
                        if( i == col ){
                            rowString += "Q";
                        }
                        else{
                            rowString += ".";
                        }
                    }

                    chessBoard.add( rowString );

                    ans += nQueens( n, row + 1, colNotSafe, rowPlusColNotSafe, rowMinusColPlusNminus1NotSafe, chessBoard, chessBoards);//
                    // List<List<String>> recAns = nQueens( n, row + 1, colNotSafe, rowPlusColNotSafe, rowMinusColPlusNminus1NotSafe, chessBoard);

                    chessBoard.remove(chessBoard.size()-1);

                    colNotSafe[ col ] = rowPlusColNotSafe[ row + col ] = rowMinusColPlusNminus1NotSafe [ row - col + n - 1] = false;
                }
            }
            return ans;
        }

        public static void main( String[] args ){
            System.out.println( solveNQueens( 5 ) );
        }
}