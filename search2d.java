import java.util.*;
import java.io.*;

public class search2d{
    public static Scanner scn=new Scanner(System.in);

    public static void input(int[][]arr){
        for(int row=0; row<arr.length; row++){
            for(int col=0; col<arr[0].length; col++){
                arr[row][col]=scn.nextInt();
            }
        }

    }

    public static void main(String[] args){
        int size=scn.nextInt();
        int[][]arr=new int[size][size];
        input(arr);
        int data=scn.nextInt();
        if(data<arr[0][0] || arr[size-1][size-1]<data){
            System.out.println("Not Found");
        }
        int row=0;
        int col=0;
        int rowFlag=0;
        int colFlag=0;
        while(true){
            if(arr[row][col]==data){
                System.out.println(row);
                System.out.println(col);
                return;
            }
            if(arr[row][col]<data && col!=size-1){
                rowFlag=row;
                colFlag=col;
                col++;
            }
            if(arr[row][col]<data && col==size-1){
                rowFlag=row;
                colFlag=col;
                row++;
            }
            if(data<arr[row][col] && rowFlag<row){
                col--;
            }
            if(data<arr[row][col] && colFlag<col){
                col--;
                row++;
            }
            if(data<arr[row][col] && col==0){
                System.out.println("Not Found");
                return;
            }
            

        }
    }
}
