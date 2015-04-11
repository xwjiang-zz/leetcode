//handle the case that root == null
public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if (root == null) {
            return;
        }
        stack.add(root);
        while (stack.peek().left != null) {
            stack.add(stack.peek().left);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            stack.add(top.right);
            while (stack.peek().left != null) {
                stack.add(stack.peek().left);
            }
        }
        return top.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
