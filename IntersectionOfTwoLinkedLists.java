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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a != null) {
            a = a.next;
            lenA++;
        }
        while (b != null) {
            b = b.next;
            lenB++;
        }
        a = headA;
        b = headB;
        while (lenA > lenB) {
            a = a.next;
            lenA--;
        }
        while (lenB > lenA) {
            b = b.next;
            lenB--;
        }
        while (lenA > 0) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
            lenA--;
        }
        return null;
    }
}
