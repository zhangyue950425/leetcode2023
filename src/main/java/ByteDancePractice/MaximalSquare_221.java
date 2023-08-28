package ByteDancePractice;

public class MaximalSquare_221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (row < 1 || col < 1) {
            return 0;
        }
        // dp[i][j]为matrix[i - 1][j - 1]为正方形最右下角的正方形最大边长
        int[][] dp = new int[row + 1][col + 1];
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        MaximalSquare_221 maximalSquare_221 = new MaximalSquare_221();
        char[][] matrix = new char[][] {{'1','0','1','0','0'},
                {'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare_221.maximalSquare(matrix));
    }
}
