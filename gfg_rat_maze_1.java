import java.io.*;
import java.util.*;

public class gfg_rat_maze_1{
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = scn.nextInt();
            }
        }
        System.out.println(findPath(m,n));
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][]dir={{-1,0},{1,0},{0,-1},{0,1}};
        String[]dirS={"U","D","L","R"};
        return myFindPath(m,0,0,dir,dirS);
    }
    public static ArrayList<String>myFindPath(int[][]m,int sr,int sc,int[][]dir,String[]dirS){
        System.out.println("calling: "+sr+" "+sc);
        if(sr==m.length-1 && sc==m[0].length-1){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        else{
            m[sr][sc]=0;
            ArrayList<String>ans=new ArrayList<>();
            for(int d=0; d<dir.length; d++){
                int r=sr+dir[d][0];
                int c=sc+dir[d][1];
                if(0<=r && 0<=c && r<m.length && c<m[0].length && m[r][c]==1){
                    ArrayList<String>recAns=myFindPath(m,r,c,dir,dirS);
                    for(String s:recAns) ans.add(dirS[d]+s);
                }
            }
            m[sr][sc]=1;
            return ans;
        }
    }
}

    