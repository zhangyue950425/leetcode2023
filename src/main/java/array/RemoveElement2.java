package array;

import java.util.Arrays;

public class RemoveElement2 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 1 && nums[0] != val) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                result++;
            }
        }
        if (result == length) {
            return result;
        }
        int i = 0, j = 1;
        result = 0;
        while (i < j && i < length && j < length) {
            if (nums[i] == val) {
                if (nums[j] == val) {
                    j++;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    result++;
                    j++;
                }
            } else {
                if (nums[j] != val) {
                    i = i + 2;
                    result = result + 2;
                    j = j + 2;
                } else {
                    i++;
                    result++;
                    j++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        RemoveElement2 removeElement2 = new RemoveElement2();
        System.out.println(removeElement2.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        System.out.println(removeElement2.removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3,3};
        val = 5;
        System.out.println(removeElement2.removeElement(nums, val));
        nums = new int[]{2,2,2};
        val = 0;
        System.out.println(removeElement2.removeElement(nums, val));
    }
}
