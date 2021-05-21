import java.io.*;
import java.util.*;

public class last_index {
    public static Scanner scn=new Scanner(System.in);


    public static void input(int[]arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        int n=scn.nextInt();
        int[]arr=new int[n];
        input(arr);
        int x=scn.nextInt();
        System.out.println(lastIndex(arr, n-1, x));
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx==-1)
        return -1;
        if(arr[idx]==x)
        return idx;
        return lastIndex(arr, idx-1, x);
    }

}