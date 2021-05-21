import java.io.*;
import java.util.*;
public class print_maze_paths {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int numRows=scn.nextInt();
        int numCols=scn.nextInt();
        getMazePaths(1,1,numRows,numCols, "");
    }
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void getMazePaths(int sr, int sc, int dr, int dc, String ans) {
        if(sr==dr && sc==dc)
        System.out.println(ans);
        else if(dr<sr || dc<sc)return;
        else{
            getMazePaths(sr,sc+1,dr,dc, ans+'h');
            getMazePaths(sr+1,sc,dr,dc, ans+'v');
        }
    }
}