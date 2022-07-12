package leetcodeHot100;

/**
 * 303
 */
public class NumArray {

    //private int[] arr;
    // 前缀和数组
    private int[] preSum;


    public NumArray(int[] nums) {
        /*int length = nums.length;
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = nums[i];
        }*/
        int length = nums.length;
        preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 1; i < length + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        /*int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += arr[i];
        }
        return sum;*/
        return preSum[right + 1] - preSum[left];
    }

    public static void main(String[] args) {
        // [-2, 0, 3, -5, 2, -1]
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        // [0, 2], [2, 5], [0, 5]
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));


    }
}
