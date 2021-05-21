import java.io.*;
import java.util.*;
public class flood_fill {
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
        //tail recursion or way up
        // int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        // String[] dirS={"d","r","t","l"};
        // System.out.println(floodfill(arr,0,0,"",dir,dirS));

        //tail recursion or way up 8 directions 
        // int[][]dir={{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
        // String[] dirS={"d","DR","r","TR","t","TL","l","DL"};
        // System.out.println(floodfill(arr,0,0,"",dir,dirS));

        //head recursion or way down
        // System.out.println(floodfill(arr,0,0));
    }

    //tail recursion or way up, for loop, check before
    public static int floodfill(int[][]maze,int sr,int sc,String ans,int[][]dir,String[]dirS){
        int dr=maze.length-1, dc=maze[0].length-1;
        if(sr==dr && sc==dc){
            System.out.println(ans);
            return 1;
        }
        else{
            maze[sr][sc]=1;
            int count=0;
            for(int d=0; d<dir.length; d++){
                int r=sr+dir[d][0], c=sc+dir[d][1];
                if(0<=r && r<=dr && 0<=c && c<=dc && maze[r][c]!=1) count+=floodfill(maze,r,c,ans+dirS[d],dir,dirS);
            }
            maze[sr][sc]=0;
            return count;
        }
    }

    //tail recursion or way up, for loop, check after
    // public static int floodfill(int[][]maze,int sr,int sc,String ans,int[][]dir,String[]dirS){
    //     int dr=maze.length-1, dc=maze[0].length-1;
    //     if(sr==dr && sc==dc){
    //         System.out.println(ans);
    //         return 1;
    //     }
    //     else if(sr<0 || dr<sr || sc<0 || dc<sc|| maze[sr][sc]==1) return 0;
    //     else{
    //         int count=0;
    //         maze[sr][sc]=1;
    //         for(int d=0; d<dir.length; d++) count+=floodfill(maze,sr+dir[d][0],sc+dir[d][1],ans+dirS[d],dir,dirS);
    //         maze[sr][sc]=0;
    //         return count;
    //     }
    // }

    //head recursion or way down, individual case, check before
    // public static ArrayList<String> floodfill(int[][] maze, int sr, int sc) {
    //     if(sr==maze.length-1 && sc==maze[0].length-1){
    //         ArrayList<String>base=new ArrayList<>();
    //         base.add("");
    //         return base;
    //     }
    //     else{
    //         maze[sr][sc]=1;
    //         ArrayList<String>ans=new ArrayList<>();
    //         if(sr<maze.length-1 && maze[sr+1][sc]!=1){
    //             ArrayList<String>recAnsD=floodfill(maze, sr+1, sc);
    //             for(String s:recAnsD) ans.add("d"+s);
    //         }
    //         if(sc<maze[0].length-1 && maze[sr][sc+1]!=1){
    //             ArrayList<String>recAnsR=floodfill(maze, sr, sc+1);
    //             for(String s:recAnsR) ans.add("r"+s);
    //         }
    //         if(0<sr && maze[sr-1][sc]!=1){
    //             ArrayList<String>recAnsT=floodfill(maze, sr-1, sc);
    //             for(String s:recAnsT) ans.add("t"+s);
    //         }
    //         if(0<sc && maze[sr][sc-1]!=1){
    //             ArrayList<String>recAnsL=floodfill(maze, sr, sc-1);
    //             for(String s:recAnsL) ans.add("l"+s);
    //         }            
    //         maze[sr][sc]=0;
    //         return ans;
    //     }
    // }    
}
