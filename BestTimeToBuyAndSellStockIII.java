public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        int[] maxProfitLeft = new int[len];
        int[] maxProfitRight = new int[len];
        int maxProfit = 0;
        int min = prices[0];
        for (int i = 0; i < len; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-min);
            maxProfitLeft[i] = maxProfit;
        }
        int max = prices[len-1];
        maxProfit = 0;
        for (int i = len-1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max-prices[i]);
            maxProfitRight[i] = maxProfit;
        }
        maxProfit = 0;
        for (int i = 0; i < len; i++) {
            maxProfit = Math.max(maxProfit, maxProfitLeft[i] + maxProfitRight[i]);
        }
        return maxProfit;
    }
}
