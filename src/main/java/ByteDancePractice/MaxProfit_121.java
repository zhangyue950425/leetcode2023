package ByteDancePractice;

public class MaxProfit_121 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        // dp[i][0]第i天不持有股票的最大利润，dp[i][1]第i天持有股票的最大利润
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[length - 1][0];
    }

    /**
     * 暴力方法
     *  循环每一天计算，该天买入后以后每一天卖出的利润，比较最大值
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        int result = 0;
        if (length == 1) {
            return result;
        }
        // 第i天买入，第j天卖出
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                result = Math.max(result, -prices[i] + prices[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxProfit_121 maxProfit121 = new MaxProfit_121();
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit121.maxProfit(prices));
        System.out.println(maxProfit121.maxProfit2(prices));
        prices = new int[] {7,6,4,3,1};
        System.out.println(maxProfit121.maxProfit(prices));
        System.out.println(maxProfit121.maxProfit2(prices));
    }
}
