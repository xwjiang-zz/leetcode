//Manacher's algo: uses linear time! 
//http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html

//my solution
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int a = 0;
        int b = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len-1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i+1; j < len; j++) {
                dp[i][j] = (j == i + 1 || dp[i+1][j-1]) && s.charAt(i) == s.charAt(j);
                if (dp[i][j] && j - i > b - a) {
                    a = i;
                    b = j;
                }
            }
        }
        return s.substring(a, b+1);
    }
}
