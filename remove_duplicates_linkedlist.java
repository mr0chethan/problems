import java.io.*;
import java.util.*;
public class remove_duplicates_linkedlist {
    public static ListNode removeDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode cur=head;
        ListNode forw=head.next;
        while(forw.next!=null){
            if(cur.val==forw.val){
                cur.next=forw.next;
                forw.next=null;
                forw=cur.next;
            }
            else{
                cur=cur.next;
                forw=forw.next;
            }
        }
        if(cur.val==forw.val){
            cur.next=forw.next;
            forw.next=null;
            forw=cur.next;
        }
        return head;
    }
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args)throws Exception{
        System.out.println("enter size: ");
        int size=scn.nextInt();
        ListNode head=ListNode.input(size);
        // ListNode.display(head);
        ListNode.display(removeDuplicates(head));

    }
}