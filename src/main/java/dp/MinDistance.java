package dp;

import java.util.Arrays;

public class MinDistance {

    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // 备忘录初始化为特殊值，代表还未计算
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        // i，j 初始化指向最后⼀个索引
        return dp(word1, word2, m - 1, n - 1);
    }

    /**
     * 返回 s1[0..i] 和 s2[0..j] 的最⼩编辑距离
     * @param word1
     * @param word2
     * @param i
     * @param j
     * @return
     */
    private int dp(String word1, String word2, int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        // 查备忘录，避免重叠⼦问题
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            // 啥都不做
            memo[i][j] = dp(word1, word2, i - 1,j - 1);
        } else {
            memo[i][j] = Math.min(dp(word1, word2, i, j - 1) + 1,
                    Math.min(dp(word1, word2, i - 1, j) + 1,
                            dp(word1, word2, i - 1, j - 1) + 1));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        // word1 = "horse", word2 = "ros"
        String word1 = "horse";
        String word2 = "ros";
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance(word1, word2));
    }
}
