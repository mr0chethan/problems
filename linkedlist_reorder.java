import java.io.*;
import java.util.*;
public class linkedlist_reorder {

    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode reverseHeadNext=head,reverseHead=head.next,nextHead=head.next.next;
        reverseHeadNext.next=null;
        reverseHead.next=reverseHeadNext;
        while(nextHead!=null){
            reverseHeadNext=reverseHead;
            reverseHead=nextHead;
            nextHead=nextHead.next;
            reverseHead.next=reverseHeadNext;
        }
        return reverseHead;
    }
    
    public static void reorderList(ListNode head) {
        // ListNode newListNodeHead=copy(head);
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode left=head;
        ListNode right=slow.next;
        slow.next=null;
        right=reverseList(right);
        ListNode leftNext=left;
        ListNode rightNext=right;
        while(left!=null||right!=null){
            if(left!=null){
                leftNext=left.next;
                left.next=right;
                left=leftNext;
            }
            if(right!=null){
                rightNext=right.next;
                right.next=left;
                right=rightNext;
            }
        } 
    }
    
    
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args)throws Exception{
        System.out.println("enter size: ");
        int size=scn.nextInt();
        ListNode head=ListNode.input(size);
        // ListNode.display(head);
        reorderList(head);
        ListNode.display(head);
        // ListNode.display(oddEvenValueList(head));

    }
}
