package ByteDancePractice;

import java.util.Arrays;
import java.util.Random;

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

    /**
     * 快排
     * @param nums
     * @param k
     * @return
     */
    private static final Random random = new Random(System.currentTimeMillis());
    public int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        int index = length - k;
        int left = 0;
        int right = length - 1;
        while (true) {
            // 通过一次快排的遍历可以使得某个值确定最终的排序位置，只要该次位置是length - k就是按照升序后第k个最大的元素
            int partition = partition(nums, left, right);
            if (partition == index) {
                return nums[partition];
            } else if (partition > index) {
                right = partition - 1;
            } else {
                // partition < index
                left = partition + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int rand = left + random.nextInt(right - left + 1);
        swap(nums, left, rand);
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (true) {
            // 从l位置开始找比pivot大的数，为了交换
            while (l <= r && nums[l] <= pivot) {
                l++;
            }
            // 从r位置开始找比pivot小的数，为了交换
            while (l <= r && nums[r] >= pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            // 交换两个位置的值
            swap(nums, l, r);
            // 推进两个索引
            l++;
            r--;
        }
        // 遍历结束之后再一次交换
        swap(nums, left, r);
        // 返回这次遍历确定排序位置的索引值
        return r;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        FindKthLargest_215 findKthLargest215 = new FindKthLargest_215();
        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;
        //System.out.println(findKthLargest215.findKthLargest(nums, k));
        System.out.println(findKthLargest215.findKthLargest2(nums, k));
        nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        //System.out.println(findKthLargest215.findKthLargest(nums, k));
    }
}
