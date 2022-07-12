package string;

/**
 * 5
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] palidrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            palidrome[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                int j = L + i - 1;
                if (j >= length) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    palidrome[i][j] = false;
                } else {
                    if (j - i < 3) {
                        palidrome[i][j] = true;
                    } else {
                        palidrome[i][j] = palidrome[i + 1][j - 1];
                    }
                }
                if (palidrome[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(s));
        s = "cbbd";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }
}
