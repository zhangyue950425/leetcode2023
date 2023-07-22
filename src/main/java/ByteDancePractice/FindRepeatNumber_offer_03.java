package ByteDancePractice;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber_offer_03 {

    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return nums[length - 1];
    }

    public static void main(String[] args) {
        FindRepeatNumber_offer_03 findRepeatNumberOffer03 = new FindRepeatNumber_offer_03();
        int[] nums = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumberOffer03.findRepeatNumber(nums));
    }
}
