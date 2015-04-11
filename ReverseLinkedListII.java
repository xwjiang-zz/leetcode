//look at this problem together with reverse k nodes together
//the operation of reverse in linkedlist
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode ins = newHead;
        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            ins = ins.next;
            cur = cur.next;
        }
        for (int i = m; i < n; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = ins.next;
            ins.next = next;
        }
        return newHead.next;
    }
}

//4/5/2015
//more clear
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ins = dummy;
        for (int i = 1; i < m; i++) {
            ins = ins.next;
        }
        ListNode cur = ins.next;
        for (int i = m; i < n; i++) {
            ListNode mov = cur.next;
            cur.next = mov.next;
            mov.next = ins.next;
            ins.next = mov;
        }
        return dummy.next;
    }
}
