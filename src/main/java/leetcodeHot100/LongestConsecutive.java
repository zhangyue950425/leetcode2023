package leetcodeHot100;

import java.util.*;

/**
 * 最长连续序列:
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] result = new int[length];
        for (int index = 0; index < length; index++) {
            result[index] = 1;
            for (int i = index; i < length; i++) {
                for (int j = i + 1; j < length; ) {
                    if (nums[i] + 1 == nums[j]) {
                        result[index]++;
                        i = j;
                        j++;
                    } else {
                        j++;
                    }
                }

            }
            /*for (int i = index, j = index + 1; i < length && j < length; ) {
                int nums1 = nums[i];
                int nums2 = nums[j];
                if (nums1 == nums2) {
                    break;
                } else {
                    if (nums2 == nums1 + 1) {
                        result[index]++;
                        i++;
                        j++;
                    } else {
                        break;
                    }
                }
            }*/
        }
        int max = result[0];
        for (int i = 1; i < length; i++) {
            if (max < result[i]) {
                max = result[i];
            }
        }
        return max;
    }

    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            int cur = num;
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            max = Math.max(max, cur - num + 1);
        }
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num);
        }
        int max = 0;
        for (int num : nums) {
            if (!map.containsKey(num - 1)) {
                int result = map.get(num);
                while (map.containsKey(result + 1)) {
                    result = map.get(result + 1);
                }
                map.put(num, result);
                max = Math.max(max, result - num + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        //System.out.println(longestConsecutive.longestConsecutive(nums));
        //System.out.println(longestConsecutive.longestConsecutive1(nums));
        nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        //System.out.println(longestConsecutive.longestConsecutive(nums));
        //System.out.println(longestConsecutive.longestConsecutive1(nums));
        nums = new int[]{1, 2, 0, 1};
        //System.out.println(longestConsecutive.longestConsecutive(nums));
        //System.out.println(longestConsecutive.longestConsecutive1(nums));
        nums = new int[]{1, 2, 4, 3, 5};
        //System.out.println(longestConsecutive.longestConsecutive1(nums));
        System.out.println(longestConsecutive.longestConsecutive2(nums));
    }
}
