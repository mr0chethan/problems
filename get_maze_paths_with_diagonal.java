import java.io.*;
import java.util.*;
public class get_maze_paths_with_diagonal {
    public static Scanner scn=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int numRows=scn.nextInt();
        int numCols=scn.nextInt();
        // ArrayList<String>al=new ArrayList<>();
        // al=getMazePaths(1,1,numRows,numCols);
        // int i=0;
        // int j=al.size()-1;
        
        // while(i<j){
        //     String temp=al.get(i);
        //     al.set(i,al.get(j));
        //     al.set(j,temp);
        //     i++;
        //     j--;
        // }

        int[][]dir={{0,1},{}}

        System.out.println(getMazePaths(1,1,numRows,numCols));
    }
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column

    public static ArrayList<String>getMazePaths(int sourceRow,int sourceCol,int destRow,int destCol){

    }



    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        // int row=dr-sr+1;
        // int col=dc-sc+1;
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
            
            for(int i=1; i<=dc-sc; i++){
                ArrayList<String>recAnsH=getMazePaths(sr,sc+i,dr,dc);
                for(String str:recAnsH){
                    ans.add("h"+String.format("%d",i)+str);
                }
            }
            
            for(int i=1; i<=dr-sr; i++){
                ArrayList<String>recAnsV=getMazePaths(sr+i,sc,dr,dc);
                for(String str:recAnsV){
                    ans.add("v"+String.format("%d",i)+str);
                }
            }
            int numD=dc-sc<dr-sr ? dc-sc : dr-sr;

            for(int i=1; i<=numD; i++){
                ArrayList<String>recAnsD=getMazePaths(sr+i,sc+i,dr,dc);
                for(String str:recAnsD){
                    ans.add("d"+String.format("%d",i)+str);
                }
            }

            return ans;
        }
    }
}