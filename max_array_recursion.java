import java.io.*;
import java.util.*;

public class max_array_recursion {
    public static Scanner scn=new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        // write your code here
        int n=scn.nextInt();
        int[]arr=new int[n];
        input(arr);
        System.out.println(maxOfArray(arr, n));
    }

    public static void input(int[]arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }

    public static int maxOfArray(int[] arr, int idx){
        if(idx==0)
        return arr[0];
        int ans=maxOfArray(arr, idx-1);
        if(arr[idx-1]>ans){
            ans=arr[idx-1];
        }
        return ans;
    }
}