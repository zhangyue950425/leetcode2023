package leetcodeHot100;

/**
 * 和为 K 的子数组:
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int result = 0;
        /*for (int num : nums) {
            if (num == k) {
                result++;
            }
        }*/
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        SubarraySum subarraySum = new SubarraySum();
        //System.out.println(subarraySum.subarraySum(nums, k));
        nums = new int[]{1, 2, 3};
        k = 3;
        //System.out.println(subarraySum.subarraySum(nums, k));
        nums = new int[]{1, -1, 0};
        k = 0;
        System.out.println(subarraySum.subarraySum(nums, k));
    }
}
