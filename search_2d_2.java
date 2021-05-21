import java.util.*;
import java.io.*;

public class search_2d{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[][]a){
        int n=a.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j]=scn.nextInt();
            }
        }
    }
    
    
    public static main(String args[]){
        int n=scn.nextInt();
        int[][]a=new int[n][n];
        input(a);
        int x=scn.nextInt();

        int row=0; int col=0;

        if(x<a[row][col]){
            System.out.println("Not Found");
            return;
        }

        while(true){
            if(x==a[row][col]){
                System.out.println(row+"\n"+col);
                break;
            }
            if(col+1<=n-1 && a[row][col+1]<=x) col++;
            if((col=n-1 || x<a[row][col+1]) && a[row][col]<x) row++;
            if((x<a[row][col+1] && x<a[row+1][col])) col--;
            else{
                System.out.println("Not Found");
                break;
            }
    }

        
        
        
        


        
        
    }


}