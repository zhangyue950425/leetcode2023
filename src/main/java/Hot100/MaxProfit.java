package Hot100;

/**
 * 309. 最佳买卖股票时机含冷冻期:
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * 输入: prices = [1]
 * 输出: 0
 *
 * 提示：
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        int[][] dp = new int[length][3];
        // dp[i][0]手上不持有股票，并且今天不是由于卖出股票而不持股，我们拥有的现金数
        // dp[i][1]手上持有股票时，我们拥有的现金数
        // dp[i][2]手上不持有股票，并且今天是由于卖出股票而不持股，我们拥有的现金数
        dp[0][0] = 0;
        dp[0][2] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            // 今天的0可以由昨天的0和2转化而来
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 今天的1可以昨天的1和0转化而来
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 今天的2可以由1转化而来
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[length - 1][0], dp[length - 1][2]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(prices));
    }
}
