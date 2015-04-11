//notice that ArrayList can put null element
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return _generateTrees(1, n+1);
    }
    public List<TreeNode> _generateTrees(int i, int j) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (i == j) {
            res.add(null);
            return res;
        }
        for (int k = i; k < j; k++) {
            List<TreeNode> left = _generateTrees(i, k);
            List<TreeNode> right = _generateTrees(k+1, j);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode newNode = new TreeNode(k);
                    newNode.left = nl;
                    newNode.right = nr;
                    res.add(newNode);
                }
            }
        }
        return res;
    }
}
