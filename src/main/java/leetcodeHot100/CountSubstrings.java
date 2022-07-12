package leetcodeHot100;

/**
 * 647.回文子串
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        boolean[][] result = new boolean[s.length()][s.length()];
        int count = 0;
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || result[i + 1][j - 1])) {
                    result[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        CountSubstrings countSubstrings = new CountSubstrings();
        //System.out.println(countSubstrings.countSubstrings(s));
        s = "ababa";
        System.out.println(countSubstrings.countSubstrings(s));
    }
}
