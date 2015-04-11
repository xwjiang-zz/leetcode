//the importance of perfect binary tree!!
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        while (node != null) {
            _connect(node);
            node = node.left;
        }
    }
    public void _connect(TreeLinkNode node) {
        while (node != null) {
            if (node.left == null) {
                return;
            }
            node.left.next = node.right;
            node.right.next = node.next == null ? null : node.next.left;
            node = node.next;
        }
    }
}
