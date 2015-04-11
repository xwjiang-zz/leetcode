/*
1. iteration method
2. complexity time: O(n) ; space : O(n)
3. use stack and map
*/

public class Solution {
    public class TreeNodeWithDir {
        TreeNode node;
        boolean dir;
        TreeNodeWithDir(int _val) {
            node = new TreeNode(_val);
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        Stack<TreeNodeWithDir> stack = new Stack<TreeNodeWithDir>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            while (i < len && !map.containsKey(preorder[i])) {
                stack.push(new TreeNodeWithDir(preorder[i]));
                map.put(preorder[i], 1);
                if (preorder[i] == inorder[j]) {
                    i++;
                    j++;
                    break;
                } else {
                    stack.peek().dir = true;
                    i++;
                }
            }
            while (j < len && map.containsKey(inorder[j])) {
                while (stack.size() > 1 && stack.peek().node.val != inorder[j]) {
                    TreeNode tmp = stack.pop().node;
                    map.remove(tmp.val);
                    if (stack.peek().dir) {
                        stack.peek().node.left = tmp;
                        stack.peek().dir = false;
                    } else {
                        stack.peek().node.right = tmp;
                    }
                }
                j++;
            }
        }
        while (stack.size() > 1) {
            TreeNode tmp = stack.pop().node;
            if (stack.peek().dir) {
                stack.peek().node.left = tmp;
            } else {
                stack.peek().node.right = tmp;
            }
        }
        return stack.pop().node;
    }
}
