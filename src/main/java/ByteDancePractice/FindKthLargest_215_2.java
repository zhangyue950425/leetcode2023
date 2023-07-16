package ByteDancePractice;

import java.util.Arrays;
import java.util.Random;

public class FindKthLargest_215_2 {

    static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int target = length - k;
        int left = 0;
        int right = length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index > target){
                right = index - 1;
            } else {
                // index < target
                left = index + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left;
        int rand = left + random.nextInt(right - left + 1);
        // 先交换一下随机位置的数
        swap(nums, pivot, rand);
        left = pivot + 1;
        while (true) {
            while (left <= right && nums[left] < nums[pivot]) {
                left++;
            }
            while (left <= right && nums[right] > nums[pivot]) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        swap(nums, pivot, right);
        return right;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    public static void main(String[] args) {
        FindKthLargest_215_2 findKthLargest2152 = new FindKthLargest_215_2();
        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;
        //System.out.println(findKthLargest2152.findKthLargest(nums, k));
        findKthLargest2152.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        nums = new int[] {3,2,3,1,2,4,5,5,6};
        k = 4;
        //System.out.println(findKthLargest2152.findKthLargest(nums, k));
        findKthLargest2152.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
