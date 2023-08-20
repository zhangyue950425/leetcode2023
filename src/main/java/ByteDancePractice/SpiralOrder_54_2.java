package ByteDancePractice;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54_2 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int count = 0;
        while (count < m * n) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                count++;
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                count++;
            }
            right--;
            if (right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
                count++;
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
                count++;
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder_54_2 spiralOrder_54_2 = new SpiralOrder_54_2();
        int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder_54_2.spiralOrder(matrix));
        matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder_54_2.spiralOrder(matrix));
    }
}
