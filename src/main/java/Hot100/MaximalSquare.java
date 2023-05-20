package Hot100;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix == null || row == 0 || col == 0) {
            return 0;
        }
        // dp[i + 1][j + 1]表示以matrix[i][j]为正方形最右方形成的正方形最大边长
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i < col; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < row; i++) {
            dp[i][0] = 0;
        }
        // 正方形最大边长取决于上，左，左上正方形边长的最小值
        int maxLen = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    /**
     * 有第一行和第一列需要判断的情况
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix == null || row == 0 || col == 0) {
            return 0;
        }
        // 以matrix[i][j]为正方向右下角的正方形最大边长
        int[][] dp = new int[row][col];
        int maxLen = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    // 第一行和第一列需要单独判读处理
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }

            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(matrix));
        System.out.println(maximalSquare.maximalSquare2(matrix));
    }
}
