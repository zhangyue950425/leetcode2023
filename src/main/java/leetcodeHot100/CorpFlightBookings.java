package leetcodeHot100;

import java.util.Arrays;

/**
 * 1109
 */
public class CorpFlightBookings {

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

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        Difference difference = new Difference(result);
        for (int i = 0; i < bookings.length; i++) {
            difference.increment(bookings[i][0] - 1, bookings[i][1] - 1, bookings[i][2]);
        }
        result = difference.result();
        return result;
    }

    public static void main(String[] args) {
        // bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
        int n = 5;
        int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        CorpFlightBookings corpFlightBookings = new CorpFlightBookings();
        System.out.println(Arrays.toString(corpFlightBookings.corpFlightBookings(bookings, n)));
    }

}
