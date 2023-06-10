package TenDaysByteDancePractice;

public class SingleNonDuplicate {

    /**
     * 暴力遍历
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        for (int i = 0; i < length && i + 1 < length; i = i + 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8};
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
        nums = new int[] {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
        nums = new int[] {1};
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
        nums = new int[] {1,1,2};
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
    }
}
