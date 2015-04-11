//the recursion method is O(n) space complexity 
public class Solution {
    TreeNode n1;
    TreeNode n2;
    public void recoverTree(TreeNode root) {
        n1 = null;
        n2 = null;
        preorder(root, null);
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
    public TreeNode preorder(TreeNode node, TreeNode prev) {
        if (node.left != null) {
            prev = preorder(node.left, prev);
        }
        if (prev != null && prev.val > node.val) {
            if (n1 == null) {
                n1 = prev;
            }
            n2 = node;
        }
        if (node.right == null) {
            return node;
        } else {
            return preorder(node.right, node);
        }
    }
}
//O(1) space complexity --> Morris inorder traversal
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode n1 = null;
        TreeNode n2 = null;
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode next = cur.left;
                while (next.right != null && next.right != cur) {
                    next = next.right;
                }
                if (next.right == cur) {
                    next.right = null;
                    if (prev != null && prev.val > cur.val) {
                        if (n1 == null) {
                            n1 = prev;
                        }
                        n2 = cur;
                    }
                    prev = cur;
                    cur = cur.right;
                } else {
                    next.right = cur;
                    cur = cur.left;
                }
            } else {
                if (prev != null && prev.val > cur.val) {
                    if (n1 == null) {
                        n1 = prev;
                    }
                    n2 = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}
