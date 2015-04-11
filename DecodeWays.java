//set initial condition in such a way that the rest of the code can be uniform
public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int last2 = 0;
        int last1 = 1;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (last1 == 0 && last2 == 0) {
                return 0;
            }
            if (s.charAt(i) != '0') {
                current += last1;
            }
            int code = 0;
            if (i >= 1) {
                code = Integer.parseInt(s.substring(i-1, i+1));
            }
            if (code >= 10 && code <= 26) {
                current += last2;
            }
            last2 = last1;
            last1 = current;
            current = 0;
        }
        return last1;
    }
}

//4/4/2014
//don't need 4 cases, only use two parallel cases
//simple logic
public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            char c1 = s.charAt(i-2);
            char c2 = s.charAt(i-1);
            int num = 10*(c1 - '0') + (c2 - '0');
            if (c2 > '0') {
                dp[i] += dp[i-1];
            }
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}
