package Hot100;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
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
        int[][] matrix = new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 3;
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix, target));
        target = 13;
        System.out.println(searchMatrix.searchMatrix(matrix, target));
    }
}
