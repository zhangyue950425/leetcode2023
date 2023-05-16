package Hot100;

public class CanPartition {

    public boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // dp为从0到i的数组中选择使之和为j的结果，是否可以存在，dp数组值为false表示不存在，true表示存在
        boolean[][] dp = new boolean[length][target + 1];
        if (nums[0] <= target) {
            for (int i = 0; i <= target; i++) {
                dp[0][target] = false;
            }
            dp[0][nums[0]] = true;
        } else {
            for (int i = 0; i <= target; i++) {
                dp[0][target] = false;
            }
        }
        // 初始化
        dp[0][0] = false;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] == j) {
                    dp[i][j] = true;
                } else if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // nums[i] < j 可加可不加？
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

            }
        }
        return dp[length - 1][target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,11,5};
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(nums));
    }
}
