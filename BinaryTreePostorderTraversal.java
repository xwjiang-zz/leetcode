/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top == null) {
                stack.pop();
                result.add(stack.pop().val);
            } else {
                stack.push(null);
                if (top.right != null) {
                    stack.push(top.right);
                }
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
        return result;
    }
}


//4/5/2015
//look at it together with inorder traversal
//notice that cur is assigned to cur.right if cur.left == null
//also since it's postorder, the stack needs to pop several times before push in new node
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            } else {
                TreeNode popped = stack.pop();
                res.add(popped.val);
                while (!stack.isEmpty() && popped == stack.peek().right) {
                    popped = stack.pop();
                    res.add(popped.val);
                }
                if (!stack.isEmpty()) {
                    cur = stack.peek().right;
                }
            }
        }
        return res;
    }
}

