//the same thought as level order traversal
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(null);
        queue.add(root);
        while (queue.size() >= 2) {
            TreeNode front = queue.poll();
            if (front == null) {
                queue.add(null);
                front = queue.poll();
                res.add(front.val);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
            if (front.left != null) {
                queue.add(front.left);
            }
        }
        return res;
    }
}

