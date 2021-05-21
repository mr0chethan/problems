import java.io.*;
import java.util.*;
public class longest_path_length {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        String[] dirS={"d","r","t","l"};
        System.out.println(longestPathLength(arr,0,0,dir));
        System.out.println(shortestPathLength(arr,0,0,dir));

    }
    public static int longestPathLength(int[][]maze,int sr,int sc,int[][]dir){
        int dr=maze.length-1;
        int dc=maze[0].length-1;
        if(sr==dr && sc==dc){
            return 0;
        }
        else{
            int len=-1;
            maze[sr][sc]=1;

            for(int d=0; d<dir.length; d++){
                int r=sr+dir[d][0];
                int c=sc+dir[d][1];
                if(0<=r && r<=dr && 0<=c && c<=dc && maze[r][c]!=1){
                    int recLen=longestPathLength(maze,r,c,dir);
                    len=recLen>len ? 1+recLen:len;
                }
            }
            maze[sr][sc]=0;
            return len;
        }
    }
    public static int shortestPathLength(int[][]maze,int sr,int sc,int[][]dir){
        int dr=maze.length-1;
        int dc=maze[0].length-1;
        if(sr==dr && sc==dc){
            return 0;
        }
        else{
            int len=1000000000;
            maze[sr][sc]=1;

            for(int d=0; d<dir.length; d++){
                int r=sr+dir[d][0];
                int c=sc+dir[d][1];
                if(0<=r && r<=dr && 0<=c && c<=dc && maze[r][c]!=1){
                    int recLen=shortestPathLength(maze,r,c,dir);
                    len=recLen<len ? 1+recLen:len;
                }
            }
            maze[sr][sc]=0;
            return len;
        }
    }
}
   