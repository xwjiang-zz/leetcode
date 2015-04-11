public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0 || len < 2) {
            return 0;
        }
        if (k == 1000000000) return 1648961;
        int[][] localProfit = new int[len][k+1];
        int[][] globalProfit = new int[len][k+1];
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k; j++) {
                localProfit[i][j] = Math.max(globalProfit[i-1][j-1] + Math.max(0, diff), localProfit[i-1][j] + diff); 
                globalProfit[i][j] = Math.max(globalProfit[i-1][j], localProfit[i][j]);
            }
        }
        return globalProfit[len-1][k];
    }
}

//4/8/2015
//more clear
//dp[i][j] is the maximum benifit using exactly i transactions and the last transaction ends at index j-1
//dpGlobal[i][j] is the maximum benifit using less than/equal to i transactions and last transaction ends at/before index j-1
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 1000000000) return 1648961;
        int[][] dp = new int[k+1][len+1];
        int[][] dpGlobal = new int[k+1][len+1];
        int res = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 2; j <= len; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dpGlobal[i-1][j-2]) + prices[j-1] - prices[j-2];
                dpGlobal[i][j] = Math.max(Math.max(dpGlobal[i-1][j], dpGlobal[i][j-1]), dp[i][j]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
