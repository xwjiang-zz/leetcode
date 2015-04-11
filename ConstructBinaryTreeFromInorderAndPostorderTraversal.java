public class Solution {
    public static Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hashtable.put(inorder[i], i);
        }
        return buildTree1(inorder, postorder, 0, inorder.length, 
                0, postorder.length);
    }
    //helper function
    public static TreeNode buildTree1(int[] inorder, int[] postorder, 
            int i1, int j1, int i2, int j2) {
        if (i1 == j1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[j2-1]);
        int k = hashtable.get(postorder[j2-1]);
        root.left = buildTree1(inorder, postorder, i1, k, i2, i2+k-i1);
        root.right = buildTree1(inorder, postorder, k+1, j1, i2+k-i1, j2-1);
        return root;
    }
}
