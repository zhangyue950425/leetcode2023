package Hot100;

import java.util.Arrays;

public class Rotate {

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        /*for (int i = 0; i < row; i++) {
            int tmp = matrix[i][row - i - 1];
            matrix[i][row - i - 1] = matrix[row - i - 1][row - i - 1];
            matrix[row - i - 1][row - i - 1] = tmp;
            tmp = matrix[i][i];
            matrix[i][i] = matrix[i][row - i - 1];
            matrix[i][row - i - 1] = tmp;
        }*/
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < (col + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - j - 1][i];
                matrix[row - j - 1][i] = matrix[row - i - 1][col - j - 1];
                matrix[row - i - 1][col - j - 1] = matrix[j][col - i - 1];
                matrix[j][col - i - 1] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        // 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        // 输出：[[7,4,1],[8,5,2],[9,6,3]]
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        // 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        // 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        Rotate rotate = new Rotate();
        rotate.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        rotate.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
