import java.io.*;
import java.util.*;

public class sort01 {

//   public static void sort01(int[] arr){
//     long time1 = System.nanoTime();
//     //write your code here
//     if(arr.length<2) return;//if arr is having 0 or 1 element
//     int i=0;
//     while(arr[i]!=0) i++;//i will be smallest index of 0 if 0 is an element of arr else i will be arr.length
//     if(i==arr.length) return;
//     if(i!=0) swap(arr,0,i);//if 0 is an element of arr but not not at index 0
//     if(i==arr.length-1) return;//if only one 0 at index arr.length-1
//     int j=0;//0s till j, sorted till k-1, if 1 is found at k move forward, if 0 is found at k swap it with 1st 1 and increase j by 1 and move forward
//     for(int k=i+1; k<arr.length; k++)if(arr[k]==0)swap(arr,++j,k); 
//     long time2 = System.nanoTime();
//     long timeTaken = time2 - time1;  
//     System.out.println("Time taken " + timeTaken + " ns");
// }

// public static void sort01(int[]arr){
//     long time1 = System.nanoTime();
//     int i=0; 
//     int j=arr.length-1;
//     while(i<j){
//         if(arr[i]==1 && arr[j]==0) swap(arr,i,j);//if 0 is in back and 1 is in front swap them
//         if(arr[i]==0) i++;//if 0 is in front move forward
//         if(arr[j]==1) j--;//if 1 is in back move backward
//     }
//     long time2 = System.nanoTime();
//     long timeTaken = time2 - time1;  
//     System.out.println("Time taken " + timeTaken + " ns");
// }

// public static void sort01(int[]arr){
//     long time1 = System.nanoTime();
//     int count0=0;//count number of 0s checking each element of arr, change first count0 elements to 0 and remaining elements to 1
//     for(int i=0; i<arr.length; i++){
//         if(arr[i]==0) count0++;
//     }
//     for(int i=0; i<count0; i++) arr[i]=0;
//     for(int i=count0; i<arr.length; i++) arr[i]=1;
//     long time2 = System.nanoTime();
//     long timeTaken = time2 - time1;  
//     System.out.println("Time taken " + timeTaken + " ns");
// }

// public static void sort01(int[]arr){
//     long time1 = System.nanoTime();
//     int p=-1;
//     for(int i=0; i<arr.length; i++){
//         if(arr[i]==0) swap(arr,++p,i);
//     }
//     long time2 = System.nanoTime();
//     long timeTaken = time2 - time1;  
//     System.out.println("Time taken " + timeTaken + " ns");
// }

// public static void sort01(int[]arr){
//     int i=0;//sorted before i
//     int j=0;//0s before j
//     while(i<arr.length){
//         if(arr[i]==0) swap(arr,i,j++);
//         i++;
//     }
// }


  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    // System.out.println("Swapping index " + i + " and index " + j);
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
    sort01(arr);
    print(arr);
  }

}