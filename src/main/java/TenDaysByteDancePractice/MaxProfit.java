package TenDaysByteDancePractice;

/**
 * 121. 买卖股票的最佳时机:
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^4
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        int min = prices[0];
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (min > prices[i]) {
                min = Math.min(min, prices[i]);
                index = i;
            }
        }
        int max = prices[index];
        int maxIndex = index;
        for (int i = index + 1; i < length; i++) {
            if (max < prices[i]) {
                max = Math.max(max, prices[i]);
                maxIndex = i;
            }
        }
        if (prices[maxIndex] - prices[index] > 0) {
            return prices[maxIndex] - prices[index];
        } else {
            return 0;
        }

    }

    /**
     * 暴力枚举，枚举每种可能得交易，先买入才能卖出
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
       int length = prices.length;
       int result = 0;
       for (int i = 0; i < length; i++) {
           for (int j = i + 1; j < length; j++) {
               result = Math.max(result, prices[j] - prices[i]);
           }
       }
       return result;
    }

    /**
     * 动态规划:二维数组
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int length = prices.length;
        // dp[i][0]:表示今天最大利润，是在今天不持有股票的情况下，则昨天的情况有两种：
        // 一是昨天获得最大利润的时候是在持有股票但是今天卖出，二是昨天也不持有股票所以今天啥都没做
        // dp[i][1]:表示今天最大利润，是在今天持有股票的情况下：
        // 则昨天的情况有两种，一是昨天获得最大利润的时候是在没有股票，今天买入股票，因为只能交易一次，所以今天买入的话只能从今天算起来利润，
        // 二是昨天持有股票今天啥都没做
        int[][] dp = new int[length][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(- prices[i], dp[i - 1][1]);
        }
        return Math.max(dp[length - 1][1], dp[length - 1][0]);
    }

    /**
     * 动态规划优化，空间优化，一维数组
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        int length = prices.length;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], - prices[i]);
        }
        return Math.max(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        // 输入：[7,1,5,3,6,4]
        // 输出：5
        // 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
        // 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
        // 输入：prices = [7,6,4,3,1]
        // 输出：0
        // 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
        int[] prices = new int[] {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit2(prices));
        System.out.println(maxProfit.maxProfit3(prices));
        System.out.println(maxProfit.maxProfit4(prices));
        //System.out.println(maxProfit.maxProfit(prices));
        prices = new int[] {7,6,4,3,1};
        System.out.println(maxProfit.maxProfit2(prices));
        System.out.println(maxProfit.maxProfit3(prices));
        System.out.println(maxProfit.maxProfit4(prices));
        //System.out.println(maxProfit.maxProfit(prices));
        prices = new int[] {2,4,1};
        System.out.println(maxProfit.maxProfit2(prices));
        System.out.println(maxProfit.maxProfit3(prices));
        System.out.println(maxProfit.maxProfit4(prices));
        //System.out.println(maxProfit.maxProfit(prices));
    }
}
