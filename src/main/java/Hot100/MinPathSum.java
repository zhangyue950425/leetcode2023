package Hot100;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        // [1,3,1],[1,5,1],[4,2,1]
        int[][] grid = new int[][] {{1,3,1}, {1,5,1}, {4,2,1}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid));
        // [1,2,3],[4,5,6]
        grid = new int[][] {{1,2,3}, {4,5,6}};
        System.out.println(minPathSum.minPathSum(grid));
    }
}