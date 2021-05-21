import java.io.*;
import java.util.*;
public class print_maze_paths_jumps {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int numRows=scn.nextInt();
        int numCols=scn.nextInt();
        getMazePaths(1,1,numRows,numCols, "");
    }
    public static void getMazePaths(int sr, int sc, int dr, int dc, String ans) {
        if(sr==dr && sc==dc) System.out.println(ans);
        else if(dr<sr || dc<sc) return;
        else{
            for(int i=1; i<=dc-sc; i++) getMazePaths(sr,sc+i,dr,dc,ans+"h"+String.format("%d",i));
            for(int i=1; i<=dr-sr; i++) getMazePaths(sr+i,sc,dr,dc,ans+"v"+String.format("%d",i));
            int numD=dc-sc<dr-sr ? dc-sc : dr-sr;
            for(int i=1; i<=numD; i++) getMazePaths(sr+i,sc+i,dr,dc,ans+"d"+String.format("%d",i));
        }
    }
}