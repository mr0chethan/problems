import java.io.*;
import java.util.*;

public class climb_stairs {

    static int climbStairs(int n){
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
    public static void main(String[] args) throws Exception {
        // write your code here
        int n=5;
        System.out.println(climbStairs(n));

    }

}