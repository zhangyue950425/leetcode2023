package offer;

public class FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int tmp = col;
        boolean result = false;
        for (int i = 0; i < row; i++) {
            if (result) {
                break;
            }
            if (matrix[i][col - 1] < target) {
                continue;
            }
            for (int j = 0; j < tmp; j++) {
                if (matrix[i][j] == target) {
                    result = true;
                    break;
                }
                if (matrix[i][j] > target) {
                    tmp = j;
                } else {
                    tmp = col;
                }
            }
        }
        return result;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int c = 0, r = row - 1;
        while (r >= 0 && c < col) {
            int num = matrix[r][c];
            if (num == target) {
                return true;
            } else if (target > num) {
                c++;
            } else {
                r--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 5;
        System.out.println(FindNumberIn2DArray.findNumberIn2DArray(matrix, target));
        System.out.println(FindNumberIn2DArray.findNumberIn2DArray2(matrix, target));
        target = 20;
        System.out.println(FindNumberIn2DArray.findNumberIn2DArray(matrix, target));
        System.out.println(FindNumberIn2DArray.findNumberIn2DArray2(matrix, target));
    }
}
