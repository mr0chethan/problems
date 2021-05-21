import java.io.*;
import java.util.*;

public class quick_sort {

    public static int partitionPivotIndex(int[]arr,int strtInd,int endInd,int piv){
        swap(arr,piv,endInd);
        int pntr=strtInd-1;//p
        for(int itr=strtInd;itr<=endInd;itr++)//p
        if(arr[itr]<=arr[endInd])
        swap(arr,++pntr,itr);
        return pntr;
    }
    public static void quickSort(int[]arr,int strtInd,int endInd){
        if(strtInd>endInd)return;//si ei
        int piv=endInd;//pIdx
        int pivPart=partitionPivotIndex(arr,strtInd,endInd,piv);//p
        quickSort(arr,strtInd,pivPart-1);
        quickSort(arr,pivPart+1,endInd);
    }

  public static void swap(int[]arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
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
    quickSort(arr,0,arr.length - 1);
    print(arr);
  }
}