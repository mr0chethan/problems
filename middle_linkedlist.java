import java.io.*;
import java.util.*;
public class middle_linkedlist {
    public static ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static Scanner scn=new Scanner(System.in);

    public static void main(String[] args)throws Exception{
        System.out.println("enter size: ");
        int size=scn.nextInt();
        ListNode head=ListNode.input(size);
        ListNode.display(head);
        System.out.println(middleNode(head).val);

    }
}