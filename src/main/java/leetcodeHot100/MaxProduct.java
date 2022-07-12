package leetcodeHot100;

/**
 * 乘积最大子数组:
 * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * <p>
 * 测试用例的答案是一个32-位 整数。
 * <p>
 * 子数组 是数组的连续子序列。
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释:子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            max[i] = Math.max(max[i - 1] * nums[i], Math.max(min[i - 1] * nums[i], nums[i]));
            min[i] = Math.min(max[i - 1] * nums[i], Math.min(min[i - 1] * nums[i], nums[i]));
        }
        int result = max[0];
        for (int i = 1; i < max.length; i++) {
            if (result < max[i]) {
                result = max[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        MaxProduct maxProduct = new MaxProduct();
        //System.out.println(maxProduct.maxProduct(nums));
        nums = new int[]{5, 6, 4, -3, 4, -3};
        System.out.println(maxProduct.maxProduct(nums));
    }
}
