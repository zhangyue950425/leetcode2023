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

    /**
     * 原地排序
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
       int length = nums.length;
        int i = 0;
       while (i < length) {
           int num = nums[i];
           if (i == num) {
               i++;
           } else {
               int num2 = nums[num];
               if (num2 == num) {
                   return num;
               } else {
                   swap(nums, i, num);
               }
           }
       }
       return nums[length - 1];
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        FindRepeatNumber_offer_03 findRepeatNumberOffer03 = new FindRepeatNumber_offer_03();
        int[] nums = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumberOffer03.findRepeatNumber(nums));
        System.out.println(findRepeatNumberOffer03.findRepeatNumber2(nums));
    }
}
