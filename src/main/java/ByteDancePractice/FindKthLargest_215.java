package ByteDancePractice;

import java.util.Arrays;

public class FindKthLargest_215 {

    /**
     * 暴力方法
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length - k];
    }

    public static void main(String[] args) {
        FindKthLargest_215 findKthLargest215 = new FindKthLargest_215();
        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest215.findKthLargest(nums, k));
        nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        System.out.println(findKthLargest215.findKthLargest(nums, k));
    }
}
