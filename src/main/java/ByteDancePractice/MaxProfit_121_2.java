package ByteDancePractice;

public class MaxProfit_121_2 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        int maxProfit = 0;
        // dp[i][0]表示第i天没有持有股票的最大利润，dp[i][1]表示第i天持有股票的最大利润
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
            maxProfit = Math.max(maxProfit, dp[i][0]);
        }
        return maxProfit;

    }

    public int maxProfit2(int[] prices) {
        int length = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        MaxProfit_121_2 maxProfit_121_2 = new MaxProfit_121_2();
        int[] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit_121_2.maxProfit(prices));
        System.out.println(maxProfit_121_2.maxProfit2(prices));
        prices = new int[] {7,6,4,3,1};
        System.out.println(maxProfit_121_2.maxProfit(prices));
        System.out.println(maxProfit_121_2.maxProfit2(prices));
    }
}
