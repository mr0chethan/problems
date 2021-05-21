import java.io.*;
import java.util.*;

public class display_array {
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // write your code here
        int n=scn.nextInt();
        int[]arr=new int[n];
        input(arr);
        displayArr(arr,n);

    }
    public static void input(int[]arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }


    public static void displayArr(int[] arr, int idx){
        if(idx==0)
        return;
        displayArr(arr, idx-1);
        System.out.println(arr[idx-1]);
        return;
        
    }

}