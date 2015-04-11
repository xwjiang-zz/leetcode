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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            q = q.next; 
        }
        if (q == null) {
            ListNode tmp = head.next;
            head.next = null;
            return tmp;
        }
        ListNode p = head;
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode tmp = p.next;
        p.next = p.next.next;
        tmp.next = null;
        return head;
    }
}
