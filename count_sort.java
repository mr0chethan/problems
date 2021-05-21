import java.io.*;
import java.util.*;
public class count_sort{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[]arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static void print(int[]arr){
        for(int ele:arr)
        System.out.print(ele+" ");   
    }
    public static void countSort(int[]arr,int negMin,int posMax){
        int[]freq=new int[negMin+posMax+1];//range=maxNum-minNum+1
        for(int ele:arr){
            freq[ele+negMin]+=1;
        }
        int ind=0;//idx
        for(int i=0;i<freq.length;i++){//minNum to maxNum
            for(int j=0; j<freq[i];j++){//freq[minNum]-->0
                arr[ind++]=i-negMin;
            }
        }
    }

    public static void main(String[] args){
        int len=scn.nextInt();
        int negMin=scn.nextInt();//maxNum -(int)1e9
        int posMax=scn.nextInt();//minNum (int)1e9
        int[]arr=new int[len];
        input(arr);
        countSort(arr,-negMin,posMax);
        print(arr);
    }
}