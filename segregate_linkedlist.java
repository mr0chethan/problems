

import java.util.*;

class segregate_linkedlist {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        if(head==null || head.next == null)return head;
        ListNode cur = head, oh = new ListNode(-1), ot = oh, eh = new ListNode(-1), et = eh;
        while(cur!=null){
            // System.out.println(cur.val);
            if(cur.val % 2 == 0 ){
                et.next = cur;
                et = cur;
                // System.out.println(eh.next.val);
                // System.out.println(et.val);
            }
            else{
                ot.next = cur;
                ot = cur;
                // System.out.println(oh.next.val);
                // System.out.println(ot.val);
            }
            cur = cur.next;
            
            
            
        }
        et.next = oh.next;
        ot.next = null;
        
        
        
        return eh.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}