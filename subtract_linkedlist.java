import java.util.*;

class subtract_linkedlist {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
  
  public static ListNode reverse(ListNode head) {
        if( head == null || head.next == null)return head;
        ListNode cur = head;
        ListNode curNext = cur.next;
        cur.next = null;
        ListNode recRet = reverse(curNext);
        ListNode recRetTail = recRet;
        while( recRetTail!=null && recRetTail.next!=null){
            recRetTail = recRetTail.next;
        }
        recRetTail.next = cur;
        return recRet;
    }
    
    public static int length (ListNode head){
        ListNode cur = head;
        int length = 0;
        while(cur!=null){
            cur=cur.next;
            length++;
        }
        return length;
    }
  
  public static int compareTo( ListNode significant1,  ListNode significant2){
      if( length(significant1)>length(significant2) ){
        return 1;
      }
      if( length(significant1)<length(significant2) ){
        return -1;
      }
      ListNode cur1 = significant1, cur2 = significant2;
      while( cur1!=null && cur2!=null){
          if(cur1.val>cur2.val){
              return 1;
          }
          if(cur1.val<cur2.val){
              return -1;
          }
          cur1 = cur1.next;
          cur2 = cur2.next;
      }
      return 0;
  }

  public static ListNode subtractTwoNumbers(ListNode significant1, ListNode significant2) {
      int compareTo = compareTo(significant2, significant1);
      if( compareTo==0){
          return new ListNode(0);
      }
      if( compareTo>0 ){
          ListNode temp = significant2;
          significant2 = significant1;
          significant1 = temp;
      }
      int borrow = 0;
      ListNode leastSignificant1 = reverse( significant1), cur1=leastSignificant1;
      ListNode leastSignificant2 = reverse( significant2), cur2=leastSignificant2;
      ListNode cur = null;
      while( cur1 != null){
        int diff = borrow + cur1.val - (cur2==null ? 0 : cur2.val);
        if( diff < 0){
            borrow = -1;
            diff += 10;
        }
        else{
            borrow = 0;
        }
        ListNode ansDig = new ListNode( diff);
        ansDig.next = cur;
        cur = ansDig;
        cur1 = cur1.next;
        cur2 = cur2!=null ? cur2.next : null;
      }
      while(cur!=null && cur.val==0){
          ListNode temp = cur;
          cur = cur.next;
          temp.next = null;
      }
      return cur;
  }

  // InFput_code===================================================

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode makeList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head1 = makeList(scn.nextInt());
    ListNode head2 = makeList(scn.nextInt());

    ListNode ans = subtractTwoNumbers(head1, head2);
    printList(ans);
  }

}