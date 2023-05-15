package Hot100;

public class Rob {

    public int rob(int[] nums) {
        int length = nums.length;
        int oddMax = 0;
        int evenMax = 0;
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                evenMax = evenMax + nums[i];
            } else {
                oddMax = oddMax + nums[i];
            }
        }
        return Math.max(oddMax, evenMax);
    }

    public int rob1(int[] nums) {
        int length = nums.length;
        // 前i间房子抢到的最大金额
        int[] dp = new int[length + 1];
        // 初始化
        dp[0] = 0;
        dp[1] = nums[0];
        // 抢或者不抢
        for (int i = 1; i < length; i++) {
            dp[i + 1] = Math.max(dp[i - 1] + nums[i], dp[i]);
        }
        return dp[length];
    }

    public static void main(String[] args) {
        // 输入：[2,7,9,3,1]
        // 输出：12
        // 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
        // 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
        int[] nums = new int[]{2,7,9,3,1};
        Rob rob = new Rob();
        System.out.println(rob.rob(nums));
        System.out.println(rob.rob1(nums));
        nums = new int[]{1,2,3,1};
        System.out.println(rob.rob(nums));
        System.out.println(rob.rob1(nums));

    }
}
