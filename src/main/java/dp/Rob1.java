package dp;

public class Rob1 {
    public int rob(int[] nums) {
        int length = nums.length;
        // dp[i]=x表示从第i房间开始抢能得到的最大的钱
        // dp[n]=0，表示没有房子可以抢所以只能抢到0元
        int[] dp = new int[length + 2];
        for (int i = length - 1; i >= 0; i--) {
            // 抢或者不抢
            dp[i] = Math.max(dp[i + 2] + nums[i], dp[i + 1]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        // 1,2,3,1
        int[] nums = new int[]{1,2,3,1};
        Rob1 rob1 = new Rob1();
        System.out.println(rob1.rob(nums));
    }
}
