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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        head = null;
        int val = Integer.MIN_VALUE;
        while (p != null) {
            if (p.val == val) {
                if (q != null) {
                    q.next = p.next;
                }
                p = p.next;
            } else if (p.next != null && p.val == p.next.val) {
                val = p.val;
                p = p.next;
            } else {
                q = p;
                p = p.next;
                if (head == null) {
                    head = q;
                }
            }
        }
        return head;
    }
}


//2nd
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        head = null;
        ListNode tail = null;
        while (p != null) {
            ListNode tmp;
            if (p.next == null || p.next.val != p.val) {
                tmp = p;
                p = p.next;
            } else {
                while (p.next != null && p.next.val == p.val) {
                    p = p.next;
                }
                p = p.next;
                continue;
            }
            if (head == null) {
                head = tmp;
                tail = tmp;
                tmp.next = null;
            } else {
                tail.next = tmp;
                tmp.next = null;
                tail = tmp;
            }
        }
        return head;
    }
}

