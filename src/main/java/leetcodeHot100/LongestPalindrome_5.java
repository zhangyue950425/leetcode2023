package leetcodeHot100;

public class LongestPalindrome_5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        int start = 0;
        int maxLen = 1;
        char[] chars = s.toCharArray();
        // dp[i][j]表示chars[i]到chars[j]的字符数组是否是回文子串
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                char left = chars[i];
                char right = chars[j];
                if (left != right) {
                    dp[i][j] = false;
                } else {
                    int len = j - i + 1;
                    if (len == 2 || len == 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && len > maxLen) {
                        maxLen = Math.max(maxLen, len);
                        start = i;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            stringBuilder.append(chars[start++]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LongestPalindrome_5 longestPalindrome5 = new LongestPalindrome_5();
        String s = "babad";
        System.out.println(longestPalindrome5.longestPalindrome(s));
        s = "ac";
        System.out.println(longestPalindrome5.longestPalindrome(s));
        s = "ccc";
        System.out.println(longestPalindrome5.longestPalindrome(s));
    }
}
