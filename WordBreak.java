public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = i+1; j < n + 1; j++) {
                if (dict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
