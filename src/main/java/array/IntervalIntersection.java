package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        /*int[][] result = new int[][]{};
        if (firstList.length == 0 || secondList.length == 0) {
            return result;
        }
        int firstRow = firstList.length, firstCol = firstList[0].length,
                secondRow = secondList.length, secondCol = secondList[0].length;
        for (int[] fir : firstList) {
            int firRow = fir[0], firCol = fir[1];
            for (int[] sec : secondList) {
                int secRow = sec[0], secCol = sec[1];
                if (firRow <= secondRow && firCol <= secCol) {

                }
            }
        }*/
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left <= right) {
                result.add(new int[]{left, right});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}},
                secondList = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        IntervalIntersection intervalIntersection = new IntervalIntersection();
        System.out.println(Arrays.deepToString(intervalIntersection.intervalIntersection(firstList, secondList)));
    }
}
