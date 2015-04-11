public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        int len = getLength(head);
        if (len == 0) {
            return head;
        }
        int jump = len - 1 - n % len;
        ListNode p = head;
        for (int i = 0; i < jump; i++) {
            p = p.next;
        }
        if (p.next == null) {
            return head;
        }
        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return newHead;
    }
    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
