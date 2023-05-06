package offer;

public class NumWays {
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 2;
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(n));
        n = 7;
        System.out.println(numWays.numWays(n));
        n = 0;
        System.out.println(numWays.numWays(n));
    }
}
