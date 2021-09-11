import java.util.*;
public class maze_path_dp{

    public static int paths_2d_memo(int rows, int cols, int[][]dp, int[][]dir){
        if(rows == 0 && cols == 0){
            return dp[rows][cols] = 1;
        }
        if( dp[rows][cols] != 0){
            return dp[rows][cols];
        }
        int count = 0;
        for( int d = 0; d < dir.length; d++){
            int r = rows + dir[d][0], c = cols + dir[d][1];
            if( r>=0 && c>=0 && r<dp.length && c<dp[0].length){
                count += paths_2d_memo(r, c, dp, dir);
            }
        }
        return dp[rows][cols]=count;
    }

    public static int paths_2d_tabu(int ROWS, int COLS, int[][]dp, int[][]dir){
        for( int rows = 0; rows <= ROWS; rows++){
            for( int cols = 0; cols <= COLS; cols++){
                if(rows == 0 && cols == 0){
                    dp[rows][cols] = 1;
                    continue;
                }
                if( dp[rows][cols] != 0){
                    return dp[rows][cols];
                }
                int count = 0;
                for( int d = 0; d < dir.length; d++){
                    int r = rows + dir[d][0], c = cols + dir[d][1];
                    if( r>=0 && c>=0 && r<dp.length && c<dp[0].length){
                        count += dp[r][c];
                    }
                }
                dp[rows][cols]=count;
            }
        }
        return dp[ROWS][COLS];
    }

    public static void main(String[] args){
        int[][]dir = {{-1,0},{-1,-1},{0,-1}};
        int rows = 2, cols = 3;
        // int paths = paths_2d_memo( rows, cols, new int[rows+1][cols+1], dir);
        int paths = paths_2d_tabu( rows, cols, new int[rows+1][cols+1], dir);
        System.out.println(paths);

    }




}