package ByteDancePractice;

import java.util.PriorityQueue;

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

    public static void main(String[] args) {
        FindKthLargest_215_3 findKthLargest2153 = new FindKthLargest_215_3();
        int[] nums = new int[] {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest2153.findKthLargest(nums, k));
        nums = new int[] {3,2,3,1,2,4,5,5,6};
        k = 4;
        System.out.println(findKthLargest2153.findKthLargest(nums, k));
    }
}
