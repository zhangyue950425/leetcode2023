package BinarySearch;

import java.util.Arrays;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1;
        int[] result = new int[]{-1, -1};
        while (left <= right) {
            if (nums[left] != target) {
                left++;
            } else {
                result[0] = left;
            }
            if (nums[right] != target) {
                right--;
            } else {
                result[1] = right;
            }
            if (result[0] != -1 && result[1] != -1) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // nums = [5,7,7,8,8,10], target = 8
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
        // nums = [5,7,7,8,8,10], target = 6
        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
        nums = new int[]{1};
        target = 1;
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
    }
}
