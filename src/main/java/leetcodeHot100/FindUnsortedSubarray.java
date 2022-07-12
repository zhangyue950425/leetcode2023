package leetcodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 581. 最短无序连续子数组
 */
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] != arr[i]) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        return list.get(list.size() - 1) - list.get(0) + 1;
    }

    public static void main(String[] args) {
        // 2,6,4,8,10,9,15
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(nums));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(nums));
    }
}
