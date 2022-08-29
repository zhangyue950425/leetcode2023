package dp;

public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = - prices[i];
                continue;
            }
            if (i - 2 == -1) {
                dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
                dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return dp[length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        MaxProfit3 maxProfit3 = new MaxProfit3();
        System.out.println(maxProfit3.maxProfit(prices));
    }
}
