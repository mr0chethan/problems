import java.util.Scanner;
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public Scanner scn=new Scanner(System.in);
    
    public void input(int size){
        ListNode tail=null;
        for(int i=0;i<size;i++){
            System.out.println("enter value of node "+i+": ");
            if(i==0){
                this.val=scn.nextInt();
                this.next=null;
                tail=this;
            }
            else{
                ListNode newNode=new ListNode(scn.nextInt(),null);
                tail.next=newNode;
                tail=newNode;
            } 
        }
    }
    public  void display(){
        ListNode curNode=this;
        while(curNode!=null){            
            System.out.print(curNode.val+" ");
            curNode=curNode.next;
        }
        System.out.println();
    }
    public int size(){
        int size=0;
        ListNode cur=this;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        return size;
    }
    public boolean isEmpty(){
        return this==null;
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        ListNode cur=this;
        while(cur!=null){
            sb.append(cur.val);
            if(cur.next!=null){
                sb.append(", ");
            }
            cur=cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

}