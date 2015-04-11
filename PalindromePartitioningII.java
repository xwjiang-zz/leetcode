//use two dynamic programming: 
//isPalindrome is 2D DP and tells which substring is a palindrome: O(n)
//minCuts is only 1D DP: how many cuts needed for a substring ending on a specific position "i"
//there is another more advanced and compact way of coding:
/*
    int minCut(string s) {
        int size = s.size();
        vector<int> dp(size + 1);
        vector<bool> isP(size, true);
        dp[size] = -1;
        for (int i = size -1; i >= 0; --i) {
            dp[i] = dp[i + 1] + 1;
            for (int j = size - 1; j >= i; --j) {
                isP[j] = false;
                if (s[i] == s[j] && ( j - i < 2 || isP[j-1])) {
                    isP[j] = true;
                    dp[i] = min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }
*/
public class Solution {
    public int minCut(String s) {
        int len = s.length();
        int[] minCuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = len-1; i >= 0; i--) {
            for (int j = len-1; j >= i; j--) {
                if (s.charAt(i) == s.charAt(j) && (j < i+2 || isPalindrome[i+1][j-1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (isPalindrome[0][i]) {
                minCuts[i] = 0;
                continue;
            }
            minCuts[i] = Integer.MAX_VALUE;
            for (int k = 0; k < i; k++) {
                if (isPalindrome[k+1][i]) {
                    minCuts[i] = Math.min(minCuts[i], minCuts[k]+1);
                }
            }
        }
        return minCuts[len-1];
    }
}
