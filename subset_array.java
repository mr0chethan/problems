import java.io.*;
import java.util.*;
public class subset_array{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[]arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static int decimalToBinary(int n){
        int ans=0;
        int mul=1;
        while(n>0){
            int rem=n%2;
            n=n/2;
            ans+=rem*mul;
            mul*=10;
        }
        return ans;
    }
    public static int power(int base,int exponent){
        int ans=1;
        for(int i=0;i<exponent;i++){
            ans*=base;
        }
        return ans;
    }
    public static void printSubsetsOfArray(int[]arr){
        int max=power(2,arr.length);
        for(int i=0;i<max;i++){
            int bin=decimalToBinary(i);
            for(int place=0;place<arr.length;place++){
                if(bin%10==1)System.out.print(arr[place]+"\t");
                bin/=10;
            }
            System.out.println();
        }

    }
    public static void printSubsetsOfArray2(int[]arr){
        int max=power(2,arr.length);
        for(int i=0;i<max;i++){
            int temp=i;
            String prnt="";
            for(int place=arr.length-1;place>=0;place--){
                if(temp%2==1){
                    prnt=arr[place]+"\t"+prnt;
                }
                else{
                    prnt="-\t"+prnt;
                }
                temp/=2;
            }
            System.out.println(prnt);
        }

    }
    public static void main(String[] args){
        int len=scn.nextInt();
        int arr[]=new int[len];
        input(arr);
        printSubsetsOfArray2(arr);
        


    }
}