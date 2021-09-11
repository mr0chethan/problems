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

    public static int fib_memo( int n, int[]dp){
        if(n<=1){
            return dp[n] = n;
        }
        if( dp[n] != 0){
            return dp[n];
        }
        int ans = fib_memo(n-1,dp) + fib_memo(n-2,dp);
        return dp[n]=ans;
    }

    public static int fib_tabu( int N, int[]dp){
        for( int n=0; n<=N; n++){
            if(n<=1){
                dp[n] = n;
                continue;
            }
            dp[n] = dp[n-1] + dp[n-2];
        }
        return dp[N];
    }

    public static int fib_opti( int N){
        int ans = 1, prev = 0;
        for( int n = 2; n<=N; n++){
            int sum = ans + prev;
            prev = ans;
            ans = sum;
        }
        return ans;
    }


    

public static void main(String[] args) throws Exception {
    // write your code here
    int n=7;
    // long t1=System.nanoTime();
    // System.out.println(fib(n));
    // System.out.println(fibDpTabulationBottomUp(n));
    // int[]ansBank=new int[n+1];
    // System.out.println(fibDpMemoizationTopDown(n,ansBank));
    // long t2=System.nanoTime();
    // System.out.println(t2-t1);

    // int count = fib_memo(n, new int[n+1]);
    // int count = fib_tabu(n, new int[n+1]);
    int count = fib_opti(n);
    System.out.println(count);
 }

}