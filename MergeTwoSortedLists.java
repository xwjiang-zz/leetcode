//the way to set up the tmp to store the min node first and then consider the case if head is null
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = null;
        ListNode tail = null;
        while (p != null && q != null) {
            ListNode tmp;
            if (p.val <= q.val) {
                tmp = p;
                p = p.next;
            } else {
                tmp = q;
                q = q.next;
            }
            if (head == null) {
                head = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tail.next;
            }
        }
        if (head == null) {
            return (p == null) ? q : p;
        }
        tail.next = (p == null) ? q : p;
        return head;
    }
}

//3/21/2015
//simpler logic with a dummy head
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return newHead.next;
    }
}
