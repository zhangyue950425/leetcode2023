package Hot100;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];
        // 初始化,任何金额为0的只需要0个硬币
        for (int i = 0; i <= length; i++) {
            Arrays.fill(dp[i], amount + 1);
            dp[i][0] = 0;
        }
        // 循环每个金额
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= length; j++) {
                int curCoin = coins[j - 1];
                if (i >= curCoin) {
                    dp[j][i] = Math.min(dp[j - 1][i], dp[j][i - curCoin] + 1);
                } else {
                    // 不用当前硬币
                    dp[j][i] = dp[j - 1][i];
                }
            }
        }
        return dp[length][amount] == amount + 1 ? -1 : dp[length][amount];
    }

    /**
     * 动态规划：一维数组
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int length = coins.length;
        // 表示为了凑金额为Amount需要最少多少硬币
        int[] dp = new int[amount + 1];
        // 先初始化不可能的值表示凑不出
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, amount));
        //System.out.println(coinChange.coinChange2(coins, amount));
    }
}
