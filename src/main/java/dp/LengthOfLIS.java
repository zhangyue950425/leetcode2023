package dp;

import java.util.Arrays;

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        // dp[i]数组的定义为以数组nums[i]结尾的数组的最长递增子序列
        int[] dp = new int[length];
        // 初始化都为1，表示以自己作为唯一一个子序列元素的情况，这个是最少
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 再求最大值才是整个数组的最长递增子序列
        int result = 1;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        // nums = [10,9,2,5,3,7,101,18]
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
    }
}
