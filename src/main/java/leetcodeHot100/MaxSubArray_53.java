package leetcodeHot100;

public class MaxSubArray_53 {

    /**
     * 暴力法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        // dp[i]为以nums[i]结尾的连续子数组最大和
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray_53 maxSubArray53 = new MaxSubArray_53();
        int[] nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray53.maxSubArray(nums));
        nums = new int[] {5, 4, -1, 7, 8};
        System.out.println(maxSubArray53.maxSubArray(nums));
        nums = new int[] {-2,-1};
        System.out.println(maxSubArray53.maxSubArray(nums));
    }
}
