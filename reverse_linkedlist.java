import java.io.*;
import java.util.*;
public class reverse_linkedlist {
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
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args)throws Exception{
        System.out.println("enter size: ");
        int size=scn.nextInt();
        ListNode head=ListNode.input(size);
        // ListNode.display(head);
        ListNode.display(reverseList(head));

    }
}














