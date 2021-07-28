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

    public static void main(String[] args){
        // int[][]M={{1, 3, 3},{2, 1, 4},{0, 6, 4}};
        int[][]M={{1, 3, 1, 5},
        {2, 2, 4, 1},
        {5, 0, 2, 3},
        {0, 6, 1, 2}};
        int n=M.length;
        int m=M[0].length;
        int maxGold=maxGold(n,m,M);
        System.out.println(maxGold);
    }
}

    
