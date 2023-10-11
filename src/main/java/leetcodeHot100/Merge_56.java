package leetcodeHot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int row = intervals.length;
        for (int i = 0; i < row; i++) {
            int[] ints = intervals[i];
            if (priorityQueue.isEmpty()) {
                priorityQueue.offer(ints);
            } else {
                int[] compare = priorityQueue.peek();
                if (compare[1] >= ints[0]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{Math.min(ints[0], compare[0]), Math.max(ints[1], compare[1])});
                } else {
                    priorityQueue.offer(ints);
                }
            }
        }
        int[][] result = new int[priorityQueue.size()][2];
        int index = 0;
        if (!priorityQueue.isEmpty()) {
            while (!priorityQueue.isEmpty()) {
                int[] array = priorityQueue.poll();
                result[index][0] = array[0];
                result[index][1] = array[1];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Merge_56 merge56 = new Merge_56();
        int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge56.merge(intervals)));
        intervals = new int[][] {{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(merge56.merge(intervals)));
    }
}
