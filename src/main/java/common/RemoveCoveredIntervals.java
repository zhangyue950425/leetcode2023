package common;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        // 按照起点升序排列，起点相同时降序排列
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        // 记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = intervals[i];
            // 情况⼀，找到覆盖区间
            if (left <= ints[0] && right >= ints[1]) {
                res++;
            }
            // 找到相交区间，合并
            if (right <= ints[1] && right >= ints[0]) {
                right = ints[1];
            }
            // 完全不相交，更新起点和终点
            if (right < ints[0]) {
                left = ints[0];
                right = ints[1];
            }
        }
        return intervals.length - res;
    }

    public static void main(String[] args) {
        // intervals = [[1,4],[3,6],[2,8]]
        int[][] intervals = new int[][]{{1,4}, {3,6}, {2,8}};
        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        System.out.println(removeCoveredIntervals.removeCoveredIntervals(intervals));
    }
}
