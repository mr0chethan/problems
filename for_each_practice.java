import java.util.*;
import java.io.*;

public class for_each_practice {
    public static Scanner scn = new Scanner(System.in);
    // public static void input(int[] arr){
    //     for(int ele : arr){
    //         ele = scn.nextInt();
    //     }
    // }
    public static void input(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }
    // public static void display(int[] arr){
    //     for(int ele : arr){
    //         System.out.print(ele+" ");
    //     }
    // }
    public static void display(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void main(String args[]) {
        int len = scn.nextInt();
        int [] arr = new int[len];
        input(arr);
        display(arr);
        
    }
}