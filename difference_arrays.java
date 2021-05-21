import java.util.*;
import java.io.*;

public class difference_arrays{

    public static Scanner scn=new Scanner(System.in);

    public static void input(int [] arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }

    public static void display(int [] arr){
        if(arr.length==0)
        System.out.println(0);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }
        

    public static int [] differenceArrays(int [] a1, int [] a2){
        int [] a=new int[(a2.length)];
        int borrow=0;
        int a1Index=a1.length-1;
        int a2Index=a2.length-1;
        int aIndex=a.length-1;
        while(aIndex>=0){
            int num1=(a1Index>=0 ? a1[a1Index] : 0);
            int num2=a2[a2Index];
            int difference=(num2-borrow-num1>=0 ? num2-borrow-num1 : num2-borrow+10-num1);
            a[aIndex]=difference;
            borrow=(num2-borrow-num1>=0 ? 0 : 1);
            a1Index-=1;
            a2Index-=1;
            aIndex-=1;
        }
        
        
        int newLength=a.length;
        for(int i=0; i<a.length; i++){
            if(a[i]>0)
            break;
            newLength--;
        }
        
        int [] newA= new int[newLength];
        for(int i=newA.length-1, j=a.length-1; i>=0; i--, j--){
            newA[i]=a[j];
        }

        // int startIndex=0;
        // int lastIndex=(a1.length>=a2.length ? a1.length -1: a2.length-1);
        // int newLastIndex=(a[lastIndex]>0 ? lastIndex: lastIndex-1);
        // while(newLastIndex>startIndex){
        //     int temp=a[startIndex];
        //     a[startIndex]=a[newLastIndex];
        //     a[newLastIndex]=temp;
        //     startIndex++;
        //     newLastIndex--;
        // }

        return newA;
    }

    public static void main(String args[]){
        int n1=scn.nextInt();
        int [] a1=new int[n1];
        input(a1);
        int n2=scn.nextInt();
        int [] a2=new int[n2];
        input(a2);
        int [] newA=differenceArrays(a1,a2);
        display(newA);
    }
}