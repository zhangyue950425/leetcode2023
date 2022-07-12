package leetcodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间:
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class merge {
    public static int[][] merge(int[][] intervals) {
        List<int[]> list = Arrays.asList(intervals);
        List<int[]> newList = new ArrayList<>(list);
        List<int[]> res = new ArrayList<>();
        newList.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < newList.size(); ) {
            int t = newList.get(i)[1];
            int j = i + 1;
            while (j < newList.size() && newList.get(j)[0] <= t) {
                t = Math.max(t, newList.get(j)[1]);
                j++;
            }
            res.add(new int[]{newList.get(i)[0], t});
            i = j;
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = new int[4][2];
        nums[0] = new int[]{1, 3};
        nums[1] = new int[]{2, 6};
        nums[2] = new int[]{8, 10};
        nums[3] = new int[]{15, 18};
        System.out.println(Arrays.deepToString(merge(nums)));

    }
}
