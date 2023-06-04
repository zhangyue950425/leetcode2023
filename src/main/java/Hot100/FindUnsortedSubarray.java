package Hot100;

import java.util.Arrays;

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] sortedNums = new int[length];
        System.arraycopy(nums, 0, sortedNums, 0, length);
        Arrays.sort(sortedNums);
        int start = 0, end = length - 1;
        while (start >= 0 && start <= length - 1 && start <= end && nums[start] == sortedNums[start]) {
            start++;
        }
        if (start > end) {
            return 0;
        }
        while (end <= length - 1 && end >= 0 && start <= end && nums[end] == sortedNums[end]) {
            end--;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 6, 4, 8, 10, 9, 15};
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(nums));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(nums));
    }
}
