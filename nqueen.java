import java.io.*;
import java.util.*;
public class nqueen {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        // int n=scn.nextInt();
        int n = 4;
        int[][]chessBoard=new int[n][n];
        boolean[][]spaceUsed=new boolean[n][n];
        // nqueen(chessBoard,"",0);

        // canQueenBePlaced2(spaceUsed,1,2);

        // System.out.println( spaceElementCombinations2D(spaceUsed, 0, n, 0, ""));
        // System.out.println( spaceElementPermutations2D(spaceUsed, n, 0, ""));
        boolean[]rowNotSafe = new boolean[chessBoard.length];
        boolean[]colNotSafe = new boolean[chessBoard[0].length];
        boolean[]rowPlusColNotSafe = new boolean[ chessBoard.length + chessBoard[0].length ];
        boolean[]rowMinusColPlusNminus1NotSafe = new boolean[ chessBoard.length + chessBoard[0].length -1];
        System.out.println( spaceElementCombinations2D2( rowNotSafe, colNotSafe, rowPlusColNotSafe, rowMinusColPlusNminus1NotSafe, 0, 0, n, "") );
        // System.out.println( spaceElementPermutations2D2( rowNotSafe, colNotSafe, rowPlusColNotSafe, rowMinusColPlusNminus1NotSafe, 0, n, "") );


    }

    public static boolean canQueenBePlaced1( boolean[][]spaceUsed, int row, int col){
        for( int i = 0; i<spaceUsed.length; i++){
            if( spaceUsed[i][col] ){
                return false;
            }
        }
        for( int j = 0; j<spaceUsed[0].length; j++){
            if( spaceUsed[row][j] ){
                return false;
            }
        }
        int rowPlusCol = row + col;
        for( int i = 0; i<=rowPlusCol; i++) {
            if( rowPlusCol-i<spaceUsed.length && i<spaceUsed[0].length && spaceUsed[rowPlusCol-i][i] ){
                return false;
            }
        }
        int rowMinusCol = row - col;
        for( int i = 0; i<spaceUsed.length; i++) {
            if( i-rowMinusCol<spaceUsed[0].length && i-rowMinusCol>=0 && spaceUsed[i][i-rowMinusCol] ){
                return false;
            }
        }
        return true;
    }

    public static boolean canQueenBePlaced2( boolean[][]spaceUsed, int row, int col){
        
        int[][] dir = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};

        int maxOfRowCol = spaceUsed.length>spaceUsed[0].length ? spaceUsed.length : spaceUsed[0].length;

        for( int d = 0; d<dir.length; d++){
            for( int rad = 1; rad<maxOfRowCol; rad++){
                int r = row + dir[d][0]*rad;
                int c = col + dir[d][1]*rad;
                if( r<0 || r>=spaceUsed.length || c<0 || c>=spaceUsed.length){
                    break;
                }
                if(spaceUsed[r][c]){
                    return false;
                }
            }
        }
        return true;
    }




    public static int spaceElementCombinations2D( boolean[][] spaceUsed, int spaceIndexNextAvailable, int totalNoOfElements, int elementIndexToBePlaced, String spaceElementCombinationsSoFar){
        if( elementIndexToBePlaced == totalNoOfElements){
            System.out.println(spaceElementCombinationsSoFar + ".");
            return 1;
        }
        int noOfspaceElementCombinations=0;
        for( int spaceIndex = spaceIndexNextAvailable; spaceIndex < spaceUsed.length * spaceUsed[0].length; spaceIndex++ ){
            int row = spaceIndex / spaceUsed[0].length;
            int col = spaceIndex % spaceUsed[0].length;
            // if( canQueenBePlaced1( spaceUsed, row, col)){
            if( canQueenBePlaced2( spaceUsed, row, col)){
                spaceUsed [row] [col] = true;
                noOfspaceElementCombinations += spaceElementCombinations2D( spaceUsed, spaceIndex + 1, totalNoOfElements, elementIndexToBePlaced + 1, spaceElementCombinationsSoFar + "(" + row + ", " + col + ")->" + elementIndexToBePlaced + ", ");
                spaceUsed [row] [col] = false;
            }
        }
        return noOfspaceElementCombinations;
    }

    public static int spaceElementPermutations2D2( boolean[]rowNotSafe, boolean[]colNotSafe, boolean[]rowPlusColNotSafe, boolean[]rowMinusColPlusNminus1NotSafe, int queenToBePlaced, int totalNoOfQueens, String queensPlacedSoFar){
        if( queenToBePlaced == totalNoOfQueens){
            System.out.println(queensPlacedSoFar + ".");
            return 1;
        }
        int count = 0;
        for( int row = 0; row<rowNotSafe.length; row++){
            for( int col = 0; col<colNotSafe.length; col++){
                if( !rowNotSafe[row] && !colNotSafe[col] && !rowPlusColNotSafe[row+col] && !rowMinusColPlusNminus1NotSafe[row-col+colNotSafe.length-1]){
                    rowNotSafe[row] = colNotSafe[col] = rowPlusColNotSafe[row+col] = rowMinusColPlusNminus1NotSafe[row-col+colNotSafe.length-1] = true;
                    count += spaceElementPermutations2D2( rowNotSafe, colNotSafe, rowPlusColNotSafe, rowMinusColPlusNminus1NotSafe, queenToBePlaced+1, totalNoOfQueens, queensPlacedSoFar +  "(" + row + ", " + col + ")->" + queenToBePlaced + ", ");
                    rowNotSafe[row] = colNotSafe[col] = rowPlusColNotSafe[row+col] = rowMinusColPlusNminus1NotSafe[row-col+colNotSafe.length-1] = false;
                }
            }
        }
        return count;
    }

    public static int spaceElementCombinations2D2( boolean[]rowNotSafe, boolean[]colNotSafe, boolean[]rowPlusColNotSafe, boolean[]rowMinusColPlusNminus1NotSafe, int spaceIndexNextAvailable, int queenToBePlaced, int totalNoOfQueens, String queensPlacedSoFar){
        if( queenToBePlaced == totalNoOfQueens){
            System.out.println(queensPlacedSoFar + ".");
            return 1;
        }
        int count = 0;
        for( int spaceIndex = spaceIndexNextAvailable; spaceIndex < rowNotSafe.length * colNotSafe.length; spaceIndex++ ){

            int row = spaceIndex / colNotSafe.length;
            int col = spaceIndex % colNotSafe.length;
            if( !rowNotSafe[row] && !colNotSafe[col] && !rowPlusColNotSafe[row+col] && !rowMinusColPlusNminus1NotSafe[row-col+colNotSafe.length-1]){
                rowNotSafe[row] = colNotSafe[col] = rowPlusColNotSafe[row+col] = rowMinusColPlusNminus1NotSafe[row-col+colNotSafe.length-1] = true;
                count += spaceElementCombinations2D2( rowNotSafe, colNotSafe, rowPlusColNotSafe, rowMinusColPlusNminus1NotSafe, spaceIndex+1, queenToBePlaced+1, totalNoOfQueens, queensPlacedSoFar +  "(" + row + ", " + col + ")->" + queenToBePlaced + ", ");
                rowNotSafe[row] = colNotSafe[col] = rowPlusColNotSafe[row+col] = rowMinusColPlusNminus1NotSafe[row-col+colNotSafe.length-1] = false;
            }
        }
        return count;
    }

    public static int spaceElementPermutations2D (boolean[][] spaceUsed, int totalNoOfElements, int elementIndexToBePlaced, String spaceElementPermutationsSoFar){
        if( elementIndexToBePlaced == totalNoOfElements){
            System.out.println( spaceElementPermutationsSoFar );
            return 1;
        }
        int noOfSpaceElementPermutations=0;
        for( int spaceIndex = 0; spaceIndex < spaceUsed.length * spaceUsed[0].length; spaceIndex++){
            int row = spaceIndex / spaceUsed[0].length;
            int col = spaceIndex % spaceUsed[0].length;
            // if( !spaceUsed [row] [col] && canQueenBePlaced1( spaceUsed, row, col) ){
            if( !spaceUsed [row] [col] && canQueenBePlaced2( spaceUsed, row, col) ){
                spaceUsed [row] [col] = true; 
                noOfSpaceElementPermutations += spaceElementPermutations2D( spaceUsed, totalNoOfElements, elementIndexToBePlaced + 1, spaceElementPermutationsSoFar + "(" + row + ", " + col + ")->" + elementIndexToBePlaced + ", ");
                spaceUsed [row] [col] =false;
            }
        }
        return noOfSpaceElementPermutations;
    }

    public static void nqueen(int[][]chessBoard,String qsf,int row){
        if(row==chessBoard.length){
            System.out.println(qsf+".");
            return;
        }
        else if(row<chessBoard.length){
            int i=row;
            for(int j=0;j<chessBoard.length;j++){
                if(chessBoard[i][j]==0){
                    row++;
                    String qsfPrev=qsf;
                    qsf=qsf+i+"-"+j+",";
                    int min=i<=j ? i : j;
                    int max=i+j>=chessBoard.length ? i+j : chessBoard.length;
                    for(int x=0;x<max;x++){
                        if(x<chessBoard.length && chessBoard[i][x]==0)chessBoard[i][x]=row;
                        if(x<chessBoard.length && chessBoard[x][j]==0)chessBoard[x][j]=row;
                        if(i-min+x<chessBoard.length && j-min+x<chessBoard.length && chessBoard[i-min+x][j-min+x]==0)chessBoard[i-min+x][j-min+x]=row;
                        if(i-x>=0 && j+x<chessBoard.length && chessBoard[i-x][j+x]==0)chessBoard[i-x][j+x]=row;
                        if(j-x>=0 && i+x<chessBoard.length && chessBoard[i+x][j-x]==0)chessBoard[i+x][j-x]=row;
                    }
                    nqueen(chessBoard,qsf,row);
                    for(int x=0;x<max;x++){
                        if(x<chessBoard.length && chessBoard[i][x]==row)chessBoard[i][x]=0;
                        if(x<chessBoard.length && chessBoard[x][j]==row)chessBoard[x][j]=0;
                        if(i-min+x<chessBoard.length && j-min+x<chessBoard.length && chessBoard[i-min+x][j-min+x]==row)chessBoard[i-min+x][j-min+x]=0;
                        if(i-x>=0 && j+x<chessBoard.length && chessBoard[i-x][j+x]==row)chessBoard[i-x][j+x]=0;
                        if(j-x>=0 && i+x<chessBoard.length && chessBoard[i+x][j-x]==row)chessBoard[i+x][j-x]=0;
                    }
                    row--;
                    qsf=qsfPrev;
                }
            }
        }
    }
}