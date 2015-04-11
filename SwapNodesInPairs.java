/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur, prev;
        cur = head;
        prev = newHead;
        while (cur != null && cur.next != null) {
            ListNode tmp = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = tmp;
            prev = cur;
            cur = prev.next;
        }
        return newHead.next;
    }
    
//another method, more like swap
/*
    public ListNode swapPairs(ListNode head) {
      if(head==null) return null; 
      if(head.next==null) return head; 
      ListNode previous=null; 
      ListNode current=head; 
      ListNode runner=head.next; 
      while(runner!=null && runner!=current)
      {
        current.next=runner.next; 
        runner.next=current; 
        if(previous==null)
        {
          previous=runner; 
          head=previous; 
          previous=previous.next; 
        }else
        {
          previous.next=runner; 
          previous=previous.next.next; 
        }
        current=current.next;
        if(current==null) break; 
        runner=runner.next.next.next; 
         
      }
      return head; 
    }

*/

}
