package TenDaysByteDancePractice;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (matrix == null || row == 0) {
            return result;
        }
        int col = matrix[0].length;
        int count = row * col;
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (count >= 1) {
            // 从左到右移动
            for (int i = left; i <= right && count >= 1; i++) {
                result.add(matrix[top][i]);
                count--;
            }
            top++;
            // 从上到下移动
            for (int i = top; i <= bottom && count >= 1; i++) {
                result.add(matrix[i][right]);
                count--;
            }
            right--;
            // 从右到左移动
            for (int i = right; i >= left && count >= 1; i--) {
                result.add(matrix[bottom][i]);
                count--;
            }
            bottom--;
            // 从下到上移动
            for (int i = bottom; i >= top && count >= 1; i--) {
                result.add(matrix[i][left]);
                count--;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.spiralOrder(matrix));
    }


}
