import java.io.*;
import java.util.*;

public class ring_rotate{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[][]arr){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[0].length; col++){
                arr[row][col]=scn.nextInt();
            }
        }
    }
    public static void display(int[][]arr){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[0].length; col++){
                System.out.print(arr[row][col]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception{
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][]a=new int[n][m];
        input(a);
        int s=scn.nextInt();
        int r=scn.nextInt();
        int rowMin=s-1;
        int rowMax=n-s;
        int colMin=s-1;
        int colMax=m-s;
        int rot=r%(2*(rowMax-rowMin+colMax-colMin));
        if(rot<0){
            rot+=2*(rowMax-rowMin+colMax-colMin);
        }
        for(int rotCount=0; rotCount<rot; rotCount++){
            int temp=a[rowMin][colMin];
            for(int col=colMin; col<colMax; col++){
                a[rowMin][col]=a[rowMin][col+1];
            }
            for(int row=rowMin; row<rowMax; row++){
                a[row][colMax]=a[row+1][colMax];
            }
            for(int col=colMax; colMin<col; col--){
                a[rowMax][col]=a[rowMax][col-1];
            }
            for(int row=rowMax; rowMin+1<row; row--){
                a[row][colMin]=a[row-1][colMin];
            }
            a[rowMin+1][colMin]=temp;
        }
        display(a);
        
    }
}