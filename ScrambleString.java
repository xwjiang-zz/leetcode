//pay attention to the sequence of for loop, the for loop for d should come earlier than the for loop for i
//dp[i][j][k]
//it's better to have i as the starting index in s1, j as the starting index in s2 and k as the length
//O(n^4)

public class Solution {
    public boolean isScramble(String s1, String s2) {
        int l = s1.length();
        boolean[][][] dp = new boolean[l][l+1][l];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][i+1][j] = true;
                }
            }
        }
        for (int d = 2; d <= l; d++) {
            for (int i = 0; i + d <= l; i++) {
                for (int j = 0; j + d <= l; j++) {
                    for (int k = 1; k < d; k++) {
                        if ((dp[i][i+k][j] && dp[i+k][i+d][j+k]) || (dp[i][i+k][j+d-k] && dp[i+k][i+d][j])) {
                            dp[i][i+d][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][l][0];
    }
}
