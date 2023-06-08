package TenDaysByteDancePractice;

import java.util.Arrays;

/**
 * 977. 有序数组的平方:
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * 时间复杂度为 O(n) 的算法
 */
public class SortedSquares {
    /**
     * 快排
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = (int) Math.pow(nums[i], 2);
        }
        Arrays.sort(result);
        return result;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        if (length == 1) {
            result[0] = (int) Math.pow(Math.abs(nums[0]), 2);
            return result;
        }
        // index指向最小的正整数或0
        int index = 0;
        while (index < length) {
            if (nums[index] >= 0) {
                break;
            } else {
                index++;
            }
        }
        int left = index - 1;
        int right = index;
        index = 0;
        while (left >= 0 && right <= length - 1 && index < length) {
            if (Math.abs(nums[left]) >= nums[right]) {
                result[index++] = (int) Math.pow(nums[right], 2);
                right++;
            } else {
                result[index++] = (int) (Math.pow(Math.abs(nums[left]), 2));
                left--;
            }
        }
        if (left > 0) {
            result[length - 1] = (int) (Math.pow(Math.abs(nums[left]), 2));
        }
        if (right == length - 1) {
            result[length - 1] = (int) Math.pow(nums[right], 2);
        }
        return result;
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int[] sortedSquares3(int[] nums) {
       int length = nums.length;
       int[] result = new int[length];
       int index = length - 1;
       for (int i = 0, j = length - 1; i <= j && i < length && j < length;) {
           int productI = nums[i] * nums[i];
           int productJ = nums[j] * nums[j];
           if (productI > productJ) {
               result[index] = productI;
               i++;
           } else {
               result[index] = productJ;
               j--;
           }
           index--;
       }
       return result;
    }

    public static void main(String[] args) {
        // 输入：nums = [-4,-1,0,3,10]
        // 输出：[0,1,9,16,100]
        // 解释：平方后，数组变为 [16,1,0,9,100]排序后，数组变为 [0,1,9,16,100]
        // 输入：nums = [-7,-3,2,3,11]
        // 输出：[4,9,9,49,121]
        int[] nums = new int[] {-4,-1,0,3,10};
        SortedSquares sortedSquares = new SortedSquares();
        System.out.println(Arrays.toString(sortedSquares.sortedSquares(nums)));
        //System.out.println(Arrays.toString(sortedSquares.sortedSquares2(nums)));
        System.out.println(Arrays.toString(sortedSquares.sortedSquares3(nums)));
        nums = new int[] {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares.sortedSquares(nums)));
        //System.out.println(Arrays.toString(sortedSquares.sortedSquares2(nums)));
        System.out.println(Arrays.toString(sortedSquares.sortedSquares3(nums)));
        nums = new int[] {-1};
        System.out.println(Arrays.toString(sortedSquares.sortedSquares(nums)));
        //System.out.println(Arrays.toString(sortedSquares.sortedSquares2(nums)));
        System.out.println(Arrays.toString(sortedSquares.sortedSquares3(nums)));
    }
}
