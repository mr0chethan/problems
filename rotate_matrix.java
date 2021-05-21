import java.io.*;
import java.util.*;

public class rotate_matrix {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        int n=scn.nextInt();
        int[][]arr=new int[n][n];
        input(arr);

        for(int row=0; row<n-1; row++){
            for(int col=row+1; col<n; col++){
                int temp=arr[row][col];
                arr[row][col]=arr[col][row];
                arr[col][row]=temp;
            }
        }

        for(int col=0; col<n/2; col++){
            for(int row=0; row<n; row++){
                int temp=arr[row][col];
                arr[row][col]=arr[row][n-1-col];
                arr[row][n-1-col]=temp;
            }
        }
        display(arr);
    }

    

    public static void input(int[][]arr){
        int n=arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=scn.nextInt();
            }
        }
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}