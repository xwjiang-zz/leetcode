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
//uses two lists
public class Solution {
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode p = head;
        ListNode psmall = small;
        ListNode pbig = big;
        while (p != null) {
            if (p.val < x) {
                psmall.next = p;
                psmall = psmall.next;
                p = p.next;
                psmall.next = null;
            } else {
                pbig.next = p;
                pbig = pbig.next;
                p = p.next;
                pbig.next = null;
            }
        }
        psmall.next = big.next;
        return small.next;
    }
}

//method 2 by Jiajie
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        while (p.next != null && p.next.val < x) {
            p = p.next;
        }
        ListNode q = p;
        while (q.next != null) {
            if (q.next.val >= x) {
                q = q.next;
            } else {
                ListNode tmp = q.next;
                q.next = tmp.next;
                tmp.next = p.next;
                p.next = tmp;
                p = p.next;
            }
        }
        return newHead.next;
    }
}

//method 3 by ref: https://github.com/leetcoders/LeetCode/blob/master/PartitionList.h
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode q = newHead;
        while (q.next != null) {
            if (q.next.val >= x) {
                q = q.next;
            } else {
                if (p == q) {
                    p = p.next;
                    q = q.next;
                } else {
                    ListNode tmp = q.next;
                    q.next = tmp.next;
                    tmp.next = p.next;
                    p.next = tmp;
                    p = p.next;
                }
            }
        }
        return newHead.next;
    }
}


//4/4/2015 JJ's method and method 3 are basically the same
//used cur and ins to be more clear
//also if a move does happen, notice only update ins pointer but not the cur pointer
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode ins = dummy;
        while (cur.next != null) {
            ListNode mov = cur.next;
            if (mov.val < x) {
                if (cur == ins) {
                    cur = cur.next;
                    ins = ins.next;
                } else {
                    cur.next = mov.next;
                    mov.next = ins.next;
                    ins.next = mov;
                    ins = ins.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
