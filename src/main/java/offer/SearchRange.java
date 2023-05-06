package offer;

import java.util.Arrays;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int length = nums.length;
        int start = 0, end = length - 1;
        // 搜索右边界
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int right = start;
        start = 0;
        end = length - 1;
        // 搜索左边界
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int left = end;
        int count = Math.max(right - left - 1, 0);
        if (count == 0) {
            return result;
        } else {
            result[0] = left + 1;
            result[1] = right - 1;
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
        nums = new int[]{2, 2};
        target = 2;
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
    }
}
