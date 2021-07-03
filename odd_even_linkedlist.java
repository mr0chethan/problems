import java.io.*;
import java.util.*;
public class odd_even_linkedlist {
    public static ListNode oddEvenIndexList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode oh=head,ot=head;
        ListNode eh=head.next,et=head.next;
        while(ot.next!=null&&et.next!=null){
            ot.next=et.next;
            ot=ot.next;
            if(ot.next!=null){
                et.next=ot.next;
                et=et.next;
            }
        }
        if(ot.next==null){
            et.next=null;
        }
        ot.next=eh;
        return head;
    }
    public static ListNode oddEvenValueList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode oh=new ListNode(-1,null);
        ListNode ot=oh;
        ListNode eh=new ListNode(-2,null);
        ListNode et=eh;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val%2==0){
                if(eh.val==-2){
                    eh=cur;
                    et=cur;
                }
                else{
                    et.next=cur;
                    et=cur;
                }
            }
            else{
                if(oh.val==-1){
                    oh=cur;
                    ot=cur;
                }
                else{
                    ot.next=cur;
                    ot=cur;
                }
            }
            cur=cur.next;
        }
        et.next=null;
        if(eh.val==-2){
            eh=null;
            et=null;
            head=oh;
        }
        else if(oh.val==-1){
            oh=null;
            ot=null;
            head=eh;
        }
        else{
            ot.next=eh;
            head=oh;
        }
        return head;

    }
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args)throws Exception{
        System.out.println("enter size: ");
        int size=scn.nextInt();
        ListNode head=ListNode.input(size);
        // ListNode.display(head);
        ListNode.display(oddEvenIndexList(head));
        ListNode.display(oddEvenValueList(head));

    }
}
























