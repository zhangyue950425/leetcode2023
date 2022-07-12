package leetcodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 406. 根据身高重建队列
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 第一个元素降序排序，第二个元素正序排序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            if (res.size() > person[1]) {
                res.add(person[1], person);
            } else {
                res.add(person);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        ReconstructQueue reconstructQueue = new ReconstructQueue();
        System.out.println(Arrays.deepToString(reconstructQueue.reconstructQueue(people)));
    }
}
