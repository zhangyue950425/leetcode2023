package ByteDancePractice;

import java.util.Arrays;

public class Merge_56 {

    public int[][] merge(int[][] intervals) {
        int row = intervals.length;
        int col = intervals[0].length;
        // 先排序,每行数据的第一位数值升序排列
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] temp = new int[row][col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            if (i == 0) {
                temp[i] = intervals[i];
            } else {
                int start = intervals[i][0];
                // 合并
                if (temp[index][1] >= start) {
                    temp[index] = new int[]{temp[index][0], Math.max(intervals[i][1], temp[index][1])};
                } else {
                    temp[++index] = intervals[i];
                }
            }
        }
        int[][] result = new int[index + 1][col];
        for (int i = 0; i <= index; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Merge_56 merge56 = new Merge_56();
        int[][] intervals = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        System.out.println(Arrays.deepToString(merge56.merge(intervals)));
        intervals = new int[][]{{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(merge56.merge(intervals)));
        intervals = new int[][] {{1,4},{2,3}};
        System.out.println(Arrays.deepToString(merge56.merge(intervals)));
    }
}
