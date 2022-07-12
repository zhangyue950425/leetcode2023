package array;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int length = s.length();
        //boolean flag = length % 2 == 0;
        String result = "";
        for (int i = 0; i < length; i++) {
            String sub1 = palindrome(s, i, i);
            String sub = palindrome(s, i, i + 1);
            result = result.length() > sub.length() ? result : sub;
            result = result.length() > sub1.length() ? result : sub1;
        }
        return result;
    }

    private String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        //
        String s = "babad";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        /*System.out.println(longestPalindrome.longestPalindrome(s));
        String s2 = "cbbd";
        System.out.println(longestPalindrome.longestPalindrome(s2));*/
        String s3 = "ac";
        System.out.println(longestPalindrome.longestPalindrome(s3));
    }
}
