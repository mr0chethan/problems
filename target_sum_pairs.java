import java.io.*;
import java.util.*;

public class target_sum {

  public static void printTargetSumPairs(int[] arr, int target){
    // time: lg1 + lg2 +...+lg(arr.length-1)
    quickSort(arr,0,arr.length-1);
    for(int i=0; i<arr.length; i++){
        int num1=arr[i];
        int num2=target-num1;
        int index=binarySearch(arr,i+1,arr.length-1,num2);
        if(index!=-1){
            System.out.println(num1+", "+num2);
        }
    }
  }

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

  public static ArrayList<int[]>targetSumPairs(int[]arr,int target){
    quickSort(arr,0,arr.length-1);
      // time: arr.length
      ArrayList<int[]>ans=new ArrayList<>();
      int i=0,j=arr.length-1;
      while(i<j){
        int sum=arr[i]+arr[j];
        if(sum==target)
          ans.add(new int[]{arr[i++],arr[j--]});
        else if(sum<target)
          i++;
        else
          j--;
      }
      return ans;
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static int binarySearch(int [] arr, int strtInd,int endInd, int data){
    int startIndex=strtInd, endIndex=endInd, ans=-1;
    while(startIndex<=endIndex){
        int midIndex=(startIndex+endIndex)/2;
        if(arr[midIndex]==data){
            ans=midIndex;
            break;
        }
        else if(data<arr[midIndex])
        endIndex=midIndex-1;
        else startIndex=midIndex+1;
    }
    return ans;
  }

  public static void printArrayListOfIntArr(ArrayList<int[]>al){
      for(int[] eleAl:al){
          for(int eleInt:eleAl)
          System.out.print(eleInt+", ");
          System.out.println();
      }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    // printTargetSumPairs(arr,target);
    printArrayListOfIntArr(targetSumPairs(arr,target));
  }

}