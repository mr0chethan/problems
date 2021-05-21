import java.util.*;
import java.io.*;

public class merge_sort{
    public static Scanner scn=new Scanner(System.in);
    public static int[] mergeSort(int[]arr,int si,int ei){
        if(si==ei){
            // int[]base={arr[si]};
            return new int[]{arr[si]};//base
        }
        else{
            int mid=(si+ei)/2;
            int[]arr1=mergeSort(arr,si,mid);
            int[]arr2=mergeSort(arr,mid+1,ei);
            return mergeTwoSortedArrays(arr1,arr2);
        }
    }
    public static int[]mergeTwoSortedArrays(int[]arr1,int[]arr2){
        int[]merged=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(k<merged.length){
            while(i<arr1.length && j<arr2.length){
                if(arr1[i]<=arr2[j])
                    merged[k++]=arr1[i++];
                else
                    merged[k++]=arr2[j++];
            }
            while(i<arr1.length)
                merged[k++]=arr1[i++];
            while(j<arr2.length)
                merged[k++]=arr2[j++];
        }
        return merged;
    }
    public static void print(int[]arr){
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }
     
    public static void input(int[]arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }
    public static void main(String[] args)throws Exception{
        int len=scn.nextInt();
        int[]arr=new int[len];
        input(arr);
        int[]sorted=mergeSort(arr,0,arr.length-1);
        print(sorted);
    }
}