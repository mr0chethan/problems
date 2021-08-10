import java.util.*;
import java.io.*;

public class array_pairs_divisible{
    public static Scanner scn = new Scanner(System.in);

    public static int countWaysOfPairing ( int[] arr,  int paired, int k, String pairsSoFar){
    // public static boolean countWaysOfPairing ( int[] arr,  int paired, int k, String pairsSoFar){
        // System.out.println( pairsSoFar );
        int firstUnpaired = -1;
        for( int i = 0; i < arr.length; i++){
            if( (paired & 1 << i+1) == 0 ){
                firstUnpaired = i;
                break;
            }
        }
        if( firstUnpaired == -1){
            // System.out.println( pairsSoFar );
            return 1;
            // return true;
        }
        paired ^= 1<<firstUnpaired+1;
        int ret = 0;
        // boolean ret = false;
        for( int i = 0; i < arr.length; i++){
            if( (paired & 1 << i+1) == 0 && (arr[ firstUnpaired ] + arr[ i ]) % k == 0 ){//
                paired ^= 1<<i+1;
                ret += countWaysOfPairing( arr, paired, k, pairsSoFar + "(" + firstUnpaired + ", " + i + ") ");
                // ret = ret || countWaysOfPairing( arr, paired, k, pairsSoFar + "(" + arr[firstUnpaired] + ", " + arr[ i ] + ") ");
                paired ^= 1<<i+1;
            }
        }
        paired ^= 1<<firstUnpaired+1;
        
        return ret;
    }

    public static boolean canArrange(int[] arr, int k) {
        int[]remFreq = new int[k];
        for( int i = 0; i < arr.length; i++){
            int rem = arr[ i ] % k ;
            int x = rem < 0 ? remFreq[-rem]++ : remFreq[rem]++;
            if(rem<0)
            System.out.println("i: "+i+"rem: "+rem+"remFreq[rem]: "+remFreq[-rem]);
            else
            System.out.println("i: "+i+"rem: "+rem+"remFreq[rem]: "+remFreq[rem]);
            // int rem = arr[ i ] % k ;
            // if( rem < 0){
            //     remFreq[-rem]++;
            // }
            // else{
            //     remFreq[rem]++;
            // }
        }
        // for( int i = 0; i < remFreq.length; i++){
        //     System.out.println( remFreq[ i ]);
        // }
        for( int i = 1; i <= remFreq.length/2; i++){
            if( remFreq[ i ] != remFreq[ k - i ] ){
                return false;
            }
        }
        return true;
        
    }


    

    public static void main(String[] args){
        int[] arr = {-1,1,-2,2,-3,3,-4,4};
        int k = 3;
        // int[] arr = {-1,3,8,2,20,29,18,8,-8,25,4,-7,9,3,27,10,-7,-2,-4,-9,7,33,-5,-6,25,7,19,1,8,34,-5,9,5,-9,-8,9,9,19};
        // int k = 28;
        // int count = countWaysOfPairing( arr, 0, k, "");
        // boolean count = countWaysOfPairing( arr, 0, k, "");
        boolean count = canArrange( arr, k);
        System.out.println( count );

    }
}