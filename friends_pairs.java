import java.io.*;
import java.util.*;

public class friends_pairs {

  static int counter = 1;

  public static int friendsPairs(boolean[] paired, String pairsSoFar) {

    int count = 0;
    int friendToChoose = -1;
    int noOfUnPairedFriends = 0;
    for( int friend = 1; friend < paired.length; friend++){
      if( !paired[ friend ]){
        if( noOfUnPairedFriends == 0){
          friendToChoose = friend;
        }
        noOfUnPairedFriends++;
      }
    }

    if( noOfUnPairedFriends == 0 ){
      // System.out.println( counter++ + "." + pairsSoFar );
      return 1;
    }

    paired[ friendToChoose ] = true;
    count += friendsPairs( paired, pairsSoFar + "(" + friendToChoose + ") " );
    paired[ friendToChoose ] = false;

    for( int friend = 1; friend < paired.length; friend++){
      if( !paired[ friend ] && friend != friendToChoose ){
        paired[ friend ] = paired[ friendToChoose ] = true;
        count += friendsPairs( paired, pairsSoFar + "(" + friendToChoose + "," + friend + ") " );
        paired[ friend ] = paired[ friendToChoose ] = false;
      }
    }
    return count;
  }

  public static long countFriendsPairings(int num) 
    { 
       //code here
       long count = countFriendsPairingsMemo(num, new long[num+1]);
      //  long count = countFriendsPairingsTabu(num, new long[num+1]);
      //  long count = countFriendsPairingsOpti(num);
       return count % 1000000007;
    }
    public static long countFriendsPairingsMemo(int num, long[]dp){
        if(num==0){
            return dp[0]=1;
        }
        if(dp[num]!=0){
            return dp[num];
        }
        long countIfRemainsSingle = 0;
        long countIfPairs = 0;
        if(num-1>=0){
            countIfRemainsSingle = countFriendsPairingsMemo(num-1,dp);
        }
        if(num-2>=0){
            countIfPairs = (num-1) * (countFriendsPairingsMemo(num-2,dp)% 1000000007);
        }
        return dp[num] = ( countIfRemainsSingle % 1000000007) + (countIfPairs% 1000000007);
    }
    public static long countFriendsPairingsTabu(int NUM, long[]dp){
      for(int num = 0; num<=NUM; num++){
        if(num==0){
          dp[0]=1;
          continue;
        }
        if(dp[num]!=0){
            continue;
        }
        long countIfRemainsSingle = 0;
        long countIfPairs = 0;
        if(num-1>=0){
            countIfRemainsSingle = dp[num-1];
        }
        if(num-2>=0){
            countIfPairs = (num-1) * dp[num-2];
        }
        dp[num] = countIfRemainsSingle + countIfPairs;
      }
      return dp[NUM];
  }
  public static long countFriendsPairingsOpti(int NUM){
    long prev = 0, prevPrev = 0;
    for(int num = 0; num<=NUM; num++){
      if(num==0){
        prev=1;
        continue;
      }
      long countIfRemainsSingle = 0;
      long countIfPairs = 0;
      if(num-1>=0){
          countIfRemainsSingle = prev;
      }
      if(num-2>=0){
          countIfPairs = (num-1) * prevPrev;
      }
      prevPrev = prev;
      prev = countIfRemainsSingle + countIfPairs;
    }
    return prev;
}

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    long time1, time2;

    // time1 = System.nanoTime();
    // System.out.println(friendsPairs(new boolean[n+1], ""));
    // time2 = System.nanoTime();
    // System.out.println(time2-time1);

    time1 = System.nanoTime();
    System.out.println(countFriendsPairings(n));
    time2 = System.nanoTime();
    System.out.println(time2-time1);
  }
}
