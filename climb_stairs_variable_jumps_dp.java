import java.util.*;
import java.io.*;

public class climb_stairs_variable_jumps_dp{
    public static Scanner scn=new Scanner(System.in);
    public static void input(int[]arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=scn.nextInt();
        }
    }
    public static void display(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    //forward tabulation or bottomup
    // public static int numWaysClimbUpStairsVariableJumps(int[]maxForwardStepsFromIndexStepArr){
    //     int[]numWaysToReachIndexStepArr=new int[maxForwardStepsFromIndexStepArr.length+1];
    //     numWaysToReachIndexStepArr[0]=1;
    //     for(int step=0;step<maxForwardStepsFromIndexStepArr.length;step++){
    //         int maxStepsForward=maxForwardStepsFromIndexStepArr[step];
    //         for(int stepsForward=1;stepsForward<=maxStepsForward;stepsForward++){
    //             if(step+stepsForward<numWaysToReachIndexStepArr.length)
    //             numWaysToReachIndexStepArr[step+stepsForward]+=numWaysToReachIndexStepArr[step];
    //         }
    //     }
    //     display(numWaysToReachIndexStepArr);
    //     return numWaysToReachIndexStepArr[maxForwardStepsFromIndexStepArr.length];
    // }

    public static int minNumOfMovesClimbUpStairsVariableJumps( int[] maxForwardStepsFromIndexStepArr){
        int[]minNumOfMovesToReachIndexStepArr = new int[ maxForwardStepsFromIndexStepArr.length + 1];
        minNumOfMovesToReachIndexStepArr[0] = 0;
        for(int step = 0; step < maxForwardStepsFromIndexStepArr.length; step++){
            int maxStepsForward = maxForwardStepsFromIndexStepArr[step];
            for( int stepsForward = 1; stepsForward <= maxStepsForward && step + stepsForward < minNumOfMovesToReachIndexStepArr.length; stepsForward++){
                if( minNumOfMovesToReachIndexStepArr[ step + stepsForward] == 0){
                    minNumOfMovesToReachIndexStepArr [step + stepsForward] = minNumOfMovesToReachIndexStepArr[ step ] + 1;
                }
                else{
                    minNumOfMovesToReachIndexStepArr[ step + stepsForward] = Math.min( minNumOfMovesToReachIndexStepArr[ step + stepsForward], minNumOfMovesToReachIndexStepArr[ step ] + 1);
                }
            }
        }
        // display(minNumOfMovesToReachIndexStepArr);
        return minNumOfMovesToReachIndexStepArr[maxForwardStepsFromIndexStepArr.length];
    }



    //backward tabulation or bottomup
    // public static int numWaysClimbUpStairsVariableJumps(int[]maxForwardStepsFromIndexStepArr){
    //     int[]numWaysToReachLastStepFromIndexStepArr=new int[maxForwardStepsFromIndexStepArr.length+1];
    //     numWaysToReachLastStepFromIndexStepArr[maxForwardStepsFromIndexStepArr.length]=1;
    //     for(int step=maxForwardStepsFromIndexStepArr.length-1;step>=0;step--){
    //         int maxStepsForward=maxForwardStepsFromIndexStepArr[step];
    //         for(int stepsForward=1;stepsForward<=maxStepsForward;stepsForward++){
    //             if(step+stepsForward<numWaysToReachLastStepFromIndexStepArr.length){
    //                 numWaysToReachLastStepFromIndexStepArr[step]+=numWaysToReachLastStepFromIndexStepArr[step+stepsForward];
    //             }
    //         }
    //     }
    //     display(numWaysToReachLastStepFromIndexStepArr);
    //     return numWaysToReachLastStepFromIndexStepArr[0];
    // }

    //forward tail recursion memoization or topdown
    // public static void numWaysClimbUpStairsVariableJumps(int[]maxForwardStepsFromIndexStepArr, int[]numWaysToReachIndexStepArr, int i){
    //     if(i==0){
    //         numWaysToReachIndexStepArr[i] = 1;
    //     }
    //     for(int stepsForward = 1; stepsForward <= maxForwardStepsFromIndexStepArr[i] && i+stepsForward < numWaysToReachIndexStepArr.length; stepsForward++){
    //         numWaysToReachIndexStepArr[ i + stepsForward ] += numWaysToReachIndexStepArr[i];
    //     }
    //     if(i < maxForwardStepsFromIndexStepArr.length-1){
    //         numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr, numWaysToReachIndexStepArr, i+1);
    //     }
    // }

    //forward head recursion memoization or topdown
    // public static void numWaysClimbUpStairsVariableJumps(int[]maxForwardStepsFromIndexStepArr, int[]numWaysToReachIndexStepArr, int i){
    //     if(i>0){
    //         numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr, numWaysToReachIndexStepArr, i-1);
    //     }
    //     if(i==0){
    //         numWaysToReachIndexStepArr[i] = 1;
    //     }
    //     for(int stepsForward = 1; stepsForward <= maxForwardStepsFromIndexStepArr[i] && i+stepsForward < numWaysToReachIndexStepArr.length; stepsForward++){
    //         numWaysToReachIndexStepArr[ i + stepsForward ] += numWaysToReachIndexStepArr[i];
    //     }
        
    // }

    // backward head recursion memoization or topdown
    // public static void numWaysClimbUpStairsVariableJumps(int[]maxForwardStepsFromIndexStepArr, int[]numWaysToReachLastStepFromIndexStepArr, int i){
    //     if( i == maxForwardStepsFromIndexStepArr.length){
    //         numWaysToReachLastStepFromIndexStepArr[i]=1;
    //     }
    //     for(int stepsForward = 1; i + stepsForward < numWaysToReachLastStepFromIndexStepArr.length && stepsForward <= maxForwardStepsFromIndexStepArr[i]; stepsForward++){
    //         numWaysToReachLastStepFromIndexStepArr[i] += numWaysToReachLastStepFromIndexStepArr[ i + stepsForward ];
    //     }
    //     if(i>0){
    //         numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr, numWaysToReachLastStepFromIndexStepArr, i-1);
    //     }
    // }

    // backward tail recursion memoization or topdown
    // public static void numWaysClimbUpStairsVariableJumps(int[]maxForwardStepsFromIndexStepArr, int[]numWaysToReachLastStepFromIndexStepArr, int i){
    //     if(i<numWaysToReachLastStepFromIndexStepArr.length){
    //         numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr, numWaysToReachLastStepFromIndexStepArr, i+1);
    //     }
    //     if( i == maxForwardStepsFromIndexStepArr.length){
    //         numWaysToReachLastStepFromIndexStepArr[i]=1;
    //     }
    //     for(int stepsForward = 1; i + stepsForward < numWaysToReachLastStepFromIndexStepArr.length && stepsForward <= maxForwardStepsFromIndexStepArr[i]; stepsForward++){
    //         numWaysToReachLastStepFromIndexStepArr[i] += numWaysToReachLastStepFromIndexStepArr[ i + stepsForward ];
    //     }
    // }


    public static void main(String[]args){
        int numberOfSteps=scn.nextInt();
        int[]maxForwardStepsFromIndexStepArr=new int[numberOfSteps];
        input(maxForwardStepsFromIndexStepArr);

        // int numWaysClimbUpStairsVariableJumps=numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr);
        // System.out.println(numWaysClimbUpStairsVariableJumps);

        // int[]numWaysToReachIndexStepArr=new int[maxForwardStepsFromIndexStepArr.length+1];
        // numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr, numWaysToReachIndexStepArr, 0);
        // numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr, numWaysToReachIndexStepArr, maxForwardStepsFromIndexStepArr.length-1);
        // System.out.println(numWaysToReachIndexStepArr[maxForwardStepsFromIndexStepArr.length]);

        // int[] numWaysToReachLastStepFromIndexStepArr = new int[maxForwardStepsFromIndexStepArr.length+1];
        // numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr, numWaysToReachLastStepFromIndexStepArr, maxForwardStepsFromIndexStepArr.length);
        // numWaysClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr, numWaysToReachLastStepFromIndexStepArr, 0);
        // System.out.println(numWaysToReachLastStepFromIndexStepArr[0]);

        System.out.println(minNumOfMovesClimbUpStairsVariableJumps(maxForwardStepsFromIndexStepArr));

        
    }
}