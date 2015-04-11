//definition of leaf node! it's not an edge node!
//{1, 2} 1 is not a leaf
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return findPath(root, sum);
    }
    public boolean findPath(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return findPath(root.left, sum) || findPath(root.right, sum);
    }
}
