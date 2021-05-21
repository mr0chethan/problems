import java.io.*;
import java.util.*;

public class partition_pivot {

  // public static void partition(int[] arr, int pivot){
  //   // data head tail while
  //   int i=0, j=arr.length-1;
  //   while(i<j){
  //       if(arr[i]<=pivot) i++;
  //       else swap(arr,i,j--);
  //   }
  // }

  // public static void partition(int[] arr, int pivot){
  //   // data head tail for 
  // for(int i=0, j=arr.length-1;i<j;){
  //     if(arr[i]<=pivot) i++;
  //     else swap(arr,i,j--);
  // }
  // }

  // public static void partition(int[] arr, int pivot){
  //   // data head for
  //   for(int i=0,j=0;j<arr.length;j++)
  //     if(arr[j]<=pivot) swap(arr,i++,j);
  // }
  
  // public static void partition(int[]arr,int pivot){
  //   //rajneesh sir
  //   int p=-1,i=0;
  //   for(;i<arr.length;i++){
  //     if(arr[i]<=pivot)swap(arr,i,++p);
  //   }
  // }


  // public static void partition(int[] arr, int index){
  //   // index head tail while
  //   int data=arr[index];
  //   int i=0, j=arr.length-1;
  //   while(i<=j){
  //     if(i<=j && i<index && index<j && arr[i]<=data)i++;
  //     if(i<=j && i<index && index<j && data<arr[j])j--;
  //     if(i<=j && i<index && index<j && arr[j]<=data && data<arr[i]) swap(arr,i,j);
  //     if(i<=j && index<i && arr[i]<=data)swap(arr,i,-1+i++);
  //     if(i<=j && index<i && data<arr[j])j--;
  //     if(i<=j && index<i && arr[j]<=data && data<arr[i]) swap(arr,i,j);
  //     if(i<=j && j<index && data<arr[j])swap(arr,j,1+j--);
  //     if(i<=j && j<index && arr[i]<=data)i++;
  //     if(i<=j && j<index && arr[j]<=data && data<arr[i])swap(arr,i,j);
  //     if(i<=j && i==index)i++;
  //     if(i<=j && j==index)j--;
  //   }
  // }

  // public static void partition(int[] arr, int index){
  //   // index head tail while optimized
  //   int data=arr[index];
  //   int i=0, j=arr.length-1;
  //   while(i<=j){
  //     if(i<=j && i<arr.length && arr[i]<=data){
  //       if(index<i) swap(arr,i,i-1);
  //       i++;
  //     }
  //     if(i<=j && 0<=j && arr[j]>data){
  //       if(j<index) swap(arr,j,j+1);
  //       j--;
  //     }
  //     if(i<=j && 0<=j && j==index)j--;
  //     if(i<=j && 0<=j && i<arr.length && i!=index && j!=index && arr[i]>data && data<=arr[j])swap(arr,i,j);
  //   }
  // }

  // public static void partition(int[] arr, int index){
  //   // index head tail swap end while
  //   int i=0, j=arr.length-1;
  //   while(i<j){
  //     if(arr[i]<=arr[index]) i++;
  //     else if(j==index) j--;
  //     else swap(arr,i,j--);
  //   }
  //   swap(arr,i,index);
  // }

  // public static void partition(int[]arr,int index){
  //   // index head tail first and last while
  //   int data=arr[index];
  //   swap(arr,index,arr.length-1);
  //   int j=arr.length-2;
  //   int i=0;
  //   while(i<=j){
  //     if(i<=j && arr[i]<=data)i++;
  //     if(i<=j && arr[j]>data)j--;
  //     if(i<=j && arr[i]>data && arr[j]<=data)swap(arr,i,j);
  //   }
  //   // if(arr[i]>data)swap(arr,i,arr.length-1);
  //   // else //i+1
  //   swap(arr,i,arr.length-1);
  // }

  // public static void partition(int[]arr,int index){
  //   // index head for
  //   int data=arr[index];
  //   for(int i=0,j=0; j<arr.length; j++){
  //     if(j==index)swap(arr,i,j);
  //     else if(arr[j]<=data)swap(arr,i++,j);
  //     if(j>index && arr[j]<=data)swap(arr,i,j);
  //   }
  // }

  // public static void partition(int[]arr,int index){
  //   // index head swap end for
  //   int i=0;
  //   for(int j=0; j<arr.length; j++){
  //     if(j==index);
  //     else if(arr[j]<=arr[index])swap(arr,i++,j);
  //     if(i==index)i++;      
  //   }
  //   if(i<index)swap(arr,i,index);
  //   if(index<i)swap(arr,i-1,index);
  // }

  // public static void partition(int[]arr,int index){
  //   // index head first and last swap for
  //   int data=arr[index];
  //   swap(arr,index,arr.length-1);
  //   int i=0;
  //   for(int j=0;j<arr.length-1;j++){
  //     if(arr[j]<=data)swap(arr,i++,j);
  //   }
  //   swap(arr,i,arr.length-1);
  // }

  public static void partition(int[]arr,int index){
    //rajneesh sir
    swap(arr,index,arr.length-1);
    int p=-1, i=0;
    for(;i<arr.length;i++){
      if(arr[i]<=arr[arr.length-1])swap(arr,i,++p);
    }
  }
  
  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    // int pivot = scn.nextInt();
    // partition(arr,pivot);
    int index=scn.nextInt();
    partition(arr,index);
    print(arr);
  }
}