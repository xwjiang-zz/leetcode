//look at it together with ReverseLinkListII and ReverseKNodes
public class Solution {
    public void reorderList(ListNode head) {
        int len = getLength(head);
        if (len <= 1) {
            return;
        }
        ListNode p = head;
        for (int i = 1; i < (len+1)/2; i++) {
            p = p.next;
        }
        ListNode cur = p.next;
        p.next = null;
        ListNode move = cur.next;
        cur.next = null;
        while (move != null) {
            ListNode tmp = move.next;
            move.next = cur;
            cur = move;
            move = tmp;
        }
        ListNode left = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = left.next;
            left.next = cur;
            left = left.next.next;
            cur = tmp;
        }
    }
    public int getLength(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
}
