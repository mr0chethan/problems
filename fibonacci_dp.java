import java.io.*;
import java.util.*;

class fibonacci_dp{
    static int fib(int n){
        if(n==0||n==1)return 1;
        return fib(n-1)+fib(n-2);
    }
    static int fibDpTabulationBottomUp(int n){
        ArrayList<Integer>al=new ArrayList<>();
        for(int i=0;i<=n;i++){
            if(i==0||i==1){
                al.add(1);
            }
            else{
                al.add(al.get(i-1)+al.get(i-2));
            }
        }
        return al.get(n);
    }
    static int fibDpMemoizationTopDown(int n,int[]ansBank){
        if(n==0||n==1){
            ansBank[n]=1;
            return 1;
        }
        if(ansBank[n]==0){
            int ans=fibDpMemoizationTopDown(n-1,ansBank)+fibDpMemoizationTopDown(n-2,ansBank);
            ansBank[n]=ans;
            return ans;
        }
        return ansBank[n];
    }


    

public static void main(String[] args) throws Exception {
    // write your code here
    int n=10;
    long t1=System.nanoTime();
    // System.out.println(fib(n));
    // System.out.println(fibDpTabulationBottomUp(n));
    int[]ansBank=new int[n+1];
    System.out.println(fibDpMemoizationTopDown(n,ansBank));


    long t2=System.nanoTime();
    System.out.println(t2-t1);
 }

}