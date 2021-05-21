import java.io.*;
import java.util.*;

public class first_last_index_recursion {
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
        boolean firstFound=false;
        firstLastIndex(arr, 0, x, firstFound);
    }

    public static void firstLastIndex(int[] arr, int idx, int x, boolean firstFound){
        if(idx==arr.length) System.out.println(-1);
        if(!firstFound && arr[idx]==x){
            // firstFound=true;
            System.out.println(idx);
            firstLastIndex(arr, arr.length-1, x, true);
        }
        else if(!firstFound && arr[idx]!=x) firstLastIndex(arr, idx+1, x, firstFound);
        else if(firstFound && arr[idx]==x) System.out.println(idx);
        else firstLastIndex(arr, idx-1, x, firstFound);
    }

}