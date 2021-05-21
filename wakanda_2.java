import java.util.*;
import java.io.*;

public class wakanda_2{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[][]a){
        int n=a.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a[i][j]=scn.nextInt();
            }
        }
    }
    
    
    public static void main(String args[]){
        int n=scn.nextInt();
        int[][]a=new int[n][n];
        input(a);
        
        
        for(int gap=0; gap<n; gap++){
            for(int row=0; row<n-gap; row++){
                System.out.println(a[row][row+gap]);
            }
        }
        


        
        
    }

}