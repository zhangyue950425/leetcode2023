package Hot100;

public class MaxProduct {

    public int maxProduct(int[] nums) {
        int length = nums.length;
        // 以索引i元素结尾的数组中子数组乘机最小值
        int[] minDp = new int[length];
        // 以索引i元素结尾的数组中子数组乘机最大值
        int[] maxDp = new int[length];
        minDp[0] = nums[0];
        maxDp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] >= 0) {
                minDp[i] = Math.min(nums[i], nums[i] * minDp[i - 1]);
                maxDp[i] = Math.max(nums[i], nums[i] * maxDp[i - 1]);
            } else {
                minDp[i] = Math.min(nums[i], nums[i] * maxDp[i - 1]);
                maxDp[i] = Math.max(nums[i], nums[i] * minDp[i - 1]);
            }
        }
        int max = maxDp[0];
        for (int i = 1; i < maxDp.length; i++) {
            max = Math.max(max, maxDp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        // 输入: nums = [2,3,-2,4]
        // 输出: 6
        // 解释: 子数组 [2,3] 有最大乘积 6。
        int[] nums = new int[] {2,3,-2,4};
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(nums));
        // 输入: nums = [-2,0,-1]
        // 输出: 0
        // 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
        nums = new int[] {-2,0,-1};
        System.out.println(maxProduct.maxProduct(nums));
        nums = new int[] {-2,3,-4};
        System.out.println(maxProduct.maxProduct(nums));
    }

}
