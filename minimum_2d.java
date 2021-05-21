import java.util.*;
import java.io.*;

public class minimum_2d{
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
    public static void display(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void minimum(int[][] arr){
        int min=arr[0][0];
        int n=arr.length;
        int m=arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(min>arr[i][j])
                min=arr[i][j];
            }
        }
        System.out.print(min);
        
    }
    public static void main(String args[]){
        int[][]arr=new int[scn.nextInt()][scn.nextInt()];
        input(arr);
        minimum(arr);
        
    }

}