package ByteDancePractice;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 快排，堆排序
 */
public class FindKthLargest_215_3 {

    /**
     * 优先队列
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < length; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            if (!priorityQueue.isEmpty()) {
                int num = priorityQueue.poll();
                if (i == k - 1) {
                    return num;
                }
            }
        }
        return 0;
    }

    /**
     * 堆排序
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        // 建堆操作：堆化除叶节点以外的其他所有节点
        for (int i = length / 2 - 1; i >= 0; i--) {
            siftDown(nums, length, i);
        }
        for (int i = length - 1; i >= length - k; i--) {
            swap(nums, i, 0);
            siftDown(nums, i, 0);
            if (i == length - k) {
                return nums[length - k];
            }
        }
        return nums[length - 1];
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    /**
     * 从顶到底堆化
     * @param nums
     * @param length
     * @param i
     */
    private void siftDown(int[] nums, int length, int i) {
        while (true) {
            int left = 2 * i + 1, right = 2 * i + 2;
            int max = i;
            if (left < length && nums[left] > nums[max]) {
                max = left;
            }
            if (right < length && nums[right] > nums[max]) {
                max = right;
            }
            if (max == i) {
                break;
            }
            swap(nums, i, max);
            i = max;
        }
    }

    final static Random random = new Random(System.currentTimeMillis());
    /**
     * 快排
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        int length = nums.length;
        int target = length - k;
        int left = 0, right = length - 1;
        while (true) {
            int pi = partition(nums, left, right);
            if (target == pi) {
                return nums[pi];
            } else if (pi > target) {
                right = pi - 1;
            } else {
                // pi < target
                left = pi + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        // 先和随机位置交换
        int length = nums.length;
        int pi = left;
        int ran = left + random.nextInt(right - left + 1);
        swap(nums, pi, ran);
        left = left + 1;
        while (true) {
            while (left <= right && nums[left] < nums[pi]) {
                left++;
            }
            while (left <= right && nums[right] > nums[pi]) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        swap(nums, pi, right);
        return right;
    }

    public static void main(String[] args) {
        FindKthLargest_215_3 findKthLargest2153 = new FindKthLargest_215_3();
        int[] nums = new int[] {3,2,1,5,6,4};
        int k = 2;
        //System.out.println(findKthLargest2153.findKthLargest(nums, k));
        //System.out.println(findKthLargest2153.findKthLargest2(nums, k));
        System.out.println(findKthLargest2153.findKthLargest3(nums, k));
        nums = new int[] {3,2,3,1,2,4,5,5,6};
        k = 4;
        //System.out.println(findKthLargest2153.findKthLargest(nums, k));
        //System.out.println(findKthLargest2153.findKthLargest2(nums, k));
        System.out.println(findKthLargest2153.findKthLargest3(nums, k));
    }
}
