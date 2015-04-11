//iteration
public class Solution {
    public int candy(int[] ratings) {
        int res = 0;
        int lastCandy = 0;
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i-1]) {
                res += ++lastCandy;
            } else if (i == 0 || ratings[i] == ratings[i-1]) {
                res += 1;
                lastCandy = 1;
            } else {
                int count = 2;
                while (i + 1 < ratings.length && ratings[i+1] < ratings[i]) {
                    count++;
                    i++;
                }
                if (count > lastCandy) {
                    res += count - lastCandy;
                }
                while (--count > 0) {
                    res += count;
                }
                lastCandy = 1;
            }
        }
        return res;
    }
}

//recursion
    int dfs(const vector<int>& ratings, vector<int>& dp, int i)
    {
        if (dp[i] != -1) return dp[i];
        dp[i] = 1;
        if(i > 0  && ratings[i] > ratings[i-1])
            dp[i] = max(dp[i], dfs(ratings, dp, i-1) + 1);
        if(i < ratings.size()-1 && ratings[i] > ratings[i+1])
            dp[i] = max(dp[i], dfs(ratings, dp, i+1) + 1);
        return dp[i];
    }
    int candy_3(vector<int>& ratings)
    {
        vector<int> dp(ratings.size(), -1);
        int res = 0;
        for(int i = 0;i < ratings.size(); ++i)
            res += dfs(ratings, dp, i);
        return res;
    }
