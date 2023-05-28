package Hot100;

public class SearchMatrix2 {

    /**
     * 暴力方法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < col; j++) {
                int num = ints[j];
                if (num == target) {
                    return true;
                } else if (num > target) {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 二分法，遍历每行元素，在每行中进行二分法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int[] ints : matrix) {
            int start = 0, end = col - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (ints[mid] == target) {
                    return true;
                } else if (ints[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * z字型查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix3(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target = 5;
        SearchMatrix2 searchMatrix2 = new SearchMatrix2();
        System.out.println(searchMatrix2.searchMatrix(matrix, target));
        System.out.println(searchMatrix2.searchMatrix2(matrix, target));
        System.out.println(searchMatrix2.searchMatrix3(matrix, target));
        target = 20;
        System.out.println(searchMatrix2.searchMatrix(matrix, target));
        System.out.println(searchMatrix2.searchMatrix2(matrix, target));
        System.out.println(searchMatrix2.searchMatrix3(matrix, target));

    }
}
