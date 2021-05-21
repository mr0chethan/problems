import java.io.*;
import java.util.*;

public class max_array {

    public static void main(String[] args) throws Exception {
        // write your code here
        int [] arr={ 2,3,4,56,78,98,-1,-3,-23,456,4564,2,4};
        System.out.println(maximum(arr,0));
        System.out.println(minimum(arr,0));
        System.out.println(findData(arr,0,2));
        System.out.println(firstIdx(arr,0,2));
        System.out.println(lastIdx(arr,0,2));
    }

    public static int maximum(int[] arr, int idx){
        if(idx==arr.length) return -1000000000;
        return arr[idx] > maximum(arr,idx+1) ? arr[idx] : maximum(arr,idx+1);
    }
    public static int minimum(int[] arr, int idx){
        if(idx==arr.length) return 1000000000;
        return arr[idx] < minimum(arr,idx+1) ? arr[idx] : minimum(arr,idx+1);
    }
    public static boolean findData(int[] arr, int idx, int data){
        if(idx==arr.length) return false;
        if(arr[idx]==data) return true;
        return findData(arr, idx+1,data);
    }
    public static int firstIdx(int[] arr, int idx, int data){
        if(idx==arr.length) return -1;
        if(arr[idx]==data) return idx;
        return firstIdx(arr, idx+1, data);
    }
    public static int lastIdx(int[] arr, int idx, int data){
        
        if(idx==arr.length) return -1;
        if(lastIdx(arr, idx+1, data)==-1 && arr[idx]==data){
            ans=idx;
        return ans;
       
    }
}
