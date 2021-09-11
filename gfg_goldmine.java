import java.util.ArrayList;
class gfg_goldmine{

    static int maxGold(int n, int m, int[][]M)

    {
        // code here
        int maxGold=0;
        for(int row=0;row<n;row++){
            int goldFromRow=goldFromRowCol(M,row,0);
            if(goldFromRow>maxGold){
                maxGold=goldFromRow;
            }
        }
        return maxGold;
    }

    static int goldFromRowCol(int[][]M,int row,int col){
        int goldFromRowCol=M[row][col];
        if(col+1>=M[0].length)return goldFromRowCol;
        int maxGoldFromRight=0;
        for(int changeRow=-1;changeRow<=1;changeRow++){
            int rightRow=row+changeRow;
            if(rightRow>=0 && rightRow<M.length){
                int goldFromRight=goldFromRowCol(M,rightRow,col+1);
                if(goldFromRight>maxGoldFromRight){
                    maxGoldFromRight=goldFromRight;
                }
            }
        }
        return goldFromRowCol+maxGoldFromRight;
    }

    static ArrayList<String> getPaths(ArrayList<String>pathsSoFar){

    }

    static ArrayList<String> reverseEngineering(int[][]dp, ArrayList<Integer>maxGoldStartCols){
        ArrayList<String>ret = new ArrayList<>();
        // int[][]dir={{1,-1},{1,0},{1,1}};
        int[]colChanges={-1,1,1};
        // display2d(dp);

        for(int maxGoldStartCol:maxGoldStartCols){
            int row = 0;
            int col = maxGoldStartCol;
            // System.out.println("maxGoldStartCol: "+maxGoldStartCol);
            ArrayList<String> pathsSoFar = new ArryList<>();
            pathsSoFar.add("("+col+", "+row+")->");
            for(row=1; row<dp.length; row++){
                int maxGoldFromRow = -1;
                ArrayList<Integer>maxGoldCols;
                // int maxGoldCol=-1;
                // System.out.println("for row: "+row);
                for(int colChange : colChanges){
                    col += colChange;
                    // System.out.println("for col: "+col);
                    if(col>=0 && col<dp[0].length && dp[row][col]>maxGoldFromRow){
                        maxGoldFromRow = dp[row][col];
                        maxGoldCols = new ArrayList<>();
                        maxGoldCols.add(col);
                    }
                    else if(col>=0 && col<dp[0].length && dp[row][col]==maxGoldFromRow){
                        maxGoldCols.add(col);
                    }
                }
                path += "("+maxGoldCol+", "+row+")";
                if(row<dp.length-1){
                    path += "->";
                }
            }
            ret.add(path);
        }
        return ret;
    }

    static int maxGoldOpti(int[][]M){
        int[] maxGoldFromPrevCol = new int[M.length];
        int[] maxGoldFromCurCol = new int[M.length];
        int COL = M[0].length-1;
        int ROW = M.length-1;
        int[][]dp = new int[COL+1][ROW+1];
        for(int col=COL; col>=0; col--){
            int maxGoldRow = ROW;
            for(int row = ROW; row>=0; row--){
                int maxGold = maxGoldFromPrevCol[row];
                if(row-1>=0){
                    maxGold = Math.max(maxGold, maxGoldFromPrevCol[row-1]);
                }
                if(row+1<M.length){
                    maxGold = Math.max(maxGold, maxGoldFromPrevCol[row+1]);
                }
                maxGoldFromCurCol[row]=maxGold+M[row][col];
                
                if(row==0){
                    dp[col]=maxGoldFromPrevCol = maxGoldFromCurCol;
                    if(col!=0){
                        maxGoldFromCurCol = new int[M.length];
                    }
                }
            }
        }
        // display2d(dp);
        int maxGold = -1;
        ArrayList<Integer>maxGoldRows=new ArrayList<>();
        for( int i = 0; i<maxGoldFromCurCol.length; i++){
            if(maxGoldFromCurCol[i]>maxGold){
                maxGold = maxGoldFromCurCol[i];
                maxGoldRows = new ArrayList<>();
                maxGoldRows.add(i);
            }
            else if(maxGoldFromCurCol[i]==maxGold){
                maxGoldRows.add(i);
            }
        }
        // System.out.println(maxGoldRows);
        ArrayList<String> pathForMaxGold = reverseEngineering(dp,maxGoldRows);
        System.out.println(pathForMaxGold);

        return maxGold;
    }

    public static void display1d(int[]arr){
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void display2d(int[][]arr){
        for(int[]arr1d:arr){
            display1d(arr1d);
            // System.out.println();
        }
    }

    public static void main(String[] args){
        int[][]M={{1, 3, 3},{2, 1, 4},{0, 6, 4}};
        // int[][]M={{1, 3, 1, 5},
        // {2, 2, 4, 1},
        // {5, 0, 2, 3},
        // {0, 6, 1, 2}};
        int n=M.length;
        int m=M[0].length;
        // int maxGold=maxGold(n,m,M);
        int maxGold = maxGoldOpti(M);
        System.out.println(maxGold);
    }
}

    
