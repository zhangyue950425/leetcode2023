package bilibili;

import java.util.Arrays;

public class MaxSubArray_53 {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划-状态压缩
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int subMax = nums[0];
        for (int i = 1; i < length; i++) {
            if (subMax > 0) {
                subMax = subMax + nums[i];
            } else {
                subMax = nums[i];
            }
            max = Math.max(max, subMax);
        }
        return max;
    }

    /**
     * 最大和的连续子数组
     * @param nums
     * @return
     */
    public int[] maxSubArrayPosition(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return new int[]{nums[0]};
        }
        int start = 0;
        int end = 0;
        int subStart = 0;
        int subEnd = 0;
        int subMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            if (subMax > 0) {
                subMax = subMax + nums[i];
                subEnd++;
            } else {
                subMax = nums[i];
                subStart = i;
                subEnd = i;
            }
            if (subMax > max) {
                max = subMax;
                start = subStart;
                end = subEnd;
            }
        }
        int len = end - start + 1;
        int[] result = new int[len];
        int index = 0;
        for (int i = start; i <= end; i++) {
            result[index++] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSubArray_53 maxSubArray53 = new MaxSubArray_53();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray53.maxSubArray(nums));
        System.out.println(maxSubArray53.maxSubArray2(nums));
        System.out.println(Arrays.toString(maxSubArray53.maxSubArrayPosition(nums)));
        nums = new int[] {1};
        System.out.println(maxSubArray53.maxSubArray(nums));
        System.out.println(maxSubArray53.maxSubArray2(nums));
        System.out.println(Arrays.toString(maxSubArray53.maxSubArrayPosition(nums)));
        nums = new int[] {5,4,-1,7,8};
        System.out.println(maxSubArray53.maxSubArray(nums));
        System.out.println(maxSubArray53.maxSubArray2(nums));
        System.out.println(Arrays.toString(maxSubArray53.maxSubArrayPosition(nums)));
    }
}
