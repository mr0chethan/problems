import java.io.*;
import java.util.*;

public class sort012 {

  public static void sort012(int[] arr){
    //write your code here
    int i=0, j=0;
    for(int k=0; k<arr.length; k++){
        if(arr[k]==0){swap(arr,k,i++);swap(arr,k,j++);}
        else if(arr[k]==1) swap(arr,k,j++);
    }
  }

//   public static void sort012(int[] arr){
//     //write your code here
//     int i=0, j=0, k=arr.length-1;
//     while(j<=k){
//         if(arr[j]==0) swap(arr,i++,j++);
//         else if(arr[j]==1) j++;
//         else if(arr[j]==2) swap(arr,j,k--);
//     }
//   }


  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    sort012(arr);
    print(arr);
  }

}