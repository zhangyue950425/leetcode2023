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

    /**
     * 二分
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int length = nums.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 索引位置为偶数
            if (mid % 2 == 0) {
                // 如果是成对的数字的话，偶数位置的数字应该和下一个位置的数字相同
                if (mid + 1 < length && nums[mid] != nums[mid + 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                // 索引位置为奇数,如果是成对的数字的话，奇数位置的数字应该和前一个位置的数字相同
                if (mid - 1 >= 0 && nums[mid] != nums[mid - 1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8};
        SingleNonDuplicate singleNonDuplicate = new SingleNonDuplicate();
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate.singleNonDuplicate2(nums));
        nums = new int[] {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate.singleNonDuplicate2(nums));
        nums = new int[] {1};
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate.singleNonDuplicate2(nums));
        nums = new int[] {1,1,2};
        System.out.println(singleNonDuplicate.singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate.singleNonDuplicate2(nums));
    }
}
