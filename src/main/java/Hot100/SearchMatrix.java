package Hot100;

public class SearchMatrix {

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

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int target = 5;
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix, target));
        target = 20;
        System.out.println(searchMatrix.searchMatrix(matrix, target));
    }
}
