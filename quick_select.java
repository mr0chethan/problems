import java.io.*;
import java.util.*;

public class quick_select {

    public static int partitionPivotIndex(int[]arr,int strtInd,int endInd,int piv){
        swap(arr,piv,endInd);
        int pntr=strtInd-1;//p
        for(int itr=strtInd;itr<=endInd;itr++)//p
        if(arr[itr]<=arr[endInd])
        swap(arr,++pntr,itr);
        return pntr;
    }
    public static int segregate(int[]arr,int pivot,int si,int ei){
        swap(arr,pivot,ei);
        int p=si-1, itr=si;
        while(itr<=ei){
            if(arr[itr]<=arr[ei])
                swap(arr,itr,++p);
            itr++;
        }
        return p;
    }
    public static void quickSelect2(int[]arr,int ran){
        int idx=arr.length-ran;
        quickSelect2(arr,0,arr.length-1,idx);
        System.out.println(arr[idx]);
    }
    public static void quickSelect2(int[]arr,int si,int ei,int idx){
        // overloading
        if(si>ei)
            return;
        int pivot=ei;
        int pIdx=segregate(arr,pivot,si,ei);
        if(idx==pIdx)
            return;
        else if(idx>pIdx)
            quickSelect2(arr,pIdx+1,ei,idx);
        else
            quickSelect2(arr,si,pIdx-1,idx);
    }
    public static int quickSelect(int[]arr,int si,int ei,int ran){
        // int ind=ran-1;
        int ind=arr.length-ran;
        int pIdx1=ei;
        int p1=partitionPivotIndex(arr,si,ei,pIdx1);
        if(p1==ind)
        return arr[p1];
        else if(ind<p1)
        return quickSelect(arr,si,p1-1,ran);
        else if(ind>p1)
        return quickSelect(arr,p1+1,ei,ran);
        return 0;
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
    int ran=scn.nextInt();
    System.out.println(quickSelect(arr,0,arr.length - 1,ran));
    quickSelect2(arr,ran);
    
    // print(arr);
  }
}