package offer;

public class MaxValue {

    public static int maxValue(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0 && j != 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (i != 0 && j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grip = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(maxValue(grip));
    }
}
