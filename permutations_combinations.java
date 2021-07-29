import java.util.*;
import java.io.*;

public class permutations_combinations{

    public static Scanner scn=new Scanner(System.in);

    public static int infiniteSupplyTargetSumPermutations(int[]arr,int target, String permutationsSoFar){
        // if(target<0){
        //     return 0;
        // }
        if(target==0){
            System.out.println(permutationsSoFar);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(target-arr[i]>=0){
                count+=infiniteSupplyTargetSumPermutations(arr,target-arr[i],permutationsSoFar+arr[i]+" ");
            }
        }
        return count;
    }

    public static int infiniteSupplyTargetSumCombinations(int[]arr,int target,String combinationsSoFar,int startIndex){
        if(target==0){
            System.out.println(combinationsSoFar);
            return 1;
        }
        int count=0;
        // for(int i=0;i<arr.length;i++){
        for(int i=startIndex;i<arr.length;i++){
            // if(i>=startIndex && target-arr[i]>=0){
            if(target-arr[i]>=0){
                count+=infiniteSupplyTargetSumCombinations(arr,target-arr[i],combinationsSoFar+arr[i]+" ",i);
            }
        }
        return count;
    }

    public static int singleSupplyTargetSumCombinations(int[]arr,int target,String combinationsSoFar,int startIndex){
        if(target==0){
            System.out.println(combinationsSoFar);
            return 1;
        }
        int count=0;
        for(int i=startIndex;i<arr.length ;i++){
            if(target-arr[i]>=0){
                count+=singleSupplyTargetSumCombinations(arr,target-arr[i],combinationsSoFar+arr[i]+" ",i+1);
            }
        }
        return count;
    }

    public static int singleSupplyTargetSumPermutations(int[]arr,int target,String permutationsSoFar,boolean[] used){
        if(target==0){
            System.out.println(permutationsSoFar);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(!used[i] && target-arr[i]>=0){
                used[i]=true;
                count+=singleSupplyTargetSumPermutations(arr,target-arr[i],permutationsSoFar+arr[i]+" ");
                used[i]=false;
            }
        }
        return count;
    }

