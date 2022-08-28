package dp;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[][] dp = new boolean[length + 1][sum + 1];
        for (int i = 0; i <= length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length][sum];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(nums));
        // 1,2,3,5
        nums = new int[]{1,2,3,5};
        System.out.println(canPartition.canPartition(nums));
    }

}
