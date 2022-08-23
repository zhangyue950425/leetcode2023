package dp;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // dp[i]定义为以数组nums[i]结尾的数组最大子数组和
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        // nums = [-2,1,-3,4,-1,2,1,-5,4]
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
