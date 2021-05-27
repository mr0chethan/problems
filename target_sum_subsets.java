import java.io.*;
import java.util.*;

public class target_sum_subsets {
    public static Scanner scn=new Scanner(System.in);

    public static void input(int[]arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        int len=scn.nextInt();
        int[] arr=new int[len];
        input(arr);
        int tar=scn.nextInt();
        printTargetSumSubsets(arr,0,"",0,tar);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        if(idx==arr.length){
            if(tar == 0)System.out.println(set);
            return;
        }
        else{
            int newTar=tar-arr[idx];
            if(newTar>=0){
                printTargetSumSubsets(arr,idx+1,set+arr[idx]+" ",sos+arr[idx],newTar);
            }
            printTargetSumSubsets(arr,idx+1,set,sos,tar);
        }
    }
}