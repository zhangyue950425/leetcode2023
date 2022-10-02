package array;

import java.util.Arrays;

public class MoveZeroes2 {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZeroes2 moveZeroes2 = new MoveZeroes2();
        moveZeroes2.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0};
        moveZeroes2.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
