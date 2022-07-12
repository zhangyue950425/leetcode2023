package leetcodeHot100;

import java.util.Arrays;

/**
 * 370
 */
public class GetModifiedArray {

    static class Difference {

        // 差分数组
        private int[] diff;

        public Difference(int[] nums) {
            int length = nums.length;
            diff = new int[length];
            diff[0] = nums[0];
            for (int i = 1; i < length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /**
         * 给区间【i，j】增加val
         * diff[i]+val,diff[j+1]-val
         *
         * @param i
         * @param j
         * @param val
         */
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        /**
         * 返回结果数组：根据diff数组推出数组
         *
         * @return
         */
        public int[] result() {
            int[] result = new int[diff.length];
            result[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                result[i] = result[i - 1] + diff[i];
            }
            return result;
        }
    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        Difference difference = new Difference(result);
        for (int i = 0; i < updates.length; i++) {
            difference.increment(updates[i][0], updates[i][1], updates[i][2]);
        }
        result = difference.result();
        return result;
    }

    public static void main(String[] args) {
        // length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
        int length = 5;
        int[][] updates = new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        GetModifiedArray getModifiedArray = new GetModifiedArray();
        System.out.println(Arrays.toString(getModifiedArray.getModifiedArray(length, updates)));
    }
}
