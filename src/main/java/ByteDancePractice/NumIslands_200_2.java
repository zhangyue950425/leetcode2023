package ByteDancePractice;

public class NumIslands_200_2 {

    private static int row = 0;
    private static int col = 0;

    private boolean[][] used;

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        used = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !used[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!indexOfRange(i, j)) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        if (used[i][j]) {
            return;
        }
        used[i][j] = true;
        //grid[i][j] = '2';
        // 上下左右递归
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private boolean indexOfRange(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        NumIslands_200_2 numIslands2002 = new NumIslands_200_2();
        char[][] grid = new char[][] {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands2002.numIslands(grid));
        grid = new char[][] {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands2002.numIslands(grid));
    }
}
