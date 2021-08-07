import java.util.*;

public class leetcode_combination_sum_2{
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combs= new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        Arrays.sort(candidates);
        comb(candidates, new boolean[candidates.length], 0, target, comb, combs);
        return combs;
    }
    public static int comb(int[] arr, boolean[] used, int j, int tar, List<Integer> comb , List<List<Integer>> combs){
        System.out.println(j);
        if( tar == 0 ){
            List<Integer> newComb = new ArrayList<>();
            for( Integer i : comb ){
                newComb.add( i );
            }
            combs.add(newComb);
            return 1;
        }
        if( j == arr.length ){
            return 0;
        }
        int count = 0;
        for( int i = j; i < arr.length; i++){
            if( !used[ i ] && tar - arr [i] >=0){
                comb.add( arr[i] );
                count += comb( arr, used, i + 1, tar - arr[ i ], comb, combs );
                for( int k = i+1; k < used.length; k++){
                    if( arr[ k ] == arr[ i ] ){
                        used[ k ] =true;
                    }
                }
                comb.remove( comb.size() -1 );
            }
        }
        return count;
    }
    public static void main( String[] args ){
        // int[] candidates = {1,1,2,5,6,7,10};
        // int[] candidates = {1,2,2,2,5};
        // int[] candidates ={1,1,1,3,3,5};
        // int target =8;
        // int target =5;


        // System.out.println( combinationSum2( candidates, target));

        int n =10;
        n = !n;
        System.out.println(n);
    }
}