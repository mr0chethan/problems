import java.util.*;

public class equal_sum_subsets{
    public static Scanner scn = new Scanner(System.in);

    // public static boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for( int num : nums){
    //         sum += num;
    //     }
    //     if( (sum & 1) == 1){
    //         return false;
    //     }
    //     return countEqualSubsetSumPartitions(nums, 1, nums[0], 0, sum/2);
    //     // int count = countEqualSubsetSumPartitions(nums, 1, sum);
    //     // return count > 0 ? true : false;
    // }

    public static int countEqualSubsetSumPartitions( int[] nums, int setChoosingIndex, int sum1, int sum2, int targetSum){
        if( setChoosingIndex == nums.length ){
            if( sum1 == sum2){
                return 1;
            }
            return 0;
        }
        int count = 0;
        if( sum1 + nums[ setChoosingIndex] <= targetSum)
        count += countEqualSubsetSumPartitions( nums, setChoosingIndex + 1, sum1 + nums[ setChoosingIndex], sum2, targetSum);
        if( sum2 + nums[ setChoosingIndex] <= targetSum)
        count += countEqualSubsetSumPartitions( nums, setChoosingIndex + 1, sum1, sum2 + nums[ setChoosingIndex], targetSum);
        return count;
    }

    public static int countEqualSubsetSumPartitions( int[] nums, int setChoosingIndex, int sum1, int sum2, int targetSum, ArrayList<ArrayList<Integer>> sets){
        if( setChoosingIndex == nums.length ){
            if( sum1 == sum2){
                System.out.println(sets);
                return 1;
            }
            return 0;
        }
        int count = 0;
        if( sum1 + nums[ setChoosingIndex] <= targetSum){
            sets.get(0).add(nums[setChoosingIndex]);
            int addedIndex=sets.get(0).size()-1;
            count += countEqualSubsetSumPartitions( nums, setChoosingIndex + 1, sum1 + nums[ setChoosingIndex], sum2, targetSum, sets);
            sets.get(0).remove(addedIndex);
        }
        if( setChoosingIndex != 0 && sum2 + nums[ setChoosingIndex] <= targetSum){
            sets.get(1).add(nums[setChoosingIndex]);
            int addedIndex=sets.get(1).size()-1;
            count += countEqualSubsetSumPartitions( nums, setChoosingIndex + 1, sum1, sum2 + nums[ setChoosingIndex], targetSum, sets);
            sets.get(1).remove(addedIndex);
        }
        return count;
    }

    public static int countEqualSubsetSumPartitions( int[] nums){
        int totalSum = 0;
        for(int i = 0; i<nums.length; i++){
            totalSum += nums[ i ];
        }
        if( totalSum % 2 != 0 ){
            return 0;
        }
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
        for(int i = 0; i<2; i++){
            sets.add(new ArrayList<>());
        }
        int count = countEqualSubsetSumPartitions( nums, 0, 0, 0, totalSum/2,sets);
        return count;
    }

    public static int countEqualSubsetSumPartitions( int[] nums, int setChoosingIndex, int [] sums, int targetSum, ArrayList<ArrayList<Integer>> sets){
        if( setChoosingIndex == nums.length ){
            for( int i = 0; i<sums.length; i++){
                if( sums[ i ] != targetSum){
                    return 0;
                }
            }
            System.out.println(sets);
            return 1;
        }
        int count = 0;
        boolean chooseEmptySet = false;
        for( int i = 0; i<sums.length; i++){
            if( (sums[i] + nums[ setChoosingIndex ] <=targetSum) && (sets.get(i).size() > 0 || !chooseEmptySet) ){
                if( sets.get(i).size() == 0 ){
                    chooseEmptySet = true;
                }
                sums[i] += nums[ setChoosingIndex];
                sets.get(i).add(nums[setChoosingIndex]);
                int addedIndex=sets.get(i).size()-1;
                count += countEqualSubsetSumPartitions( nums, setChoosingIndex + 1, sums, targetSum, sets);
                sums[i] -= nums[ setChoosingIndex];
                sets.get(i).remove(addedIndex);
            }
        }
        return count;
    }

    public static int countEqualSubsetSumPartitions( int[] nums, int k){
        int totalSum = 0;
        for(int i = 0; i<nums.length; i++){
            totalSum += nums[ i ];
        }
        if( totalSum % k != 0 ){
            return 0;
        }
        ArrayList<ArrayList<Integer>> sets = new ArrayList<>();
        for(int i = 0; i<k; i++){
            sets.add(new ArrayList<>());
        }
        int[]sums = new int[k];
        int count = countEqualSubsetSumPartitions( nums, 0, sums, totalSum/k,sets);
        return count;
    }

    public static void main(String[] args){
        // int[] nums = {1,5,11,5};
        // int[] nums = {1,2,3,4,5,6};
        int[] nums = {4,3,2,3,5,2,1};
        // int[] nums = {1,2,3,5};
        // int[]nums = {10,20,30,40,80};
        
        // int count = countEqualSubsetSumPartitions( nums, 1, nums[0], 0, sum/2);
        
        // int count = countEqualSubsetSumPartitions( nums);
        int count = countEqualSubsetSumPartitions( nums, 4);

        System.out.println(count);
    }
}