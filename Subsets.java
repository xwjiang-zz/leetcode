//1st version
public class Solution {
    public static List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        return subsetsLen(S, S.length);
    }
    public static List<List<Integer>> subsetsLen(int[] S, int len) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (len == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<List<Integer>> subResult1 = subsetsLen(S, len - 1);
        List<List<Integer>> subResult2 = new ArrayList<List<Integer>>();
        for (List<Integer> lst : subResult1) {
            List<Integer> newlst = new ArrayList<Integer>(lst);
            newlst.add(S[len-1]);
            subResult2.add(newlst);
        }
        result.addAll(subResult1);
        result.addAll(subResult2);
        return result;
    }
}

//2nd version --> recursion/DFS
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] path = new int[S.length];
        _subsets(S, 0, 0, path, res);
        return res;
    }
    public void _subsets(int[] S, int start, int count, int[] path, List<List<Integer>> res) {
        addToResult(path, count, res);
        for (int i = start; i < S.length; i++) {
            path[count] = S[i];
            _subsets(S, i+1, count+1, path, res);
        }
    }
    public void addToResult(int[] path, int count, List<List<Integer>> res) {
        List<Integer> newRes = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            newRes.add(path[i]);
        }
        res.add(newRes);
    }
        
}

//3/30/2015
//3rd version --> iteration
//notice when using List<List<Integer>> replica = new ArrayList<List<Integer>>(res);
//it's a shadow copy/construction
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; i++) {
            int sz = res.size();
            for (int j = 0; j < sz; j++) {
                List<Integer> newRes = new ArrayList<Integer>(res.get(j));
                newRes.add(S[i]);
                res.add(newRes);
            }
        }
        return res;
    }
}
