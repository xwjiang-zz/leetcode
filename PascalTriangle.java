public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        res.add(list);
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<Integer>();
            list.add(1);
            for (int j = 0; j < i-1; j++) {
                list.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
