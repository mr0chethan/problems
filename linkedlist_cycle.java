public class linkedlist_cycle{

    // static class ListNode {
    //         int val;
    //         ListNode next;
    //         ListNode(int x) {
    //             val = x;
    //             next = null;
    //         }
    //     }

    public static ListNode detectCycle(ListNode head) {
        if( head == null || head.next == null)return null;
        
        ListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }
        
        if( fast != slow){
            return null;
        }
        
        slow = head;
        while(fast!=slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    

    public static void main(String[] args){

    }
}