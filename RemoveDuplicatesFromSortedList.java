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
 //1st: kind of in place
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head  == null) {
            return null;
        }
        ListNode p, q;
        p = head;
        q = head.next;
        while(q != null) {
            if (p.val == q.val) {
                p.next = q.next;
                q = q.next;
            } else {
                p = q;
                q = q.next;
            }
        }
        return head;
    }
}
//2nd: build up a new list
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        head = null;
        ListNode tail = null;
        while (p != null) {
            ListNode tmp = p;
            p = p.next;
            if (head == null) {
                head = tmp;
                tail = tmp;
                tail.next = null;
            } else if (tail.val != tmp.val) {
                tail.next = tmp;
                tmp.next = null;
                tail = tmp;
            }
        }
        return head;
    }
}
