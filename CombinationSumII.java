public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        _combinationSum2(num, target, 0, path, res);
        return res;
    }
    public void _combinationSum2(int[] num, int target, int i, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
        } else if (target > 0 && i < num.length && num[i] <= target) {
            int count = 1;
            int j = i;
            while (j + 1 < num.length && num[j] == num[j+1]) {
                j++;
                count++;
            }
            for (int toAdd = 0; toAdd <= count; toAdd++) {
                _combinationSum2(num, target - toAdd*num[i], j+1, path, res);
                path.add(num[i]);
            }
            while (count-- >= 0) {
                path.remove(path.size() - 1);
            }
        }
    }
}
//3/23/2025
public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        combinationSum2(num, 0, target, path, res);
        return res;
    }
    public void combinationSum2(int[] num, int index, int target, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (target < 0 || index == num.length) {
            return;
        }
        path.add(num[index]);
        combinationSum2(num, index+1, target-num[index], path, res);
        path.remove(path.size() - 1);
        int i = index;
        while (i < num.length && num[i] == num[index]) {
            i++;
        }
        combinationSum2(num, i, target, path, res);
    }
}

