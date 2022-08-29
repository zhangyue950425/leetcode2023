package dp;

public class Rob2 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, length - 2),
                robRange(nums, 1, length - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int length = end - start + 1;
        int[] dp = new int[length + 2];
        for (int i = end - 1; i >= start; i--) {
            // 抢或者不抢
            dp[i] = Math.max(dp[i + 2] + nums[i], dp[i + 1]);
        }
        return dp[start];
    }

    public static void main(String[] args) {
        // 2,3,2
        int[] nums = new int[]{2,3,2};
        Rob2 rob2 = new Rob2();
        System.out.println(rob2.rob(nums));
        // 1,2,3,1
        nums = new int[]{1,2,3,1};
        System.out.println(rob2.rob(nums));
    }
}
