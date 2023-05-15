package Hot100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int comp = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            set.add(i);
        }
        for (int i = 1; i <= k; i++) {
            if (i == 1) {
                int max = Integer.MIN_VALUE;
                int start = 0;
                while (start >= 0 && start < length) {
                    max = Math.max(max, nums[start]);
                    start++;
                }
                set.remove(start);
                comp = max;
            } else {
                int start = 0;
                while (start >= 0 && start < length && nums[start] > comp && set.contains(start)) {
                    start++;
                }
                set.remove(start);
                comp = nums[start];
            }
        }
        return comp;
    }

    /**
     * 暴力方法
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[length - k];
    }

    /**
     * 快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        int start = 0;
        int length = nums.length;
        int end = length - 1;
        int index = length - k;
        while (true) {
            int partition = partition(nums, start, end);
            if (partition == index) {
                return nums[partition];
            } else if (partition > index) {
                end = partition - 1;
            } else {
                start = partition + 1;
            }
        }
    }

    /**
     * 交换数据
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static  final Random random = new Random(System.currentTimeMillis());
    /**
     * 划分
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        // 原本是以第一个数作为基准数，防止极端测试用例需要随机以一个数作为基准数
        int randomIndex = left + random.nextInt(right - left + 1);
        // 交换
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left + 1, ge = right;
        while (true) {
            // 从右到左找比基准数小的，需要换到左边
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            // 从左到右找比基准数大的，需要换到右边
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        FindKthLargest findKthLargest = new FindKthLargest();
        //System.out.println(findKthLargest.findKthLargest(nums, k));
        /*System.out.println(findKthLargest.findKthLargest1(nums, k));
        System.out.println(findKthLargest.findKthLargest2(nums, k));*/
        nums = new int[] {3,2,1,5,6,4};
        k = 2;
        System.out.println(findKthLargest.findKthLargest2(nums, k));
    }
}
