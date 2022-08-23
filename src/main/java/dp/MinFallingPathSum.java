package dp;

import java.util.Arrays;

public class MinFallingPathSum {

    int [][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int result = Integer.MAX_VALUE;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        // 终点可能在 matrix[n-1] 的任意⼀列
        for (int i = 0; i < n; i++) {
            result = Math.min(result, dp(matrix, n - 1, i));
        }
        return result;
    }

    private int dp(int[][] matrix, int i, int j) {
        if ( i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (i == 0) {
            return matrix[0][j];
        }
        if (memo[i][j] != Integer.MAX_VALUE) {
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + Math.min(dp(matrix, i - 1,j), Math.min(dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1)));
        return memo[i][j];
    }

    public static void main(String[] args) {
        // matrix = [[2,1,3],[6,5,4],[7,8,9]]
        int[][] matrix = new int[][]{{2,1,3}, {6,5,4}, {7,8,9}};
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        System.out.println(minFallingPathSum.minFallingPathSum(matrix));
    }
}