    public static int singleSupplyTargetSumPermutations(int[]arr,int target,String permutationsSoFar){
        if( target == 0){
            System.out.println(permutationsSoFar);
            return 1;
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0 && target-arr[i]>=0){
                arr[i]*=-1;
                count+=singleSupplyTargetSumPermutations(arr,target+arr[i],permutationsSoFar+(-arr[i])+" ");
                arr[i]*=-1;
            }
        }
        return count;
    }

    public static int singleSupplyTargetSumCombinationsSubsequence ( int[] arr, int target, int index , String combinationsSoFar) {
        if( target == 0){
            System.out.println( combinationsSoFar );
            return 1;
        }
        else if( index >= arr.length){
            return 0;
        }
        int count = 0;
        if(target - arr [index] >= 0){
            count += singleSupplyTargetSumCombinationsSubsequence( arr, target - arr [index], index + 1, combinationsSoFar + arr[index] + " ");
        }
        // if( index + 1 < arr.length){
            count += singleSupplyTargetSumCombinationsSubsequence( arr, target, index + 1, combinationsSoFar);
        // }
        return count;
    }

    public static int infiniteSupplyTargetSumCombinationsSubsequence ( int[] arr, int target, int index , String combinationsSoFar) {
        if( target == 0){
            System.out.println( combinationsSoFar );
            return 1;
        }
        int count = 0;
        if(target - arr [index] >= 0){
            count += infiniteSupplyTargetSumCombinationsSubsequence( arr, target - arr [index], index, combinationsSoFar + arr[index] + " ");
        }
        // if( target - arr [index] > 0 && index + 1 < arr.length){
        if( index + 1 < arr.length){
            count += infiniteSupplyTargetSumCombinationsSubsequence( arr, target, index + 1, combinationsSoFar);
        }
        return count;
    }

    public static int infiniteSupplyTargetSumPermutationsSubsequence ( int[] arr, int target, int index , String permutationsSoFar) {
        if( target == 0){
            System.out.println( permutationsSoFar );
            return 1;
        }
        int count = 0;
        if(target - arr [index] >= 0){
            count += infiniteSupplyTargetSumPermutationsSubsequence( arr, target - arr [index], 0, permutationsSoFar + arr[index] + " ");
        }
        // if( target - arr [index] > 0 && index + 1 < arr.length){
        if( index + 1 < arr.length){
            count += infiniteSupplyTargetSumPermutationsSubsequence( arr, target, index + 1, permutationsSoFar);
        }
        return count;
    }

    public static int singleSupplyTargetSumPermutationsSubsequence(int[] arr, int target, int index , String permutationsSoFar, boolean[] used){
        if( target == 0){
            System.out.println( permutationsSoFar );
            return 1;
        }
        int count=0;
        if( target - arr[ index ] >= 0){
            if( !used[ index ]){
                used[ index ] =true;
                count += singleSupplyTargetSumPermutationsSubsequence( arr, target - arr[ index ], 0, permutationsSoFar + arr [index] + " ", used);
                used[ index ] =false;
            }
            // if( index + 1 < arr.length){
            //     count += singleSupplyTargetSumPermutationsSubsequence( arr, target, index + 1, permutationsSoFar, used);  
            // }
        }
        if( index + 1 < arr.length){
            count += singleSupplyTargetSumPermutationsSubsequence( arr, target, index + 1, permutationsSoFar, used);  
        }
        return count;
    }

    public static int spaceElementCombinations(int totalNoOfSpaces, int spaceIndexNextAvailable, int totalNoOfElements, int elementIndexToBePlaced, String spaceElementCombinationsSoFar){
        if( elementIndexToBePlaced == totalNoOfElements){
            System.out.println(spaceElementCombinationsSoFar + ".");
            return 1;
        }
        int noOfspaceElementCombinations=0;
        for( int spaceIndex = spaceIndexNextAvailable; spaceIndex < totalNoOfSpaces; spaceIndex++){
            noOfspaceElementCombinations += spaceElementCombinations( totalNoOfSpaces, spaceIndex + 1, totalNoOfElements, elementIndexToBePlaced + 1, spaceElementCombinationsSoFar + "s" + spaceIndex + "-e" + elementIndexToBePlaced +", ");
        }
        return noOfspaceElementCombinations;
    }

    public static int spaceElementPermutations( boolean[]spaceUsed, int totalNoOfElements, int elementIndexToBePlaced, String spaceElementPermutationsSoFar){
        if( elementIndexToBePlaced == totalNoOfElements){
            System.out.println( spaceElementPermutationsSoFar );
            return 1;
        }
        int noOfSpaceElementPermutations=0;
        for( int spaceIndex = 0; spaceIndex < spaceUsed.length; spaceIndex++){
            if( !spaceUsed[ spaceIndex ] ){
                spaceUsed[ spaceIndex ] = true;
                noOfSpaceElementPermutations += spaceElementPermutations( spaceUsed, totalNoOfElements, elementIndexToBePlaced + 1, spaceElementPermutationsSoFar + "s" + spaceIndex + "-e" + elementIndexToBePlaced +", ");
                spaceUsed[ spaceIndex ] = false;
            }
        }
        return noOfSpaceElementPermutations;
    }

    public static int spaceElementCombinationsSubsequence(int totalNoOfSpaces, int spaceIndexToBeUsed, int totalNoOfElements, int elementIndexToBePlaced, String spaceElementCombinationsSoFar){
        if( elementIndexToBePlaced == totalNoOfElements ){
            System.out.println( spaceElementCombinationsSoFar + ".");
            return 1;
        }
        if( spaceIndexToBeUsed == totalNoOfSpaces ){
            return 0;
        }
        int noOfspaceElementCombinations = 0;
        noOfspaceElementCombinations += spaceElementCombinationsSubsequence( totalNoOfSpaces, spaceIndexToBeUsed + 1, totalNoOfElements, elementIndexToBePlaced + 1, spaceElementCombinationsSoFar + "e" + elementIndexToBePlaced + "-s" +  spaceIndexToBeUsed + ", " );
        noOfspaceElementCombinations += spaceElementCombinationsSubsequence( totalNoOfSpaces, spaceIndexToBeUsed + 1, totalNoOfElements, elementIndexToBePlaced, spaceElementCombinationsSoFar);
        return noOfspaceElementCombinations;
    }

    public static int spaceElementPermutationsSubsequence( boolean[] spaceUsed, int spaceIndexToBeUsed, int totalNoOfElements, int elementIndexToBePlaced, String spaceElementPermutationsSoFar ){
        if( elementIndexToBePlaced == totalNoOfElements ){
            System.out.println( spaceElementPermutationsSoFar );
            return 1;
        }
        int noOfSpaceElementPermutations = 0;
        if( !spaceUsed[ spaceIndexToBeUsed ]){
            spaceUsed[ spaceIndexToBeUsed ] = true;
            noOfSpaceElementPermutations += spaceElementPermutationsSubsequence( spaceUsed, 0, totalNoOfElements, elementIndexToBePlaced + 1, spaceElementPermutationsSoFar + "e" + elementIndexToBePlaced + "-s" + spaceIndexToBeUsed  + ", " );
            spaceUsed[ spaceIndexToBeUsed ] = false;
        }
        if( spaceIndexToBeUsed + 1 < spaceUsed.length ){
            noOfSpaceElementPermutations += spaceElementPermutationsSubsequence( spaceUsed, spaceIndexToBeUsed + 1, totalNoOfElements, elementIndexToBePlaced, spaceElementPermutationsSoFar);
        }
        return noOfSpaceElementPermutations;
    }

    public static int queenCombinations2D()



    // public static int queenCombination2D_sub(int tnb, int bno, int tnq, int qpsf, String asf) {
    //     if (qpsf > tnq || bno > tnb) {
    //         if (qpsf > tnq) {
    //             System.out.println(asf);
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     int count = 0;
    //     count += queenCombination1D_sub(tnb, bno + 1, tnq, qpsf + 1, asf + "b" + bno + "q" + qpsf + " ");
    //     count += queenCombination1D_sub(tnb, bno + 1, tnq, qpsf, asf);

    //     return count;
    // }

    // public static int queenPermutation2D_sub(int tnb, int bno, int tnq, int qpsf, boolean[] vis, String asf) {
    //     if (qpsf > tnq || bno > tnb) {
    //         if (qpsf > tnq) {
    //             System.out.println(asf);
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     int count = 0;

    //     if (!vis[bno]) {
    //         vis[bno] = true;
    //         count += queenPermutation1D_sub(tnb, 1, tnq, qpsf + 1, vis, asf + "b" + bno + "q" + qpsf + " ");
    //         vis[bno] = false;
    //     }
    //     count += queenPermutation1D_sub(tnb, bno + 1, tnq, qpsf, vis, asf);
    //     return count;
    // }












    public static void main( String[] args ){

        // int[] arr = {2,3,5}; //8
        int[] arr = {2,3,5,7};

        // infiniteSupplyTargetSumPermutations( arr, 10, "");

        // infiniteSupplyTargetSumCombinations( arr, 10, "", 0);

        // singleSupplyTargetSumCombinations( arr, 10, "", 0);

        // singleSupplyTargetSumPermutations( arr, 10,"", new boolean[ arr.length]);
        // singleSupplyTargetSumPermutations( arr, 10,"");

        // singleSupplyTargetSumCombinationsSubsequence( arr, 10, 0, "");

        // infiniteSupplyTargetSumCombinationsSubsequence( arr, 8, 0, "");

        // infiniteSupplyTargetSumPermutationsSubsequence( arr, 8, 0, "");

        // singleSupplyTargetSumPermutationsSubsequence( arr, 10, 0, "", new boolean[ arr.length ]);

        // System.out.println( spaceElementCombinations( 5, 0, 3, 0, ""));
        // System.out.println( spaceElementPermutations( new boolean[5], 3, 0, ""));

        // System.out.println( spaceElementCombinationsSubsequence( 4, 0, 2, 0, ""));
        // System.out.println( spaceElementPermutationsSubsequence( new boolean[5], 0, 3, 0, ""));


        
    }
}