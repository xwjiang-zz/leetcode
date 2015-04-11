/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode p = head;
        while (p != null) {
            RandomListNode twin = new RandomListNode(p.label);
            twin.next = p.next;
            p.next = twin;
            p = twin.next;
        }
        p = head;
        RandomListNode newHead = head.next;
        RandomListNode q;
        //need two while loops: 1st to modify random pointer; 2nd to change back next point
        while (p != null) {
            q = p.next;
            q.random = (p.random == null) ? null : p.random.next;
            p = p.next.next;
        }
        p = head;
        while (p != null) {
            q = p.next;
            p.next = q.next;
            p = p.next;
            q.next = (p == null) ? null : p.next;
        }
        return newHead;
    }
}
