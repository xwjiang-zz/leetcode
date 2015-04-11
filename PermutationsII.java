//my method is not very space efficient --> I use HashMap
//another method is to only use array. ref: https://github.com/leetcoders/LeetCode/blob/master/PermutationsII.h
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                map.put(num[i], map.get(num[i]) + 1);
            } else {
                map.put(num[i], 1);
            }
        }
        int count = num.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        _permuteUnique(map, count, path, res);
        return res;
    }
    public void _permuteUnique(Map<Integer, Integer> map, int count, List<Integer> path, List<List<Integer>> res) {
        if (count == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > 0) {
                map.put(key, value-1);
                path.add(key);
                _permuteUnique(map, count-1, path, res);
                map.put(key, value);
                path.remove(path.size() - 1);
            }
        }
    }
}

//3/25/2015
//use used array to remember which element has been used already, avoid hashmap
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        boolean[] used = new boolean[num.length];
        return permuteUniqueRec(num, num.length, used);
    }
    public List<List<Integer>> permuteUniqueRec(int[] num, int count, boolean[] used) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (count == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        int lastIndex = -1;
        for (int i = 0; i < num.length; i++) {
            if (used[i] ||
                (lastIndex >= 0 && num[i] == num[lastIndex])) {
                continue;
            }
            used[i] = true;
            List<List<Integer>> subRes = permuteUniqueRec(num, count-1, used);
            for (List<Integer> list : subRes) {
                list.add(num[i]);
                res.add(list);
            }
            used[i] = false;
            lastIndex = i;
        }
        return res;
    }
}
