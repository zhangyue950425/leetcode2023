package ByteDancePractice;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands_200_3 {

    private int row;
    private int col;


    /**
     * BFS
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                   bfs(i, j, grid);
                   count++;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int x = ints[0], y = ints[1];
            if (indexInRange(x, y)
            && grid[x][y] == '1') {
                grid[x][y] = '2';
                queue.offer(new int[] {x - 1, y});
                queue.offer(new int[] {x + 1, y});
                queue.offer(new int[] {x, y - 1});
                queue.offer(new int[] {x, y + 1});
            }

        }
    }

    private boolean indexInRange(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    public static void main(String[] args) {
        NumIslands_200_3 numIslands_200_3 = new NumIslands_200_3();
        char[][] grid = new char[][] {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands_200_3.numIslands(grid));
        grid = new char[][] {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands_200_3.numIslands(grid));
    }
}
