package leetcodeHot100;

import java.util.Arrays;

/**
 * 旋转图像:
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * 水平翻转+对角线翻转
 */
public class Rotate {

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 水平
        for (int i = 0; i < row / 2; i++) {
            for (int j = 0; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = tmp;
            }
        }
        // 对角线
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Rotate rotate = new Rotate();
        rotate.rotate(nums);
        System.out.println(Arrays.deepToString(nums));
    }


}
