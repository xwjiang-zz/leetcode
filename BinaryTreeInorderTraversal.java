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
    public List<Integer> inorderTraversal(TreeNode root) {
                class TreeNodeFlag {
            TreeNode node;
            Boolean flag;
            TreeNodeFlag(TreeNode p, Boolean marker) {
                node = p;
                flag = marker;
            }
        }
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNodeFlag> stack = new Stack<TreeNodeFlag>();
        if (root == null) {
            return inorder;
        }
        TreeNodeFlag rootFlag = new TreeNodeFlag(root,false);
        stack.add(rootFlag);
        TreeNodeFlag pFlag;
        while (stack.empty() != true) {
            pFlag = stack.pop();
            if (pFlag.flag == true) {
                inorder.add(pFlag.node.val);
            } else {
                TreeNode p = pFlag.node;
                if (p.right != null) {
                    stack.add(new TreeNodeFlag(p.right, false));
                }
                pFlag.flag = true;
                stack.add(pFlag);
                if (p.left != null) {
                    stack.add(new TreeNodeFlag(p.left, false));
                }
            }
        }
        return inorder;
    }
}


//2nd solution
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top == null) {
                stack.pop();
                top = stack.pop();
                res.add(top.val);
                if (top.right != null) {
                    stack.push(top.right);
                }
            } else {
                stack.push(null);
                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
        return res;
    }
}


//more from ref: http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html

//4/5/2015
//use cur pointer!
//cur means what should be the next TreeNode to put into stack
//if cur == null, means no further element to put into the stack, need to pop the stack
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                res.add(stack.peek().val);
                cur = stack.peek().right;
                stack.pop();
            }
        }
        return res;
    }
}
