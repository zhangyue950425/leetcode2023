package array;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return;
        }
        int slow = 0, fast = 0;
        while (fast < length) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
            fast++;
        }
    }

    public static void main(String[] args) {
        // 0,1,0,3,12
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
