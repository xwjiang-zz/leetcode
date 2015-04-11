public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows];
        for (int i = 0; i < rows; i++) {
            dp[i] = triangle.get(rows-1).get(i);
        }
        for (int j = rows-2; j >= 0; j--) {
            for (int i = 0; i <= j; i++) {
                dp[i] = Math.min(dp[i], dp[i+1]) + triangle.get(j).get(i);
            }
        }
        return dp[0];
    }
}
