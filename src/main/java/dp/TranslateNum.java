package dp;

public class TranslateNum {
    public static int translateNum(int num) {
        // 12258
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int j = Integer.parseInt(s.substring(i - 2, i));
            if (j >= 10 && j <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        int num = 12258;
        System.out.println(translateNum(num));
    }
}
