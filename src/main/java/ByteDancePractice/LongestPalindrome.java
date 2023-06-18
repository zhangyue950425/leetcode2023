package ByteDancePractice;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int length = s.length();
        int start = 0;
        int maxLen = 1;
        if (length == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        // 在chars[i]到chars[j]之间是否为回文字符串
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            // 单个字符自成回文串
            dp[i][i] = true;
        }
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                char left = chars[i];
                char right = chars[j];
                int len = j - i + 1;
                if (left != right) {
                    dp[i][j] = false;
                } else {
                    if (len == 2 || len == 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    maxLen = Math.max(maxLen, len);
                    start = i;
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
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "babad";
        //System.out.println(longestPalindrome.longestPalindrome(s));
        s = "cbbd";
        //System.out.println(longestPalindrome.longestPalindrome(s));
        s = "aaaa";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }
}
