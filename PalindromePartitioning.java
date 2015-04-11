//in the RECURSION function _partition: NEW a new list to add to result. Pass by value!
//another way to generate dp matrix:
/*
        for (int i = size - 1; i >= 0; --i) {
            for (int j = i; j < size; ++j) {
                dp[i][j]=(s[i]==s[j])&&(j<i+2||dp[i+1][j-1]);
            }
        }

*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        populateDP(s, dp);
        _partition(s, 0, list, res, dp);
        return res;
    }
    public void _partition(String s, int index, List<String> list, List<List<String>> res, boolean[][] dp) {
        int len = s.length();
        if (index == len) {
            res.add(new ArrayList<String>(list));
        } else {
            for (int end = index+1; end <= len; end++) {
                if (dp[index][end-1]) {
                    list.add(s.substring(index, end));
                    _partition(s, end, list, res, dp);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    public void populateDP(String s, boolean[][] dp) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len-1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1) ? true : false;
        }
        for (int k = 2; k < len; k++) {
            for (int i = 0; i < len-k; i++) {
                dp[i][i+k] = dp[i+1][i+k-1] && s.charAt(i) == s.charAt(i+k);
            }
        }
    }
}
