import java.io.*;
import java.util.*;

public class median_priority_queue {

  public static class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
      left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }

    public void add(int val) {
      // write your code here
      if( left.size() == right.size() ){
        if( right.size() == 0 || val <= right.peek() ){
            left.add( val );
        }
        else{
            left.add( right.remove() );
            right.add( val );
        }
      }
      else{
          if( val >= left.peek() ){
            right.add( val );
          }
          else{
            // if( left.size() > 0){
                right.add( left.remove() );
            // }
            left.add( val );
          }
      }
    }

    public int remove() {
      // write your code here
      if( left.size() == 0){
        System.out.println("Underflow");
        return -1;
      }
      if( left.size() > right.size() ){
          return left.remove();
      }
      else{
          int ret = left.remove();
          if( right.size() > 0){
            left.add( right.remove() );
          }
          return ret;
      }
    }

    public int peek() {
      // write your code here
      if( left.size() == 0){
          System.out.println("Underflow");
          return -1;
      }
      return left.peek();
    }

    public int size() {
      // write your code here
      return left.size() + right.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MedianPriorityQueue qu = new MedianPriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}