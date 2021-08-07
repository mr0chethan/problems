import java.util.*;

class leetcode_combination_sum_4 {
    public static int combinationSum4(int[] nums, int target) {
        return combs( nums, target, "");
    }
    public static int combs( int[]arr, int tar, String answerSoFar){
        if( tar == 0 ){
            System.out.println( answerSoFar );
            return 1;
        }
        int count = 0;
        for( int i = 0; i < arr.length; i++){
            if( tar - arr[ i ] >= 0 ){
                count += combs( arr, tar-arr[ i ], answerSoFar + arr[i] + " " );
            }
        }
        return count;
    }
    public static void main( String[] args ){

        int[] nums = {1,2,3};
        int target = 6;

        int ans = combinationSum4( nums, target );

        System.out.println( ans );
    }
}