//candidates don't have dupliated elements!
//ref: https://github.com/leetcoders/LeetCode/blob/master/CombinationSum.h
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        _combinationSum(candidates, candidates.length, 0, target, path, res);
        return res;
    }
    public void _combinationSum(int[] candidates, int len, int index, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            List<Integer> newList = new ArrayList<Integer>(path);
            res.add(newList);
            return;
        } else if (target < 0) {
            return;
        } else {
            if (len == index) {
                return;
            } else {
                path.add(candidates[index]);
                _combinationSum(candidates, len, index, target - candidates[index], path, res);
                path.remove(path.size()-1);
                _combinationSum(candidates, len, index+1, target, path, res);
            }
        }
    }
}
