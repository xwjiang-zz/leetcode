public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    List<Integer> newList = new ArrayList<Integer>();
                    newList.add(num[i]);
                    newList.add(num[j]);
                    newList.add(num[k]);
                    res.add(newList);
                    //notice the two whiles to get rid of the duplicates. very neat
                    while (++j < k && num[j] == num[j-1]) {}
                    while (--k > j && num[k] == num[k+1]) {}
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
