import java.io.*;
import java.util.*;

public class saddle {
    public static Scanner scn=new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        // write your code here
        int n=scn.nextInt();
        int[][]a=new int[n][n];
        input(a);
        for(int row=0; row<n; row++){
            int rowMin=a[row][0];
            int rowMinCol=0;
            for(int col=0; col<n; col++){
                if(rowMin>=a[row][col]){
                    rowMin=a[row][col];
                    rowMinCol=col;
                }
            }
            boolean saddleFound=true;
            for(int k=0; k<n; k++){
                if(rowMin<a[k][rowMinCol]){
                    saddleFound=false;
                    break;
                }
            }
            if(saddleFound){
                System.out.println(rowMin);
                return;
            }
        }
        System.out.println("Invalid input");
}

    public static void input(int[][]a){
        int n=a.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j]=scn.nextInt();
            }
        }
    }
}