package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o2[0] != o1[0]) {
                return o2[0] - o1[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }
        int[][] result = new int[people.length][people[0].length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] people = new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        ReconstructQueue reconstructQueue = new ReconstructQueue();
        System.out.println(Arrays.deepToString(reconstructQueue.reconstructQueue(people)));
    }
}
