import java.io.*;
import java.util.*;
public class add_listnodes{
    public static Scanner scn=new Scanner(System.in);
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode l1Current=l1;
        ListNode l2Current=l2;
        ListNode ansHead=null;
        ListNode ansTail=null;
        while(l1Current!=null&&l2Current!=null){
            int sum=l1Current.val+l2Current.val+carry;
            int sumDigit=sum%10;
            carry=sum/10;
            if(ansHead==null){
                ansHead=new ListNode(sumDigit,null);
                ansTail=ansHead;
            }
            else{
                ListNode sumDigitNode=new ListNode(sumDigit,null);
                ansTail.next=sumDigitNode;
                ansTail=sumDigitNode;
            }
            l1Current=l1Current.next;
            l2Current=l2Current.next; 
        }
        while(l1Current!=null){
            int sum=l1Current.val+carry;
            int sumDigit=sum%10;
            carry=sum/10;
            ListNode sumDigitNode=new ListNode(sumDigit,null);
            ansTail.next=sumDigitNode;
            ansTail=sumDigitNode;
            l1Current=l1Current.next;
        }
        while(l2Current!=null){
            int sum=l2Current.val+carry;
            int sumDigit=sum%10;
            carry=sum/10;
            ListNode sumDigitNode=new ListNode(sumDigit,null);
            ansTail.next=sumDigitNode;
            ansTail=sumDigitNode;
            l2Current=l2Current.next;
        }
        if(carry!=0){
            ListNode lastCarryNode=new ListNode(carry,null);
            ansTail.next=lastCarryNode;
            ansTail=lastCarryNode;
        }
        return ansHead;
        
    }
    public static void main(String[] args)throws Exception{
        ListNode l1=new ListNode();
        System.out.println("enter the first listnode size: ");
        l1.input(scn.nextInt());
        ListNode l2=new ListNode();
        System.out.println("enter the second listnode size: ");
        l2.input(scn.nextInt());
        System.out.println(addTwoNumbers(l1,l2));

    }

}

