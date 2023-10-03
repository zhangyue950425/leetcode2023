package leetcodeHot100;

public class LongestPalindrome_05 {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        // chars[i]到chars[j]是否是回文子串
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                int len = j - i + 1;
                char c1 = chars[i];
                char c2 = chars[j];
                if (c1 != c2) {
                    dp[i][j] = false;
                } else {
                    if (len == 2 || len == 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
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
        LongestPalindrome_05 longestPalindrome05 = new LongestPalindrome_05();
        String s = "babad";
        System.out.println(longestPalindrome05.longestPalindrome(s));
        s = "cbbd";
        System.out.println(longestPalindrome05.longestPalindrome(s));
    }
}
