package Hot100;

import java.util.Arrays;

public class Merge {

    public int[][] merge(int[][] intervals) {
        // 先按照每个区间的起始位置升序排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int index = -1;
        int length = intervals.length;
        int[][] result = new int[length][2];
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > result[index][1]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }
        int[][] res = new int[index + 1][2];
        for (int i = 0; i <= index; i++) {
            res[i] = result[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{8,10},{2,6},{15,18}};
        Merge merge = new Merge();
        System.out.println(Arrays.deepToString(merge.merge(intervals)));
        intervals = new int[][]{{1,4},{4,5}};
        System.out.println(Arrays.deepToString(merge.merge(intervals)));
    }
}
