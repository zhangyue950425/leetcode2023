package ByteDancePractice;

import java.util.Arrays;

public class LengthOfLIS_300 {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        // 以nums[i]元素结尾的最长递增子序列的长度
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < length; i++) {
            int num1 = nums[i];
            for (int j = 0; j < i; j++) {
                int num2 = nums[j];
                if (num2 < num1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLIS_300 lengthOfLIS_300 = new LengthOfLIS_300();
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS_300.lengthOfLIS(nums));
        nums = new int[] {0,1,0,3,2,3};
        System.out.println(lengthOfLIS_300.lengthOfLIS(nums));
        nums = new int[] {7,7,7,7,7,7,7};
        System.out.println(lengthOfLIS_300.lengthOfLIS(nums));
    }
}
