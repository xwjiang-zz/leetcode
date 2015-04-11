//here uses iteration, can also use recursion!
//use an array to record used numbers
//ref: https://github.com/leetcoders/LeetCode/blob/master/Permutations.h
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> newRes = new ArrayList<List<Integer>>();
            for (List<Integer> list : res) {
                for (int j = 0; j <= i; j++) {
                    List<Integer> newList = new ArrayList<Integer>(list);
                    newList.add(j, num[i]);
                    newRes.add(newList);
                }
            }
            res = newRes;
        }
        return res;
    }
}
