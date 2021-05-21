import java.io.*;
import java.util.*;

public class matrix_multiplication{
    public static Scanner scn = new Scanner(System.in);

    public static void input(int[][] matrix){
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                matrix[row][col]=scn.nextInt();
            }
        }
    }

    public static void display(int[][] matrix){
        for(int[] row : matrix){
            for(int element : row){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int[][] matrix1 = new int[n1][m1];
        input(matrix1);
        
        int n2 = scn.nextInt(), m2 = scn.nextInt();
        if(m1 != n2){
            System.out.println("Invalic input");
            return;
        }

        int[][] matrix2 = new int[n2][m2];
        input(matrix2);
        
        int[][] product = new int[n1][m2];

        for(int row=0; row<n1; row++){
            for(int col=0; col<m2; col++){
                for(int k=0; k<m1; k++){
                    product[row][col]+=matrix1[row][k]*matrix2[k][col];
                }
            }
        }

        display(product);
        
    }
}