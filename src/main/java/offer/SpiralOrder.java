package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        int[] result = new int[]{};
        int row = matrix.length;
        if (row == 0) {
            return  result;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return result;
        }
        if (row == 1) {
            result = Arrays.copyOf(matrix[0], col);
            return result;
        }
        if (col == 1) {
            result = new int[row];
            for (int i = 0; i < row; i++) {
                result[i] = matrix[i][0];
            }
            return result;
        }
        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;
        result = new int[row * col];
        int index = 0;
        while (true) {
            // 左 -> 右
            for (int i = l; i <= r; i++) {
                result[index++] = matrix[t][i];
            }
            if (++t > b) break;
            // 上 -> 下
            for (int i = t; i <= b; i++) {
                result[index++] = matrix[i][r];
            }
            if (l > --r) break;
            // 右 -> 左
            for (int i = r; i >= l; i--) {
                result[index++] = matrix[b][i];
            }
            if (t > --b) break;
            // 下 -> 上
            for (int i = b; i >= t; i--) {
                result[index++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return result;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return result;
        }
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }
        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1;
        while (true) {
            // 左 -> 右
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            if (++t > b) break;
            // 上 -> 下
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            if (l > --r) break;
            // 右 -> 左
            for (int i = r; i >= l; i--) {
                result.add(matrix[b][i]);
            }
            if (t > --b) break;
            // 下 -> 上
            for (int i = b; i >= t; i--) {
                result.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(matrix)));
        System.out.println(spiralOrder.spiralOrder2(matrix));
        matrix = new int[][]{{3}, {2}};
        System.out.println(Arrays.toString(spiralOrder.spiralOrder(matrix)));
        System.out.println(spiralOrder.spiralOrder2(matrix));
    }
}
