//AVOID duplicates!!!
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i-1]) {
                continue;
            }
            for (int j = i+1; j < num.length - 1; j++) {
                if (j > i+1 && num[j] == num[j-1]) {
                    continue;
                }
                int m = j + 1;
                int n = num.length - 1;
                while (m < n) {
                    int sum = num[i] + num[j] + num[m] + num[n];
                    if (sum == target) {
                        List<Integer> newList = new ArrayList<Integer>();
                        newList.add(num[i]);
                        newList.add(num[j]);
                        newList.add(num[m]);
                        newList.add(num[n]);
                        res.add(newList);
                        m++;
                        while (m < num.length && num[m] == num[m-1]) {
                            m++;
                        }
                        n--;
                    } else if (sum < target) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }
        return res;
    }
}
