import java.io.*;
import java.util.*;
public class gfg_special_matrix{
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[]args)throws Exception{
        int n=scn.nextInt();
        int m=scn.nextInt();
        int k=scn.nextInt();
        int[][]blocked_cells=new int[k][2];
        for(int i=0;i<blocked_cells.length;i++){
            blocked_cells[i][0]=scn.nextInt();
            blocked_cells[i][1]=scn.nextInt();
        }
       
        System.out.println(FindWays(n,m,blocked_cells));
    }

    public static void printArr(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int FindWays(int n, int m, int[][] blocked_cells)
    {
        // Code here
        int[][]arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=0;
            }
        }
        for(int i=0;i<blocked_cells.length;i++){
            arr[blocked_cells[i][0]-1][blocked_cells[i][1]-1]=-1;
        }
        
        
        int[][]dir={{1,0},{0,1}};
        String[]dirS={"d","r"};

        if(arr[0][0]==-1 || arr[n-1][m-1]==-1) return 0;
        return myFindWays(arr,0,0,dir);
    }

    public static int myFindWays(int[][]arr,int sr, int sc, int[][]dir){
        System.out.println("line1 "+sr+" "+sc);
        if(sr==arr.length-1 && sc==arr[0].length-1) return 1;
        else{
            arr[sr][sc]=-1;
            int count=0;
            for(int d=0; d<dir.length; d++){
                int r=sr+dir[d][0], c=sc+dir[d][1];
                System.out.println("line2 "+r+" "+c);
                if(0<=r && 0<=c && r<arr.length && c<arr[0].length && arr[r][c]==0)
                count+=myFindWays(arr,r,c,dir);
            }
            arr[sr][sc]=0;
            return count;
        }
    }

}    
    