import java.io.*;
import java.util.*;

public class spiral{
    public static Scanner scn = new Scanner(System.in);

    public static void input(int[][] arr){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[row].length; col++){
                arr[row][col]=scn.nextInt();
            }
        }
    }
    // throws Exception
    

    public static void main(String[] args)  {
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        input(arr);

        int rmin=0, cmin=0, rmax=n-1, cmax=m-1;

        int r,c;

        while(true){
            if(rmax<rmin){
                return;
            }
            for(r=rmin; r<=rmax; r++){
                c=cmin;
                System.out.println(arr[r][c]);
            }
            cmin++;
            if(cmax<cmin){
                return;
            }
            for(c=cmin; c<=cmax; c++){
                r=rmax;
                System.out.println(arr[r][c]);
            }
            rmax--;
            if(rmax<rmin){
                return;
            }
            for(r=rmax; rmin<=r; r--){
                c=cmax;
                System.out.println(arr[r][c]);
            }
            cmax--;
            if(cmax<cmin){
                return;
            }
            for(c=cmax; cmin<=c;c--){
                r=rmin;
                System.out.println(arr[r][c]);
            }
            rmin++;
            
        }
    }
}