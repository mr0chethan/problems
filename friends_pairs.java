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
      System.out.println( counter++ + "." + pairsSoFar );
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

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    System.out.println(friendsPairs(new boolean[scn.nextInt()+1], ""));
  }
}
