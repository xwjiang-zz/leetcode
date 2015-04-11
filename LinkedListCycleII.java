public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode cur = fast;
                while (head != cur) {
                    head = head.next;
                    cur = cur.next;
                }
                return cur;
            }
        }
        return null;
    }
}
