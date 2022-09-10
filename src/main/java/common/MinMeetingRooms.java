package common;

import java.util.Arrays;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        // 扫描过程中的计数器
        int count = 0;
        // 双指针技巧
        int res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (begin[i] < end[j]) {
                // 扫描到⼀个红点
                count++;
                i++;
            } else {
                // 扫描到⼀个绿点
                count--;
                j++;
            }
            // 记录扫描过程中的最⼤值
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        // intervals = [[0,30],[5,10],[15,20]]
        int[][] intervals = new int[][]{{0,30}, {5,10}, {15,20}};
        MinMeetingRooms minMeetingRooms = new MinMeetingRooms();
        System.out.println(minMeetingRooms.minMeetingRooms(intervals));
    }
}
