//difference between pass by value and pass by reference
//http://pages.cs.wisc.edu/~cs368-2/CppTutorial/NOTES/PARAMS.html
//http://www.cs.iastate.edu/~honavar/JavaNotes/Notes/chap34b/chap34Bquiz.html
//http://bulldog2.redlands.edu/facultyfolder/patriciacornez/cs110/quiz10.html
//http://courses.cs.vt.edu/cs2604/SummerI_2006/OQ/2/Q2.C++Functions.pdf

//1st version
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> l = new ArrayList<Integer>();
            l.add(root.val);
            res.add(l);
            return res;
        }
        List<List<Integer>> subRes = pathSum(root.left, sum - root.val);
        for (List<Integer> list : subRes) {
            list.add(0, root.val);
            res.add(list);
        }
        subRes = pathSum(root.right, sum - root.val);
        for (List<Integer> list : subRes) {
            list.add(0, root.val);
            res.add(list);
        }
        return res;
    }
}

//2nd version
