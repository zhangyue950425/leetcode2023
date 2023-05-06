package offer;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= length; i++) {
            set.add(i);
        }
        for (int i = 0; i < length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return (Integer) set.toArray()[0];

    }

    public int missingNumber2(int[] nums) {
        int length = nums.length;
        int start = 0, end = length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        // 0,1,3
        // 0,1,2,3,4,5,6,7,9
        int[] nums = new int[]{0,1,3};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
        System.out.println(missingNumber.missingNumber2(nums));
        nums = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber.missingNumber(nums));
        System.out.println(missingNumber.missingNumber2(nums));
        nums = new int[]{0};
        System.out.println(missingNumber.missingNumber2(nums));
    }
}
