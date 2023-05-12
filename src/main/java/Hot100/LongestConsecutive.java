package Hot100;

import java.util.*;

public class LongestConsecutive {

    /**
     * 暴力
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int length = nums.length;
        int maxLen = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            int start = i, end = i + 1;
            list.add(nums[start]);
            for (;start < length && end < length;) {
                if (nums[start] == nums[end]) {
                    start++;
                    end++;
                    continue;
                }
                if (nums[start] + 1 == nums[end]) {
                    list.add(nums[end]);
                    start++;
                    end++;
                } else {
                    break;
                }
            }
            result.add(list);
        }
        for (List<Integer> list : result) {
            maxLen = Math.max(list.size(), maxLen);
        }
        return maxLen;
    }

    /**
     * 哈希集合去重
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curLen = 1;
                while (set.contains(num + 1)) {
                    curLen++;
                    num++;
                }
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    /**
     * 动态规划 ToDo
     * @param nums
     * @return
     */
    public int longestConsecutive3(int[] nums) {
        return 0;
    }

    /**
     * 并查集 ToDo
     * @param nums
     * @return
     */
    public int longestConsecutive4(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        /**
         * 输入：nums = [100,4,200,1,3,2]
         * 输出：4
         * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
         */
        int[] nums = new int[]{100,4,200,1,3,2};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(nums));
        System.out.println(longestConsecutive.longestConsecutive2(nums));
        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive.longestConsecutive(nums));
        System.out.println(longestConsecutive.longestConsecutive2(nums));
    }
}
