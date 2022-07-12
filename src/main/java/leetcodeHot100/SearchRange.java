package leetcodeHot100;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (nums.length == 0) {
            return result;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        for (int j = length - 1; j >= 0; j--) {
            if (nums[j] == target) {
                result[1] = j;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
        nums = new int[]{5, 7, 7, 8, 8, 10};
        target = 6;
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
        nums = new int[]{};
        target = 0;
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
    }
}
