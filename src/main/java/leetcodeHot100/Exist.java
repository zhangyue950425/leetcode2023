package leetcodeHot100;

/**
 * 79. 单词搜索
 */
public class Exist {
    boolean find = false;

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                backtrace(board, word, i, j, 0, visited);
            }
        }
        return find;
    }

    private void backtrace(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || find || visited[i][j] ||
                board[i][j] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1) {
            find = true;
            return;
        }
        visited[i][j] = true;
        backtrace(board, word, i - 1, j, index + 1, visited);
        backtrace(board, word, i, j + 1, index + 1, visited);
        backtrace(board, word, i + 1, j, index + 1, visited);
        backtrace(board, word, i, j - 1, index + 1, visited);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, word));
        word = "ABCB";
        System.out.println(exist.exist(board, word));
    }
}
