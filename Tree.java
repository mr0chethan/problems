import java.util.ArrayList;
import java.util.Stack;

public class Tree{
    private static class Node{
        public int data;
        public ArrayList<Node> children=new ArrayList<>();
    }
    private static Node root;
    public Tree(int[]arr){
        Stack<Node>stk=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                Node rem=stk.pop();
            }
            else{
                Node node=new Node();
                node.data=arr[i];
                if(stk.size()==0){
                    this.root=node;
                }
                else{
                    Node temp=stk.peek();
                    temp.children.add(node);
                }
                stk.push(node);
            }
        }
    }
    public static void display(Node root){
        String str=root.data+"->";
        for(Node child:root.children){
            str+=child.data+", ";
        }
        str+=".";
        System.out.println(str);
        for(Node child:root.children){
            display(child);
        }
    }
    public static void main(String[] args)throws Exception{
        int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Tree tree=new Tree(arr);
        display(tree.root);
    }


}