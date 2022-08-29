package dp;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
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
        return Math.min(dp(grid, i, j - 1), dp(grid, i - 1, j)) + grid[i][j];
    }

    public static void main(String[] args) {
        // grid = [[1,3,1],[1,5,1],[4,2,1]]
        int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        MinPathSum minPathSum = new MinPathSum();
        System.out.println(minPathSum.minPathSum(grid));
    }
}
