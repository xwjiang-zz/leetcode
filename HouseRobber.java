public class Solution {
    public int rob(int[] num) {
        int len = num.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = num[0];
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i-2] + num[i-1], dp[i-1]);
        }
        return dp[len];
    }
}
