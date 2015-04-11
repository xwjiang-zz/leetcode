//complexity calculation
//compare with AddTwoNumbers (with Linked list presentation)
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return _sortList(head, len);
    }
    public ListNode _sortList(ListNode node, int len) {
        if (len <= 1) {
            return node;
        }
        ListNode left = node;
        ListNode right = node;
        for (int i = 0; i < len/2 - 1; i++) {
            right = right.next;
        }
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;
        left = _sortList(left, len/2);
        right = _sortList(right, len - len/2);
        ListNode head = null;
        ListNode tail = null;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tmp = left;
                left = left.next;
            } else {
                tmp = right;
                right = right.next;
            }
            if (head == null) {
                head = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tail.next;
            }
        }
        tail.next = left == null ? right : left;
        return head;
    }
}
