//notice the difference between removeFirst() and getFirst()

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> result1 = new ArrayList<Integer>();
        TreeNode curLast, nextLast;
        TreeNode p;
        boolean dir = true; //go from left to right
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        deque.addFirst(root);
        curLast = root;
        nextLast = null;
        while (deque.isEmpty() == false) {
            if (dir == true) {
                //goes from left child to right child, remove from first, add from last
                p = deque.removeFirst();
                result1.add(p.val);
                if (p.left != null) {
                    if (nextLast == null) {
                        nextLast = p.left;
                    }
                    deque.addLast(p.left);
                }
                if (p.right != null) {
                    if (nextLast == null) {
                        nextLast = p.right;
                    }
                    deque.addLast(p.right);
                }
            } else {
                //goes from right child to left child, remove from last, add from first
                p = deque.removeLast();
                result1.add(p.val);
                if (p.right != null) {
                    if (nextLast == null) {
                        nextLast = p.right;
                    }
                    deque.addFirst(p.right);
                }
                if (p.left != null) {
                    if (nextLast == null) {
                        nextLast = p.left;
                    }
                    deque.addFirst(p.left);
                }
            }
            if (p == curLast) {
                result.add(result1);
                result1 = new ArrayList<Integer>();
                curLast = nextLast;
                nextLast = null; //reset nextLast
                if (dir == true) { //change polarity
                    dir = false;
                } else {
                    dir = true;
                }
            }
        }
        return result;
    }
}

//12/29 --> use null as separator
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        queue.addLast(root);
        queue.addLast(null);
        boolean dir = true;
        while (true) {
            TreeNode peek = dir ? queue.peekFirst() : queue.peekLast();
            if (peek == null) {
                res.add(list);
                list = new ArrayList<Integer>();
                dir = !dir;
                if (queue.size() == 1) {
                    break;
                } else {
                    continue;
                }
            }
            if (dir) {
                TreeNode front = queue.removeFirst();
                list.add(front.val);
                if (front.left != null) {
                    queue.addLast(front.left);
                }
                if (front.right != null) {
                    queue.addLast(front.right);
                }
            } else {
                TreeNode back = queue.removeLast();
                list.add(back.val);
                if (back.right != null) {
                    queue.addFirst(back.right);
                }
                if (back.left != null) {
                    queue.addFirst(back.left);
                }
            }
        }
        return res;
    }
}
