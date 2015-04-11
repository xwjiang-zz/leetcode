public class Solution {
    public boolean isBalanced(TreeNode root) {
        return _isBalanced(root) >= 0;
    }
    public int _isBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = _isBalanced(root.left);
        int right = _isBalanced(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
