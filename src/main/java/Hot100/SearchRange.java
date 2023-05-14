package Hot100;

import java.util.Arrays;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return new int[]{-1, -1};
        }
        int i = 0, j = length - 1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) {
                max = Math.max(max, mid);
                min = Math.min(min, mid);
                i++;
                j--;
            } else if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int[] result = new int[]{-1, -1};
        if (min != Integer.MAX_VALUE) {
            result[0] = min;
        }
        if (max != Integer.MIN_VALUE) {
            result[1] = max;
        }
        return result;
    }

    public int[] searchRange2(int[] nums, int target) {
        // 寻找比target小的第一个数，寻找比target大的第一个数
        int length = nums.length;
        int i = 0, j = length - 1;
        int[] result = new int[]{-1, -1};
        if (length == 0) {
            return result;
        }
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int right = i;
        i = 0;
        j = length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target == nums[mid]) {
                j = mid - 1;
            } else if (target > nums[mid]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int left = j;
        int count = right - left - 1;
        if (count == 0) {
            return result;
        } else {
            result[0] = left + 1;
            result[1] = right - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
        System.out.println(Arrays.toString(searchRange.searchRange2(nums, target)));
    }
}
