public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<Integer>();
        while(queue.size() > 1 || list.size() != 0) {
            TreeNode front = queue.poll();
            if (front != null) {
                list.add(front.val);
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            } else {
                res.add(0, list);
                list = new ArrayList<Integer>();
                queue.add(null);
            }
        }
        return res;
    }
}
