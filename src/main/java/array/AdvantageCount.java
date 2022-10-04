package array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageCount {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        // 给 nums2 降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );
        for (int i = 0; i < nums2.length; i++) {
            maxpq.add(new int[]{i, nums2[i]});
        }
        // 给 nums1 升序排序
        Arrays.sort(nums1);
        // nums1[left] 是最⼩值，nums1[right] 是最⼤值
        int left = 0, right = length - 1;
        int[] result = new int[length];
        while(!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            // val 是 nums2 中的最⼤值，i 是对应索引
            int i = pair[0], val = pair[1];
            if (nums1[right] > val) {
                // 如果 nums1[right] 能胜过 val，那就⾃⼰上
                result[i] = nums1[right];
                right--;
            } else{
                // 否则⽤最⼩值混⼀下，养精蓄锐
                result[i] = nums1[left];
                left++;
            }
        }
        return result;
    }
}
