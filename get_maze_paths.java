import java.io.*;
import java.util.*;
public class get_maze_paths {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int numRows=scn.nextInt();
        int numCols=scn.nextInt();
        ArrayList<String>al=new ArrayList<>();
        al=getMazePaths(1,1,numRows,numCols);
        // int i=0;
        // int j=al.size()-1;
        
        // while(i<j){
        //     String temp=al.get(i);
        //     al.set(i,al.get(j));
        //     al.set(j,temp);
        //     i++;
        //     j--;
        // }

        System.out.println(al);
    }
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // int row=dr-sr;
        // int col=dc-sc;
        if(sr==dr && sc==dc){
            ArrayList<String>base=new ArrayList<>();
            base.add("");
            return base;
        }
        else if(dr<sr || dc<sc){
            ArrayList<String>base=new ArrayList<>();
            return base;
        }
        else{
            ArrayList<String> ans=new ArrayList<>();
            ArrayList<String>recAnsH=getMazePaths(sr,sc+1,dr,dc);
            for(String str:recAnsH){
                ans.add('h'+str);
            }
            ArrayList<String>recAnsV=getMazePaths(sr+1,sc,dr,dc);
            for(String str:recAnsV){
                ans.add('v'+str);
            }
            ArrayList<String>recAnsD=getMazePaths(sr+1,sc+1,dr,dc);
            for(String str:recAnsD){
                ans.add('d'+str);
            }
            return ans;
        }
    }
}