package leetcodeHot100;

public class CarPooling {

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

    public boolean carPooling(int[][] trips, int capacity) {
        int length = 1001;
        int[] result = new int[length];
        Difference difference = new Difference(result);
        for (int i = 0; i < trips.length; i++) {
            difference.increment(trips[i][1], trips[i][2] - 1, trips[i][0]);
        }
        result = difference.result();
        for (int i = 0; i < length; i++) {
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // trips = [[2,1,5],[3,3,7]], capacity = 4
        int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(trips, capacity));
        capacity = 5;
        System.out.println(carPooling.carPooling(trips, capacity));
    }
}
