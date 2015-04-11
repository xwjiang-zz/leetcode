//solution 1: uses dynamic programming
//solution 2: uses combinational maths. Note that even use long, may still out of range. Need to make sure that m < n
//solution 3: dynamic programming with only 1d array

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) {
            return uniquePaths(n, m);
        }
        long res = 1L;
        for (int i = m-1; i > 0; i--) {
            res *= (i+n-1);
        }
        for (int i = m-1; i > 0; i--) {
            res /= i;
        }
        return (int)res;
    }
}


public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
