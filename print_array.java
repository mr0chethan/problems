import java.util.*;
import java .io.*;

public class print_array{

    public static Scanner scn=new Scanner(System.in);

    public static void printReverseArray(int [] arr, int n){
        if(n==0)
        return;
        System.out.println(arr[n-1]);
        printReverseArray(arr, n-1);
    }

    public static void printArray(int [] arr, int n){
        if(n==0)
        return;
        printArray(arr, n-1);
        System.out.println(arr[n-1]);
    }

    public static void input(int[] arr, int n){
        if(n==0)
        return;
        input(arr,n-1);
        arr[n-1]=scn.nextInt();
        
    }

    public static void main(String[] args){
        int n=scn.nextInt();
        int [] arr = new int [n];

        input(arr,n);

        // int [] arr={ 2,3,4,56,78,98,-1,-3,-23,456,4564,4};
        // int n=arr.length;
        printArray(arr,n);
        printReverseArray(arr,n);





    }
}