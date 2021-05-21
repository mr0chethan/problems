import java.util.*;
import java.io.*;

public class binary_search{

    public static Scanner scn=new Scanner(System.in);
    
    public static void input(int [] arr){
        for(int i=0; i<arr.length; i++){
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

        // while(!(endIndex-startIndex==1 && arr[startIndex]!=data && arr[endIndex]!=data)){
            
            // if(arr[midIndex]==data){
            //     ans=midIndex;
            //     break;
            // }
        //     else if(endIndex-startIndex==1 && arr[endIndex]==data){
        //         ans=endIndex;
        //         break;
        //     }
            
            // else if(data<arr[midIndex]){
            //     endIndex=midIndex;
            //     midIndex=(startIndex+endIndex)/2;
                
            // }
            
            // else if(arr[midIndex]<data){
            //     startIndex=midIndex;
            //     midIndex=(startIndex+endIndex)/2;
            // }
        // }
        return ans;
    }

    public static void main(String[] args){
        int len=scn.nextInt();
        int [] arr=new int[len];

        input(arr);

        int data=scn.nextInt();

        System.out.println(bin(arr,data));
    }
}