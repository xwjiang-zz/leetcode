 /*Definetion for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//1st version: recursion. No need to have a wrapper class! 
//ref: https://github.com/leetcoders/LeetCode/blob/master/ValidateBinarySearchTree.h 
public class Solution {
    public static class Wrapper {
        boolean valid;
        int min;
        int max;
        Wrapper(boolean valid) {
            this.valid = valid;
        }
        Wrapper(boolean valid, int min, int max) {
            this.valid = valid;
            this.min = min;
            this.max = max;
        }
    }
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST1(root).valid;
    }
    //helper function
    public static Wrapper isValidBST1(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Wrapper(true, root.val, root.val);
        }
        Wrapper wrapperLeft, wrapperRight;
        if (root.left == null) {
            wrapperRight = isValidBST1(root.right);
            if (wrapperRight.valid == true 
                    && root.val < wrapperRight.min) {
                return new Wrapper(true, root.val, wrapperRight.max);
            }
            return new Wrapper(false);
        }
        if (root.right == null) {
            wrapperLeft = isValidBST1(root.left);
            if (wrapperLeft.valid == true 
                    && root.val > wrapperLeft.max) {
                return new Wrapper(true, wrapperLeft.min, root.val);
            }
            return new Wrapper(false);
        }
        wrapperLeft = isValidBST1(root.left);
        wrapperRight = isValidBST1(root.right);
        if (wrapperLeft.valid == true && wrapperRight.valid == true
                && wrapperLeft.max < root.val 
                && wrapperRight.min > root.val) {
            return new Wrapper(true, wrapperLeft.min, wrapperRight.max);
        }
        return new Wrapper(false);
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        long last = Long.MIN_VALUE;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode top = stack.pop();
                if (last >= top.val) {
                    return false;
                }
                last = top.val;
                cur = top.right;
            }
        }
        return true;
    }
}

