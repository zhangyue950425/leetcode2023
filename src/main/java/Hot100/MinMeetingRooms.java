package Hot100;

import java.util.*;

public class MinMeetingRooms {

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return o1 - o2;
            }
        });
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        priorityQueue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int val = intervals[i][0];
            if (val < priorityQueue.peek()) {
                priorityQueue.offer(intervals[i][1]);
            } else {
                priorityQueue.poll();
                priorityQueue.offer(intervals[i][1]);
            }
        }
        return priorityQueue.size();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30}, {5, 10}, {15,20}};
        MinMeetingRooms minMeetingRooms = new MinMeetingRooms();
        System.out.println(minMeetingRooms.minMeetingRooms(intervals));
    }
}
