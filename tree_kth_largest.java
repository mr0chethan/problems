import java.io.*;
import java.util.*;

public class tree_kth_largest {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  public static int max(Node node) {
    // write your code here
    int ans=node.data;
    for(Node child:node.children){
        int recAns=max(child);
        ans=ans>recAns?ans:recAns;
    }
    return ans;
  }
  
  static int ceil;
  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    // Write your code here
    if(node.data>data){
        ceil=Math.min(ceil,node.data);
    }
    else if(node.data<data){
        floor=Math.max(floor,node.data);
    }
    
    for(Node child:node.children){
        ceilAndFloor(child,data);
    }
    
    
  }

//   public static void kthLargest(Node node, int k){
//     // write your code here
//     if(k==1)return;
//     int temp=floor;
//     ceil=Integer.MAX_VALUE;
//     floor=Integer.MIN_VALUE;
//     ceilAndFloor(node,temp);
//     kthLargest(node,k-1);
    
//   }

// public static int kthLargest(Node node, int k){
//     // write your code here
//     if(k==1)return max(node);
    
    
//     int temp=kthLargest(node,k-1);
//     ceil=Integer.MAX_VALUE;
//     floor=Integer.MIN_VALUE;
//     ceilAndFloor(node,temp);
//     return floor;
//   }

// public static int kthLargest(Node node, int k){
//     // write your code here
//     if(k==1)return max(node);
    
    
//     int temp=kthLargest(node,k-1);
//     ceil=Integer.MAX_VALUE;
//     floor=Integer.MIN_VALUE;
//     ceilAndFloor(node,temp);
//     return floor;
//   }

static int largestBelowOpenBound(Node node,int openBound){
    int ans;
    if(node.data<openBound){
        ans=node.data;
    }
    else{
        ans=Integer.MIN_VALUE;
    }
    for(Node child:node.children){
        int recAns=largestBelowOpenBound(node,openBound);
        if(recAns<openBound){
            ans=Math.max(recAns,ans);
        }
    }
    return ans;
}
  
  public static int kthLargest(Node node,int k,int openBound){
      if(k==1)return openBound;
      int prevRecAns=kthLargest(node,k-1,openBound);
      int ans=kthLargest(node,k)
      return recAns;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ceil=Integer.MAX_VALUE;
    floor=Integer.MIN_VALUE;
    // int max=max(root);
    // floor=max;
    int kthLargest = kthLargest(root, k,Integer.MAX_VALUE);
    // kthLargest(root, k);
    System.out.println(kthLargest);
  }

}