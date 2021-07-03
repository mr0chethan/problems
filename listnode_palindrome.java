import java.io.*;
import java.util.*;
class listnode_palindrome {
    static boolean isPalindrome(ListNode head) {
        ListNode given=head;
        ListNode reversed=reverseList(head);
        boolean ans=true;
        while(given!=null&&reversed!=null){
            if(given.val!=reversed.val){
                ans=false;
                break;
            }
            given=given.next;
            reversed=reversed.next;
        }
        return ans;
    }
    static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode current=head;
        ListNode createdHead=new ListNode(current.val);
        ListNode createdCurrent=createdHead;
        while(current.next!=null){
            current=current.next;
            ListNode createdNew=new ListNode(current.val);
            createdCurrent.next=createdNew;
            createdCurrent=createdNew;
        }
        ListNode reverseHeadNext=createdHead,reverseHead=createdHead.next,nextHead=createdHead.next.next;
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
    static Scanner scn=new Scanner(System.in);
    public static void main(String[] args){
        ListNode node=new ListNode();
        node.input(scn.nextInt());
        ListNode reversed=reverseList(node);
        System.out.println(isPalindrome(node));
        
    }
    
}