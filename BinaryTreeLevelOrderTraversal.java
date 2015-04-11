// ref: https://github.com/leetcoders/LeetCode/blob/master/BinaryTreeLevelOrderTraversal.h
//1st solution
public class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> result1 = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode currentLevelLast = root;
        TreeNode nextLevelLast = null;
        queue.add(root);
        TreeNode p;
        while(queue.isEmpty() == false) {
            p = queue.remove();
            result1.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
                nextLevelLast = p.left;
            }
            if (p.right != null) {
                queue.add(p.right);
                nextLevelLast = p.right;
            }
            if (p == currentLevelLast) {
                
                result.add(result1);
                result1 = new ArrayList<Integer>();
                if (nextLevelLast == null) {
                    continue;
                }
                currentLevelLast = nextLevelLast;
                nextLevelLast = null;
            }
        }

        return result;
    }
}

//2nd
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) {
                res.add(list);
                list = new ArrayList<Integer>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                list.add(front.val);
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }
        return res;
    }
}
