//reading the problem: is it in reverse order?
//compare with stored in another order

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int carrier = 0;
        ListNode sum = null;
        ListNode current = null;
        while (p != null || q != null || carrier != 0) {
            int bitSum = carrier;
            if (p != null) {
                bitSum += p.val;
                p = p.next;
            }
            if (q != null) {
                bitSum += q.val;
                q = q.next;
            }
            ListNode tmp = new ListNode(bitSum%10);
            carrier = bitSum/10;
            if (sum == null) {
                sum = tmp;
                current = tmp;
            } else {
                current.next = tmp;
                current = current.next;
            }
        }
        return sum;
    }
}
