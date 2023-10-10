package leetcodeHot100;

public class NumIslands_200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, row, col, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int row, int col, char[][] grid) {
        if (outOfRange(i, j, row, col)) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(i - 1, j, row, col, grid);
        dfs(i + 1, j, row, col, grid);
        dfs(i, j - 1, row, col, grid);
        dfs(i, j + 1, row, col, grid);

    }

    private boolean outOfRange(int i, int j, int row, int col) {
        return (i < 0 || i >= row) || (j < 0 || j >= col);
    }

    public static void main(String[] args) {
        NumIslands_200 numIslands200 = new NumIslands_200();
        char[][] grid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands200.numIslands(grid));
        grid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands200.numIslands(grid));
    }
}
