import java.io.*;
import java.util.*;

public class broken_economy{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[]arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static int bin(int [] arr, int data){
        int startIndex=0;
        int endIndex=arr.length-1;
        // int midIndex=(startIndex+endIndex)/2;
        int ans=-1;
        while(startIndex<=endIndex){
            int midIndex=(startIndex+endIndex)/2;
            if(arr[midIndex]==data){
                ans=midIndex;
                break;
            }
            else if(data<arr[midIndex]){
                endIndex=midIndex-1;
            }
            else if(arr[midIndex]<data){
                startIndex=midIndex+1;
            }
        }
        return ans;
    }

public static void main(String[] args) throws Exception {
    // write your code here
    int len=scn.nextInt();
        int arr[]=new int[len];
        input(arr);
        int data=scn.nextInt();
        int bin=bin(arr,data);
        if(bin>=0){
            System.out.println(arr[bin]);
            return;
        }
        else{
            int startIndex=0;
            int endIndex=arr.length-1;
            while(endIndex-startIndex > 1){
                int midIndex=(startIndex+endIndex)/2;
                if(arr[startIndex]<data && arr[midIndex]<data){
                    startIndex=midIndex;
                }
                if(arr[endIndex]>data && arr[midIndex]>data){
                    endIndex=midIndex;
                }
            }
            System.out.println(arr[startIndex]);
            System.out.println(arr[endIndex]);
            return;
        }
 }

}