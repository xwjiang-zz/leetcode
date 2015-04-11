public class Solution {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res;
        if (k == 0) {
            res = new ArrayList<List<Integer>>();
            List<Integer> lst = new ArrayList<Integer>();
            res.add(lst);
            return res;
        }
        if (n < k) {
            return new ArrayList<List<Integer>>();
        }
        res = combine(n-1, k);
        List<List<Integer>> res2 = combine(n-1, k-1);
        for (List<Integer> list : res2) {
            list.add(n);
        }
        res.addAll(res2);
        return res;
    }
}

//2nd solution using iteration
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] path = new int[k];
        int count = 0;
        while (count >= 0) {
            if (count == k) {
                List<Integer> newRes = new ArrayList<Integer>();
                for (int i = 0; i < k; i++) {
                    newRes.add(path[i]);
                }
                res.add(newRes);
                count--;
            } else {
                if (count == 0) {
                    path[count] = path[count] + 1;
                } else {
                    path[count] = Math.max(path[count-1] + 1, path[count] + 1);
                }
                if (path[count] < n + 1) {
                    count++;
                } else {
                    path[count] = 0;
                    count--;
                }
            }
        }
        return res;
    }
}

//3rd solution using recursion
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] path = new int[k];
        _combine(n, k, 0, path, res);
        return res;
    }
    public void _combine(int n, int k, int count, int[] path, List<List<Integer>> res) {
        if (count == k) {
            List<Integer> newRes = new ArrayList<Integer>();
            for (int i = 0; i < k; i++) {
                newRes.add(path[i]);
            }
            res.add(newRes);
            return;
        } else if (count == 0) {
            for (int i = 1; i <= n; i++) {
                path[0] = i;
                _combine(n, k, 1, path, res);
            }
        } else {
            for (int i = path[count-1] + 1; i <= n; i++) {
                path[count] = i;
                _combine(n, k, count+1, path, res);
            }
        }
    }
}
