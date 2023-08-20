package ByteDancePractice;

public class LongestPalindrome_5 {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        // dp[i][j]表示s[i,j]是否是回文子串
        boolean[][] dp = new boolean[length][length];
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                int len = j - i + 1;
                int char1 = chars[i];
                int char2 = chars[j];
                if (len == 2 || len == 3) {
                    if (char1 == char2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (char1 == char2) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    start = i;
                    maxLen = len;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            stringBuilder.append(chars[i + start]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LongestPalindrome_5 longestPalindrome_5 = new LongestPalindrome_5();
        String s = "babad";
        System.out.println(longestPalindrome_5.longestPalindrome(s));
        s = "cbbd";
        System.out.println(longestPalindrome_5.longestPalindrome(s));
        s = "a";
        System.out.println(longestPalindrome_5.longestPalindrome(s));
        s = "bb";
        System.out.println(longestPalindrome_5.longestPalindrome(s));
        s = "aaaa";
        System.out.println(longestPalindrome_5.longestPalindrome(s));
    }
}
