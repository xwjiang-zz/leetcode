
public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n+1; j++) {
            for (int i = j; i < m+1; i++) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1] * (S.charAt(i-1) == T.charAt(j-1) ? 1 : 0);
            }
        }
        return dp[m][n];
    }
}

public class Solution {
    public int numDistinct(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i<= m; i++) {
            for (int j = n; j > 0; j--) {
                dp[j] = dp[j] + dp[j-1]*(S.charAt(i-1) == T.charAt(j-1) ? 1 : 0);   
            }
        }
        return dp[n];
    }
}
