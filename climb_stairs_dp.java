import java.io.*;
import java.util.*;

public class climb_stairs_dp {

    static int climbStairsDpTabulationBottomUp(int n){
        int[]arr=new int[n+1];
        for(int i=0;i<=n;i++){
            if(i<3)arr[i]=i;
            else if(i==3)arr[i]=i+1;
            else{
                arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
            }
        }
        return arr[n];
    }
    static void climbStairsDpMemoizationTopDown(int n,int[]ansBank){
        if(n==0){
            ansBank[n]=1;
            return;
        }
        // if(ansBank[n-1]==0){
            climbStairsDpMemoizationTopDown(n-1,ansBank);
        // }
        // if(ansBank[n-2]==0){
        //     climbStairsDpMemoizationTopDown(n-2,ansBank);
        // }
        // if(ansBank[n-3]==0){
        //     climbStairsDpMemoizationTopDown(n-3,ansBank);
        // }
        if(n<3){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=ansBank[i];
            }
            ansBank[n]=sum;
        }
        else{
            ansBank[n]=ansBank[n-1]+ansBank[n-2]+ansBank[n-3];
        }
        
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=3;

        long t1=System.nanoTime();
        System.out.println(climbStairsDpTabulationBottomUp(n));
        long t2=System.nanoTime();
        System.out.println(t2-t1);

        long t3=System.nanoTime();
        int[]ansBank=new int[n+1];
        climbStairsDpMemoizationTopDown(n,ansBank);
        System.out.println(ansBank[n]);
        long t4=System.nanoTime();
        System.out.println(t4-t3);


    }

}