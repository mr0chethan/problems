import java.io.*;
import java.util.*;

public class target_sum_triplets {

    public static void printTargetSumTriplets(int[]arr,int sum){
        for(int i=0;i<arr.length-1;i++){
            int j=i+1,k=arr.length-1;
            while(j<k){
                int gotSum=arr[j]+arr[k];
                int reqSum=sum-arr[i];
                if(gotSum==reqSum){
                    System.out.println(arr[i]+", "+arr[j]+", "+arr[k]);
                    j++;k--;
                }
                else if(gotSum<reqSum)j++;
                else if(gotSum>reqSum)k--;
            }
        }
    }

    public static ArrayList<int[]>targetSumKLengthSets(int[]arr,int si,int ei,int target,int k){
      if(k==2)return targetSumPairs(arr,si,ei,target);
      ArrayList<int[]>ans=new ArrayList<>();
      while(si<ei-1){
        int first=arr[si],rem=target-first;
        ArrayList<int[]>prevAns=targetSumKLengthSets(arr,++si,ei,rem,k-1);
        for(int[]prevAnsArr:prevAns){
          int[]arrToAdd=new int[prevAnsArr.length+1];
          arrToAdd[0]=first;
          for(int i=0;i<prevAnsArr.length;i++){
            arrToAdd[i+1]=prevAnsArr[i];
          }
          ans.add(arrToAdd);
        }
      }
      return ans;
    }

    public static ArrayList<int[]>targetSumQuardruplets(int[]arr,int si,int ei,int target){
      ArrayList<int[]>ans=new ArrayList<>();
      while(si<ei-1){
        int first=arr[si],rem=target-first;
        ArrayList<int[]>prevAns=targetSumTriplets(arr,++si,ei,rem);
        for(int[]prevAnsArr:prevAns){
          int[]arrToAdd=new int[prevAnsArr.length+1];
          arrToAdd[0]=first;
          for(int i=0;i<prevAnsArr.length;i++){
            arrToAdd[i+1]=prevAnsArr[i];
          }
          ans.add(arrToAdd);
        }
      }
      return ans;
    }

    public static void targetSumTriplets(int[]arr,int si,int ei,int target,ArrayList<int[]>ans){
      while(si<ei){
        int first=arr[si];
        targetSumPairs(arr,++si,ei,target-first,first,ans);
      }
    }
    public static void targetSumPairs(int[]arr,int si,int ei,int target,int first,ArrayList<int[]>ans){
      while(si<ei){
        if(target==arr[si]+arr[ei]){
          ans.add(new int[]{first,arr[si++],arr[ei--]});
        }
        else if(target<arr[si]+arr[ei])
          ei--;
        else
          si++;
      }
    }

    public static ArrayList<int[]>targetSumTriplets2(int[]arr,int si,int ei, int target){
      ArrayList<int[]>ans=new ArrayList<>();
      while(si<ei){
        ArrayList<int[]>prevAns=targetSumPairs(arr,si+1,ei,target-arr[si]);
        for(int[]prevAnsArr:prevAns){
          ans.add(new int[]{arr[si],prevAnsArr[0],prevAnsArr[1]});
        }
        si++;
      }
      return ans;
    }

    public static ArrayList<int[]>targetSumTriplets(int[]arr,int si,int ei,int target){
      ArrayList<int[]>ans=new ArrayList<>();
      while(si<ei){
        int first=arr[si],rem=target-first;
        ArrayList<int[]>prevAns=targetSumPairs(arr,++si,ei,rem);
        for(int[]prevAnsArr:prevAns){
          int[]arrToAdd=new int[prevAnsArr.length+1];
          arrToAdd[0]=first;
          for(int i=0;i<prevAnsArr.length;i++){
            arrToAdd[i+1]=prevAnsArr[i];
          }
          ans.add(arrToAdd);
        }
      }
      return ans;
    }

    public static ArrayList<int[]>targetSumPairs(int[]arr,int si,int ei,int target){
        ArrayList<int[]>ans=new ArrayList<>();
        while(si<ei){
          int sum=arr[si]+arr[ei];
          if(sum==target)
            ans.add(new int[]{arr[si++],arr[ei--]});
          else if(sum<target)
            si++;
          else
            ei--;
        }
        return ans;
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
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target=scn.nextInt();
    int k=scn.nextInt();
    quickSort(arr,0,arr.length - 1);
    // printTargetSumTriplets(arr,target);
    // ArrayList<int[]>al=targetSumTriplets(arr,0,arr.length-1,target);
    ArrayList<int[]>al=targetSumQuardruplets(arr,0,arr.length-1,target);
    // ArrayList<int[]>al2=targetSumTriplets2(arr,0,arr.length-1,target);
    printArrayListOfIntArr(al);
    // printArrayListOfIntArr(al2);
    // ArrayList<int[]>ans=new ArrayList<>();
    // targetSumTriplets(arr,0,arr.length-1,target,ans);
    // printArrayListOfIntArr(ans);
    ArrayList<int[]>alk=targetSumKLengthSets(arr,0,arr.length-1,target,k);
    printArrayListOfIntArr(alk);
  }
}