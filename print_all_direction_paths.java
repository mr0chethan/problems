import java.io.*;
import java.util.*;
public class print_all_direction_paths {
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
        else if(dr<sr || dc<sc || sr<0 || sc<0)return;
        else{
            getMazePaths(sr,sc+1,dr,dc, ans+'r');
            getMazePaths(sr+1,sc,dr,dc, ans+'d');
            getMazePaths(sr-1,sc,dr,dc, ans+'l');
            getMazePaths(sr,sc-1,dr,dc, ans+'t');
        }
    }
}