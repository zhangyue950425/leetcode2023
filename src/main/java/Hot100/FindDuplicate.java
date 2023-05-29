package Hot100;

import java.util.Arrays;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[length - 1];
    }

    /**
     * 二分查找实现
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int length = nums.length;;
        int left = 1;
        int right = length - 1;
        while (left < right) {
            int mid = (left  + right) / 2;
            int count = 0;
            for (int i = 0; i < length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,4,2,2};
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(nums));
        System.out.println(findDuplicate.findDuplicate2(nums));
        nums = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate.findDuplicate(nums));
        System.out.println(findDuplicate.findDuplicate2(nums));
    }
}
