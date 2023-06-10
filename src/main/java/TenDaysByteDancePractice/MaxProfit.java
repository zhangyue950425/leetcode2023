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
        //System.out.println(maxProfit.maxProfit(prices));
        prices = new int[] {7,6,4,3,1};
        System.out.println(maxProfit.maxProfit2(prices));
        //System.out.println(maxProfit.maxProfit(prices));
        prices = new int[] {2,4,1};
        System.out.println(maxProfit.maxProfit2(prices));
        //System.out.println(maxProfit.maxProfit(prices));
    }
}
