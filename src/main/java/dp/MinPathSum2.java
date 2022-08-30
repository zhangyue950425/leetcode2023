package dp;

import java.util.Arrays;

public class MinPathSum2 {

    int[][] memo;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, m - 1, n - 1);
    }

    /**
     * 从grip[0][0]位置开始，走到grip[i][j]最短路径和
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // 索引越界
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = Math.min(dp(grid, i, j - 1), dp(grid, i - 1, j)) + grid[i][j];
        return memo[i][j];
    }

    public static void main(String[] args) {
        // grid = [[1,3,1],[1,5,1],[4,2,1]]
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        MinPathSum2 minPathSum = new MinPathSum2();
        System.out.println(minPathSum.minPathSum(grid));
    }
}
