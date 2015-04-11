//pass by value 
//note that how max is passed
public class Solution {
    public class Result {
        int singleSidePathSum;
        int max;
        Result(int _sum, int _max) {
            singleSidePathSum = _sum;
            max = _max;
        }
    }
    public int maxPathSum(TreeNode root) {
        return _maxPathSum(root, Integer.MIN_VALUE).max;
    }
    public Result _maxPathSum(TreeNode node, int max) {
        if (node == null) {
            return new Result(Integer.MIN_VALUE, max);
        }
        Result left = _maxPathSum(node.left, max);
        Result right = _maxPathSum(node.right, left.max);
        int sum = node.val + Math.max(Math.max(left.singleSidePathSum, right.singleSidePathSum), 0);
        int res = Math.max(node.val + Math.max(0, left.singleSidePathSum) + Math.max(0, right.singleSidePathSum), right.max);
        return new Result(sum, res);
    }
}
