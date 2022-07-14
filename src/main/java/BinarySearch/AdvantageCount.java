package BinarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < nums2.length; i++) {
            priorityQueue.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0;
        int right = length - 1;
        int[] result = new int[length];
        while (!priorityQueue.isEmpty()) {
            int[] arr = priorityQueue.poll();
            int index = arr[0];
            int num = arr[1];
            if (nums1[right] > num) {
                result[index] = nums1[right];
                right--;
            } else {
                result[index] = nums1[left];
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // nums1 = [12,24,8,32], nums2 = [13,25,32,11]
        int[] nums1 = new int[]{12, 24, 8, 32};
        int[] nums2 = new int[]{13, 25, 32, 11};
        AdvantageCount advantageCount = new AdvantageCount();
        System.out.println(Arrays.toString(advantageCount.advantageCount(nums1, nums2)));
    }
}
