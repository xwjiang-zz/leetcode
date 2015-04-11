public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int res = 1000000;
        for (int i = 0; i < num.length - 1; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (Math.abs(res - target) > Math.abs(sum - target)) {
                    res = sum;
                }
                if (sum == target) {
                    return target;
                } else if(sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
