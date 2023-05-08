package Hot100;

public class LongestPalindrome {

    /**
     * 暴力枚举法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int start = 0;
        int max = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - i + 1;
                boolean flag = isPalindrome(chars, i, j);
                // i 到 j 之间的字符是回文串，并且比当前的最长长度要长需要记录最大值
                if (len > max && flag) {
                    max = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        // 从 i 到 j 之间的字符是否是回文
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int start = 0;
        char[] chars = s.toCharArray();
        for (int right = 1; right < length; right++) {
            for (int left = 0; left < right; left++) {
                if (chars[left] != chars[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left + 1 < 4) {
                        dp[left][right] = true;
                    } else {
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = Math.max(maxLen, right - left + 1);
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        // s = "babad"
        // s = "cbbd"
        String s = "babad";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        //System.out.println(longestPalindrome.longestPalindrome(s));
        //System.out.println(longestPalindrome.longestPalindrome2(s));
        s = "cbbd";
        //System.out.println(longestPalindrome.longestPalindrome(s));
        //System.out.println(longestPalindrome.longestPalindrome2(s));
        s = "ac";
        //System.out.println(longestPalindrome.longestPalindrome2(s));
        s = "ccc";
        System.out.println(longestPalindrome.longestPalindrome2(s));

    }
}
