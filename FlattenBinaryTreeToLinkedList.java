//1. iteration using a stack
//2. recursion 


// iteration
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        TreeNode current = null;
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            tmp.left = null;
            tmp.right = null;
            if (!stack.isEmpty()) {
                tmp.right = stack.top();
            }
        }
    }
}

//recursion
public class Solution {
    public TreeNode current = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        if (current != null) {
            current.right = root;
        }
        current = root;
        flatten(left);
        flatten(right);
    }
}
