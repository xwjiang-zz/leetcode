//iteration, notice that different from normal preorder traversal, the position of NULL also need to be pushed into the stack
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        leftStack.push(root.left);
        rightStack.push(root.right);
        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode leftTop = leftStack.pop();
            TreeNode rightTop = rightStack.pop();
            if (leftTop == null && rightTop == null) {
                continue;
            }
            if (leftTop == null || rightTop == null || leftTop.val != rightTop.val) {
                return false;
            }
            leftStack.push(leftTop.right);
            leftStack.push(leftTop.left);
            rightStack.push(rightTop.left);
            rightStack.push(rightTop.right);
        }
        if (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            return false;
        }
        return true;
    }
}
//recursion version
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return _isSymmetric(root.left, root.right);
    }
    public boolean _isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return _isSymmetric(left.left, right.right) && _isSymmetric(left.right, right.left);
    }
}
