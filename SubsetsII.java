//look at it together with combinational sum
//better solution here since there is no nasty count the number of duplicates, add them on, and remove them
//pay attention to how duplicates are avoided
//also there is iteration method
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        _subsetsWithDup(num, 0, path, res);
        return res;
    }
    public void _subsetsWithDup(int[] num, int index, List<Integer> path, List<List<Integer>> res) {
        if (index == num.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(num[index]);
        _subsetsWithDup(num, index+1, path, res);
        path.remove(path.size() - 1);
        index++;
        while (index < num.length && num[index] == num[index-1]) {
            index++;
        }
        _subsetsWithDup(num, index, path, res);
    }
}

//3/30/2015
//recursion : BFS
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        return subsetsWithDupRec(num, num.length);
    }
    public List<List<Integer>> subsetsWithDupRec(int[] num, int index) {
        if (index == 0) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            res.add(new ArrayList<Integer>());
            return res;
        }
        int i = index;
        while (i > 0 && num[i-1] == num[index-1]) {
            i--;
        }
        List<List<Integer>> res = subsetsWithDupRec(num, i);
        List<List<Integer>> res1 = subsetsWithDupRec(num, index-1);
        for (List<Integer> list : res1) {
            list.add(num[index-1]);
            res.add(list);
        }
        return res;
    }
}

//another recursion : DFS
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        res.add(path);
        subsetsWithDupRec(num, 0, path, res);
        return res;
    }
    public void subsetsWithDupRec(int[] num, int index, List<Integer> path, List<List<Integer>> res) {
        if (index == num.length) {
            return;
        }
        path.add(num[index]);
        res.add(new ArrayList<Integer>(path));
        subsetsWithDupRec(num, index + 1, path, res);
        path.remove(path.size() - 1);
        int i = index + 1;
        while (i < num.length && num[i] == num[index]) {
            i++;
        }
        subsetsWithDupRec(num, i, path, res);
    }
}
