package offer;

public class Exist {
    public boolean exist(char[][] board, String word) {
        /*if (board.length == 0 || word.length() == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        int index = 0;
        for (int i = 0, j = 0; i < row && j < col;) {
            if (board[i][j] == word.charAt(index)) {
                index++;
                if (board[i][j + 1] == word.charAt(index)) {
                    j++;
                }
                if (board[i + 1][j] == word.charAt(index)) {
                    i++;
                }
            } else {

            }
        }*/
        if (board.length == 0 || word.length() == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        char[] words = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[index]) {
            return false;
        }
        if (index == words.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, words, i - 1, j, index + 1) ||
                dfs(board, words, i + 1, j, index + 1) ||
                dfs(board, words, i, j - 1, index + 1) ||
                dfs(board, words, i, j + 1, index + 1);
        board[i][j] = words[index];
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S' ,'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String words = "ABCCED";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, words));
    }
}
