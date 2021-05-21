import java.io.*;
import java.util.*;

public class bar_chart{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }
    public static int maxElement(int[] arr){
        int ans=arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>ans)
            ans=arr[i];
        }
        return ans;
    }
    
    public static void main(String[] args) throws Exception {
    // write your code here
    int n=scn.nextInt();
    int[] arr=new int[n];
    input(arr);
    
    for(int row=maxElement(arr); row>=1; row--){
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=row)
            System.out.print("*\t");
            else
            System.out.print("\t");
        }
        System.out.println();
        
    }
    
 }

}