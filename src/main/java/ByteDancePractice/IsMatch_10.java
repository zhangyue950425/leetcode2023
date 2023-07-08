package ByteDancePractice;

public class IsMatch_10 {

    /**
     * 动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] ps = p.toCharArray();
        int sLength = s.length();
        int pLength = p.length();
        // dp[i][j] 表示 s 字符串的前 i 个字符和 p字符串的前 j 个字符是否匹配
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        // 初始值,s和p都是空串
        dp[0][0] = true;
        // p为空串，s不为空串的话必定是不匹配，不用单独设置，直接使用数组的默认值
        // s为空串，p不为空串的时候有可能匹配，如果是*可以匹配0个字符,如果不是*的话就是不匹配
        for (int i = 1; i < pLength ; i++) {
            // 求dp[0][j]的值，如果p的第j-1个字符是*的话，可以匹配0个前面的字符，连同j-2的位置抵消，则dp[0][j]=dp[0][j - 2]
            // 如果p的第j-1个字符不是*的话，则不匹配，直接使用默认值
            if (ps[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                // 文本串和模式串末位字符能匹配上
                if (sc[i - 1] == ps[j - 1] || ps[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 末尾字符匹配不上
                    // 但是p字符串的末尾是*
                    if (ps[j - 1] == '*') {
                        // 模式串*的前一个字符能够跟文本串的末位匹配上
                        if (ps[j - 2] == sc[i - 1] || ps[j - 2] == '.') {
                            // *用来匹配0，1，2次以及2次以上
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                        } else {
                            // 模式串*的前一个字符和文本串的末位匹配不上,只能匹配0次
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }

    public static void main(String[] args) {
        IsMatch_10 isMatch10 = new IsMatch_10();
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch10.isMatch(s, p));
        s = "aa";
        p = "a";
        System.out.println(isMatch10.isMatch(s, p));
        s = "ab";
        p = ".*";
        System.out.println(isMatch10.isMatch(s, p));
    }
}
