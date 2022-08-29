package dp;

public class MaxProfit4 {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if ( i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = - prices[i] - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        MaxProfit4 maxProfit4 = new MaxProfit4();
        System.out.println(maxProfit4.maxProfit(prices, fee));
    }
}
