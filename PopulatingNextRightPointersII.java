public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode node = root;
        while (node != null) {
            node = _connect(node);
        }
    }
    public TreeLinkNode _connect(TreeLinkNode node) {
        TreeLinkNode left = null;
        TreeLinkNode current = null;
        while (node != null) {
            if (node.left != null) {
                if (left == null) {
                    left = node.left;
                    current = node.left;
                } else {
                    current.next = node.left;
                    current = node.left;
                }
            }
            if (node.right != null) {
                if (left == null) {
                    left = node.right;
                    current = node.right;
                } else {
                    current.next = node.right;
                    current = node.right;
                }
            }
            node = node.next;
        }
        return left;
    }
}
