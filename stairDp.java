import java.util.*;

public class stairDp{

    public static int countStairClimbWaysMemo(int stepIndex, int maxMaxClimbSize, int finalStepIndex, int[]dp, int[]maxClimbSizeArr){
        // int maxClimbSize = (int) (Math.random()*maxMaxClimbSize + 1);
        int maxClimbSize = maxClimbSizeArr[stepIndex];
        if(stepIndex == finalStepIndex){
            return dp[stepIndex] = 1;
        }
        if(dp[stepIndex] != 0){
            return dp[stepIndex];
        }
        int count = 0;
        for(int i=1; i<=maxClimbSize; i++){
            if(stepIndex + i <= finalStepIndex){
                count += countStairClimbWaysMemo( stepIndex + i, maxClimbSize, finalStepIndex, dp, maxClimbSizeArr);
            }
        }
        return dp[stepIndex] = count;
    }
    public static int countStairClimbWaysTabu(int STEPINDEX, int maxMaxClimbSize, int finalStepIndex, int[]dp, int[]maxClimbSizeArr){
        // int maxClimbSize = (int) (Math.random()*maxMaxClimbSize + 1);
        for(int stepIndex = STEPINDEX; stepIndex >= 0; stepIndex--){
            int maxClimbSize = maxClimbSizeArr[stepIndex];
            if(stepIndex == finalStepIndex){
                dp[stepIndex] = 1;
                continue;
            }
            if(dp[stepIndex] != 0){
                continue;
            }
            int count = 0;
            for(int i=1; i<=maxClimbSize; i++){
                if(stepIndex + i <= finalStepIndex){
                    count += dp[stepIndex + i];
                }
            }
            dp[stepIndex] = count;
        }
        return dp[0];
    }


        
    public static int countStairClimbWaysOpti(int STEPINDEX, int maxMaxClimbSize, int finalStepIndex, int[]maxClimbSizeArr){
        // int maxClimbSize = (int) (Math.random()*maxMaxClimbSize + 1);
        LinkedList<Integer> prevCounts = new LinkedList<>();
        for(int stepIndex = STEPINDEX; stepIndex >= 0; stepIndex--){
            int maxClimbSize = maxClimbSizeArr[stepIndex];
            if(stepIndex == finalStepIndex){
                prevCounts.addFirst(1);
                if(prevCounts.size()>maxClimbSize){
                    prevCounts.removeLast();
                }
                continue;
            }
            int count = 0;
            for(Integer i : prevCounts){
                count += i;
            }
            prevCounts.addFirst(count);
            if(prevCounts.size()>maxClimbSize){
                prevCounts.removeLast();
            }
        }
        return prevCounts.get(0);
    }

    public static void main(String[]args){
        int stepIndex = 0;
        int maxMaxclimbSize = 3;
        int finalStepIndex = 5;
        int[] maxClimbSizeArr = new int[finalStepIndex-stepIndex+1];
        Arrays.fill(maxClimbSizeArr,3);
        int count = countStairClimbWaysMemo(stepIndex, maxMaxclimbSize, finalStepIndex, new int[finalStepIndex-stepIndex+1], maxClimbSizeArr);
        // int count = countStairClimbWaysTabu(finalStepIndex, maxMaxclimbSize, finalStepIndex, new int[finalStepIndex-stepIndex+1], maxClimbSizeArr);
        // int count = countStairClimbWaysOpti(finalStepIndex, maxMaxclimbSize, finalStepIndex, maxClimbSizeArr);
        System.out.println(count);
    }
}