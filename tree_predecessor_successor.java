import java.io.*;
import java.util.*;

public class Main {
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


//  static Node predecessor;
//   static Node successor;
  
//   public static void predecessorAndSuccessor(Node node, int data) {
//     // write your code here
//     for(Node child:node.children){
//         if(child.data==data)predecessor=node;
//     }
//     if(node.data==data){
//         for(Node child:node.children){
//             successor=child;
//         }
//     }
//     for(Node child:node.children){
//         predecessorAndSuccessor(child,data);
//     }
//   }


 
//   static Node currentLeft;
//   static Node currentRight;

//   public static void predecessor(Node node, int data) {
//     // write your code here
//     if(currentLeft!=null && currentLeft.data==data)return;
//     predecessor=currentLeft;
//     currentLeft=node;
//     for(int i=0;i<node.children.size();i++){
//         predecessor(node.children.get(i),data);
//     }
//   }
//   public static void successor(Node node, int data) {
//     // write your code here
//     if(currentRight!=null && currentRight.data==data)return;
//     currentRight=successor;
//     successor=node;
    
//     for(int i=0;i<node.children.size();i++){
//         successor(node.children.get(i),data);
//     }
//   }
  
  static class PreSucStat{
      Node pre;
      Node suc;
      int stat;
      PreSucStat(Node pre,Node suc,int stat){
          this.pre=pre;
          this.suc=suc;
          this.stat=stat;
      }
  }
  
  static void preSuc(Node node,int data,PreSucStat preSucStat){
      if(node.data!=data && preSucStat.stat==0){
          preSucStat.pre=node;
      }
      else if(node.data==data){
          preSucStat.stat=1;
      }
      else if(node.data!=data && preSucStat.stat==1){
          preSucStat.stat=2;
          preSucStat.suc=node;
      }
      
      for(Node child:node.children){
          preSuc(child,data,preSucStat);
      }
  }
  
  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    
    // predecessor = null;
    // successor = null;
    
    // currentLeft=null;
    // currentRight=null;
    // predecessor(root, data);
    // successor(root,data);
    // if(successor.data==data)successor=null;
    
    PreSucStat preSucStat=new PreSucStat(null,null,0);
    preSuc(root,data,preSucStat);
    Node predecessor=preSucStat.pre;
    Node successor=preSucStat.suc;
    
    
    if(predecessor == null){
      System.out.println("Predecessor = Not found");
    } else {
      System.out.println("Predecessor = " + predecessor.data);
    }

    if(successor == null){
      System.out.println("Successor = Not found");
    } else {
      System.out.println("Successor = " + successor.data);
    }
  }

}