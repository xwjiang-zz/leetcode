//notice that current must be static in order for the change to take effect!
//C++ and java difference
//no need of two indexes, only need a length
public class Solution {
    public ListNode current;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        current = head;
        return _sortedListToBST(count);
    }
    public TreeNode _sortedListToBST(int len) {
        if (len == 0) {
            return null;
        }
        int halfLen = len/2;
        TreeNode left = _sortedListToBST(halfLen);
        TreeNode newNode = new TreeNode(current.val);
        current = current.next;
        TreeNode right = _sortedListToBST(len-1-halfLen);
        newNode.left = left;
        newNode.right = right;
        return newNode;
    }
}
