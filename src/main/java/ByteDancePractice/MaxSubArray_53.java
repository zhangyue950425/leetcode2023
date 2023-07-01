package ByteDancePractice;

public class MaxSubArray_53 {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        // 以nums[i]为结尾元素的数组的连续子数组的最大和
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 分治
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, length - 1);
    }

    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (right + left) / 2;
        return Math.max(Math.max(maxSubArraySum(nums, left, mid), maxSubArraySum(nums, mid + 1, right)),
                maxCrossingSum(nums, left, mid, right));
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 包含mid位置的元素，从mid位置的值开始向左计算看最大值
        for (int i = mid; i >= left; i--) {
            sum = sum + nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 不包含mid位置的元素，计算右边最大值
        for (int i = mid + 1; i <= right; i++) {
            sum = sum + nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        MaxSubArray_53 maxSubArray53 = new MaxSubArray_53();
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray53.maxSubArray(nums));
        System.out.println(maxSubArray53.maxSubArray2(nums));
        nums = new int[] {1};
        System.out.println(maxSubArray53.maxSubArray(nums));
        System.out.println(maxSubArray53.maxSubArray2(nums));
        nums = new int[] {5,4,-1,7,8};
        System.out.println(maxSubArray53.maxSubArray(nums));
        System.out.println(maxSubArray53.maxSubArray2(nums));
        nums = new int[] {1};
        System.out.println(maxSubArray53.maxSubArray(nums));
        System.out.println(maxSubArray53.maxSubArray2(nums));
    }
}
