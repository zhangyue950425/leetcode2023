package offer;

import java.util.Arrays;

public class IsStraight {

    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            if (num == 0) {
                joker++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        IsStraight isStraight = new IsStraight();
        System.out.println(isStraight.isStraight(nums));
        nums = new int[]{9, 10, 11, 12, 0};
        System.out.println(isStraight.isStraight(nums));
        nums = new int[]{0,0,1,2,5};
        System.out.println(isStraight.isStraight(nums));
        nums = new int[]{0,0,2,2,5};
        System.out.println(isStraight.isStraight(nums));
    }
}
