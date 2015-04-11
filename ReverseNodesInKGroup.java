//method 1, more general, but more comlicated
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        ListNode newHead = null;
        ListNode tail = null;
        while (p != null) {
            for (int i = 1; i < k; i++) {
                if (p.next == null) {
                    return newHead == null ? head : newHead;
                } else {
                    p = p.next;
                }
            }
            if (newHead == null) {
                newHead = p;
            } else {
                tail.next = p;
            }
            tail = q;
            while (q != p) {
                ListNode qNext = q.next;
                q.next = p.next;
                p.next = q;
                q = qNext;
            }
            p = tail.next;
            q = p;
        }
        return newHead;
    }
}

//method 2
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        int len = getLength(head);
        int revTimes = len/k;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode ins = newHead;
        ListNode cur = head;
        while (revTimes-- > 0) {
            for (int i = 1; i < k; i++) {
                ListNode tmp = cur.next;
                cur.next = cur.next.next;
                tmp.next = ins.next;
                ins.next = tmp;
            }
            ins = cur;
            cur = ins.next;
        }
        return newHead.next;
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
