package Hot100;

import java.util.Arrays;

public class ProductExceptSelf {

    /**
     * 暴力方法，O(n*n)
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int product = 1;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                } else {
                    product = product * nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        int productLeft = 1;
        // 计算最终结果的左部分结果
        for (int i = 0; i < length; i++) {
            result[i] = productLeft;
            productLeft = productLeft * nums[i];
        }
        // 计算最终结果的右半部分
        int productRight = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] = result[i] * productRight;
            productRight = productRight * nums[i];
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf2(nums)));
        nums = new int[]{-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf.productExceptSelf2(nums)));

    }
}
