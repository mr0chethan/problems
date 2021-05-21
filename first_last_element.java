import java.io.*;
import java.util.*;

public class first_last_element{

    public static int binarySearch(int [] arr, int data, int si, int ei){
        int startIndex=si;
        int endIndex=ei;
        int ans=-1;

        while(0<=si && ei<=arr.length-1 && startIndex<=endIndex){
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
        return ans;
    }

    public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int [] a=new int[n];
    for(int i=0; i<n; i++){
        a[i]=scn.nextInt();
    }
    int d=scn.nextInt();

    int binSr=binarySearch(a, d, 0, a.length-1);
    int firstIndex=binSr;
    while(0<firstIndex && a[firstIndex-1]==d){
        firstIndex=binarySearch(a,d,0,firstIndex-1);
    }
    int lastIndex=binSr;
    while(lastIndex<n-1 && a[lastIndex+1]==d){
        lastIndex=binarySearch(a,d,lastIndex+1,a.length-1);
    }

    System.out.println(firstIndex);
    System.out.println(lastIndex);

 }

}