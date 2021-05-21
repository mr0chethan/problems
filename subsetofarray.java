import java.io.*;
import java.util.*;

public class subsetofarray{
    public static Scanner scn=new Scanner(System.in);
    public static void takeArrayInput(int[] arr, int n){
        for(int i=0; i<n; i++){
            arr[i]=scn.nextInt();
        }

    }
    public static void main(String[] args){
        int n=scn.nextInt();
        int [] arr=new int[n];
        takeArrayInput(arr, n);
        


    }
}