public class Solution {
  public static boolean isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();
    boolean[] res = new boolean[m+1];
    res[0] = true;
    for (int i = 1; i < m + 1; i++) {
      res[i] = false;
    }
    for (int j = 1; j < n + 1; j++) {
      res[0] = res[0] && p.charAt(j-1) == '*';
      for (int i = m; i >= 1; i--) {
        if (p.charAt(j-1) != '*') {
          res[i] = res[i-1] && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?');
        } else {
          res[i] = false;
          for (int k = 0; k < i; k++) {
            if (res[k]) {
              res[i] = true;
              break;
            }
          }
        }
      }
    }
    return res[m];
  }
}

//2nd time: 12/14/2014

//TLE error!!!
//need to use Dynamic programming
//"bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba"
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            dp[i] = false;
        }
        for (int j = 0; j < p.length(); j++) {
           if (p.charAt(j) != '*') {
               for (int i = s.length(); i > 0; i--) {
                   dp[i] = dp[i-1] && (s.charAt(i-1) == p.charAt(j) || p.charAt(j) == '?');
               }
               dp[0] = false;
           } else {
               boolean checker = false;
               for (int i = 0; i <= s.length(); i++) {
                   if (dp[i]) {
                       checker = true;
                   }
                   if (checker) {
                       dp[i] = true;
                   }
               }
           }
        }
        return dp[s.length()];
    }
}

//1/26/2015
//the above solution will still get TLE error with the case s = "a....a" p = "*a...a*"
//need to add the logic to calculate the non'*' characters in p and if it's larger than the length of s, then false


//3/24/2015
//simpler and concise
public class Solution {
    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        boolean[] dp = new boolean[lens+1];
        dp[0] = true;
        for (int i = 0; i < lenp; i++) {
            char c = p.charAt(i);
            if (c != '*') {
                for (int j = lens-1; j >= 0; j--) {
                    if (dp[j] && (c == '?' || c == s.charAt(j))) {
                        dp[j+1] = true;
                    } else {
                        dp[j+1] = false;
                    }
                }
                dp[0] = false;
            } else {
                int j = 0;
                while (j <= lens && !dp[j]) {
                    j++;
                }
                while (j <= lens) {
                    dp[j++] = true;
                }
            }
        }
        return dp[lens];
    }
}

