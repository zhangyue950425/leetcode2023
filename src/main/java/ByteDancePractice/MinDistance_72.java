package ByteDancePractice;

public class MinDistance_72 {

    /**
     * 动态规划
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        if (length1 == 0 && length2 == 0) {
            return 0;
        }
        // dp[i][j]表示word1单词到第i位置的单词转化为word2到第j位置的单词的最少操作数
        int[][] dp = new int[length1 + 1][length2 + 1];
        dp[0][0] = 0;
        // 初始化，word1和word2分别为空的情况，word1为空要转化为word2的话全部是插入字符
        // word2为空的话，word1要转化为word2的话 全部是删除字符
        for (int i = 1; i <= length2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        // 开始从第一个位置开始计算
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 分别使用增加，删除，替换，次数操作最少的那个操作
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[length1][length2];

    }

    public static void main(String[] args) {
        MinDistance_72 minDistance72 = new MinDistance_72();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance72.minDistance(word1, word2));
    }
}
