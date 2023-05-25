package Hot100;

public class Exist {

    /**
     * 匹配的四个方向，上右下左
     */
    private static final int[][] DIRECTIONS = new int[][]{{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    private int row;
    private int col;
    // 是否已经给访问过
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;
    private int length;
    public boolean exist(char[][] board, String word) {
        row = board.length;
        if (row == 0) {
            return false;
        }
        col = board[0].length;
        visited = new boolean[row][col];
        this.length = word.length();
        this.charArray = word.toCharArray();
        this.board = board;
        // 从二维数组的第一个元素开始匹配，搜索完无法匹配的话，换到第二个元素开始
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 从(i,j)位置匹配，从word下标第0个元素开始匹配
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        // 以所有元素作为第一个元素开始匹配都没有结果说明无法匹配
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if (index == length - 1) {
            return board[i][j] == charArray[index];
        }
        if (board[i][j] == charArray[index]) {
            visited[i][j] = true;
            for (int[] dir : DIRECTIONS) {
                int newI = i + dir[0];
                int newJ = j + dir[1];
                if (inArea(newI, newJ) && !visited[newI][newJ]) {
                    if (dfs(newI, newJ, index + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, word));
        word = "SEE";
        System.out.println(exist.exist(board, word));
        word = "ABCB";
        System.out.println(exist.exist(board, word));
    }
}
