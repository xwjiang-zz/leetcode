//count needs to be "sort of" global yet pathSum can be passed by value
//ref: https://github.com/leetcoders/LeetCode/blob/master/SumRoottoLeafNumbers.h
public class Solution {
    public int count = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return count;
        }
        int pathSum = 0;
        _sumNumbers(root, pathSum);
        return count;
    }
    public void _sumNumbers(TreeNode root, int pathSum) {
        if (root.left == null && root.right == null) {
            count += pathSum * 10 + root.val;
            return;
        }
        if (root.left != null) {
            _sumNumbers(root.left, pathSum * 10 + root.val);
        }
        if (root.right != null) {
            _sumNumbers(root.right, pathSum * 10 + root.val);
        }
    }
}
