public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST1(num, 0, num.length-1);
    }
    
    //helper function
    public TreeNode sortedArrayToBST1(int[] num, int i, int j) {
        if (i > j) return null;
        int rootID = (i + j)/2;
        TreeNode root = new TreeNode(num[rootID]);
        TreeNode left = sortedArrayToBST1(num, i, rootID - 1);
        TreeNode right = sortedArrayToBST1(num, rootID + 1, j);
        root.left = left;
        root.right = right;
        return root;
    }
    
}
