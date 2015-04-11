//use priority queue!!
//methods: poll(), offer()
//pay attention to illigal arguments, predefined size cannot be 0
//inline
//customized comparator


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
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(),
            new Comparator<ListNode>() {
                public int compare(ListNode n1, ListNode n2) {
                    if (n1.val == n2.val) {
                        return 0;
                    } else {
                        return n1.val < n2.val ? -1 : 1;
                    }
                }
            });
        for (ListNode each : lists) {
            if (each == null) {
                continue;
            }
            queue.offer(each);
        }
        ListNode head = null;
        ListNode tail = null;
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            if (tmp.next != null) {
                queue.offer(tmp.next);
            }
            if (head == null) {
                head = tmp;
                tail = tmp;
            } else {
                tail.next = tmp;
                tail = tail.next;
            }
        }
        return head;
    }
}

//3/21/2015
//anonymous class!
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        int k = lists.size();
        if (k == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(k, new Comparator<ListNode>(){
            public int compare(ListNode n1, ListNode n2) {
                return n1.val < n2.val ? -1 : 1;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.add(node.next);
            }
            node.next = null;
            cur.next = node;
            cur = cur.next;
        }
        return newHead.next;
    }
}
