import java.util.*;
import java.io.*;

public class add_arrays{

    public static Scanner scn=new Scanner(System.in);

    public static void input(int [] arr){
        for(int i=0; i<arr.length; i++){
            arr[i]=scn.nextInt();
        }
    }

    public static void display(int [] arr){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

    }
        

    public static int [] addArrays(int [] a1, int [] a2){
        int [] a=new int[(a1.length>=a2.length ? a1.length+1 : a2.length+1)];
        int carry=0;
        int a1Index=a1.length-1;
        int a2Index=a2.length-1;
        int aIndex=a.length-1;
        while(aIndex>=0){
            int num1=(a1Index>=0 ? a1[a1Index] : 0);
            int num2=(a2Index>=0 ? a2[a2Index] : 0);
            int sum=carry+num1+num2;
            a[aIndex]=sum%10;
            carry=(sum/10>=1 ? 1 : 0);
            a1Index-=1;
            a2Index-=1;
            aIndex-=1;
        }
        int newLength=(a[0]>0 ? a.length : a.length-1);
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
        int [] newA=addArrays(a1,a2);
        display(newA);
    }
}