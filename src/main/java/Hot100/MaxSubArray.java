package Hot100;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        // 结尾为nums[i]的元素的最大连续子数组和
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++){
            int num = nums[i];
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + num;
            } else {
                dp[i] = Math.max(dp[i - 1] + num, num);
            }
        }
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        // 前i个元素的最大连续子数组和
        int[] dp = new int[length + 1];
        dp[0] = Integer.MIN_VALUE;
        dp[1] = nums[0];
        for (int i = 1; i < length; i++){
            int num = nums[i];
            if (dp[i] >= 0) {
                dp[i + 1] = dp[i] + num;
            } else {
                dp[i + 1] = Math.max(dp[i] + num, num);
            }
        }
        int max = dp[0];
        for (int i = 1; i <= length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        // nums = [-2,1,-3,4,-1,2,1,-5,4]
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(nums));
        System.out.println(maxSubArray.maxSubArray2(nums));
        nums = new int[]{-1};
        System.out.println(maxSubArray.maxSubArray(nums));
        System.out.println(maxSubArray.maxSubArray2(nums));
    }
}
