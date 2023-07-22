package ByteDancePractice;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        if (row == 1 && col == 1) {
            result.add(matrix[0][0]);
            return result;
        }
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralOrder_54 spiralOrder54 = new SpiralOrder_54();
        int[][] matrix = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder54.spiralOrder(matrix));
        matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder54.spiralOrder(matrix));
    }
}
