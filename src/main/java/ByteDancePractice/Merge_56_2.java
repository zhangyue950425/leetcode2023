package ByteDancePractice;

import java.util.Arrays;
import java.util.LinkedList;

public class Merge_56_2 {

    public int[][] merge(int[][] intervals) {
        int row = intervals.length;
        if (row == 1) {
            return intervals;
        }
        LinkedList<int[]> linkedList = new LinkedList<>();
        Arrays.sort(intervals, (int[] v1, int[] v2) -> v1[0] - v2[0]);
        linkedList.addLast(intervals[0]);
        for (int i = 1; i < row; i++) {
            int[] exist = linkedList.getLast();
            if (exist[1] >= intervals[i][0]) {
                linkedList.removeLast();
                linkedList.addLast(new int[]{Math.min(exist[0], intervals[i][0]), Math.max(exist[1], intervals[i][1])});
            } else {
                linkedList.addLast(intervals[i]);
            }
        }
        int[][] result = new int[linkedList.size()][intervals[0].length];
        int index = 0;
        for (int[] ints : linkedList) {
            result[index++] = ints;
        }
        return result;
    }

    public static void main(String[] args) {
        Merge_56_2 merge_56_2 = new Merge_56_2();
        int[][] intervals = new int[][] {{2,6}, {8,10} ,{1,3}, {15,18}};
        System.out.println(Arrays.deepToString(merge_56_2.merge(intervals)));
    }
}
