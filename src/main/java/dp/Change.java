package dp;

public class Change {
    public int change(int amount, int[] coins) {
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        Change change = new Change();
        System.out.println(change.change(amount, coins));
    }
}
