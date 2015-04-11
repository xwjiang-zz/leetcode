public class Solution {
    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return (s.length() == 0); 
        }   
        if (p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }   
        if (p.charAt(1) != '*') {
            return s.length() >= 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')  &&  
                isMatch(s.substring(1), p.substring(1)); 
        }   
        if (p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }   
            int i = 0;
            while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }   
                i++;
            }   
            return false;
        }   
        return false;
    }
}

//3/21/2015
//complexity analysis: the above solution has a exponential complexity
//a better solution is O(n2)
public class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        boolean[] dp = new boolean[lens+1];
        dp[0] = true;
        for (int i = 0; i < lenp; i++) {
            if (i+1 == lenp || (i+1 < lenp && p.charAt(i+1) != '*')) {
                for (int j = lens-1; j >= 0; j--) {
                    if (dp[j] && (s.charAt(j) == p.charAt(i) || p.charAt(i) == '.')) {
                        dp[j+1] = true;
                    } else {
                        dp[j+1] = false;
                    }
                }
                dp[0] = false;
            } else {
                for (int j = lens-1; j >= 0; j--) {
                    if (dp[j]) {
                        for (int k = j; k < lens; k++) {
                            if (s.charAt(k) == p.charAt(i) || p.charAt(i) == '.') {
                                dp[k+1] = true;
                            } else {
                                break;
                            }
                        }
                    }
                }
                i++;
            }
        }
        return dp[lens];
    }
}
