package middle;

import java.util.Arrays;

public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int count = 1;
        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        int[][] result = new int[n][n];
        while (count <= n * n) {
            for (int i = left; i <= right; i++) {
                result[top][i] = count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result[i][right] = count++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                result[bottom][i] = count++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result[i][left] = count++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        GenerateMatrix generateMatrix = new GenerateMatrix();
        System.out.println(Arrays.deepToString(generateMatrix.generateMatrix(n)));
    }
}
