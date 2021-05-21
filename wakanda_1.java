import java.util.*;
import java.io.*;

public class wakanda_1{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }
    
    
    public static void main(String args[]){
        int[][]arr=new int[scn.nextInt()][scn.nextInt()];
        input(arr);
        int n=arr.length;
        int m=arr[0].length;
        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                if(j%2==0)
                System.out.println(arr[i][j]);
                else
                System.out.println(arr[n-i-1][j]);
            }
            
        }

        
        
    }

}