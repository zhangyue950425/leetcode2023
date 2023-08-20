package ByteDancePractice;

public class MaxSubArray_53_2 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        // 以dp[i]表示以nums[i]结尾的数字的最大子数组和，所以nums[i]连续子数组中必须包含nums[i]
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray_53_2 maxSubArray_53_2 = new MaxSubArray_53_2();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray_53_2.maxSubArray(nums));
        nums = new int[] {1};
        System.out.println(maxSubArray_53_2.maxSubArray(nums));
        nums = new int[] {5,4,-1,7,8};
        System.out.println(maxSubArray_53_2.maxSubArray(nums));
    }
}
