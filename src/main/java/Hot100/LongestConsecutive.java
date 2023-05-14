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
        // key为i位置的元素值num,value表示num所在的连续区间的长度
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int curLen = map.getOrDefault(num, 1);
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                curLen = curLen + left + right;
                maxLen = Math.max(maxLen, curLen);
                // 将num加入map中，表示已经遍历过该值。其对应的value可以为任意值。
                map.put(num, curLen);
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }


        }
        return maxLen;
    }

    class UnionFind {
        // 记录每个节点的父节点
        Map<Integer, Integer> parent;

        public UnionFind(int[] nums) {
            parent = new HashMap<>();
            for (int num : nums) {
                // 初始化自己为自己的父节点
                parent.put(num, num);
            }
        }
        // 寻找x的父节点，实际上也就是x的最远连续右边界
        public Integer find(int x) {
            // nums不包含x
            if (!parent.containsKey(x)) {
                return null;
            }
            // 遍历找到x的父节点
            while (x != parent.get(x)) {
                // 进行路径压缩
                parent.put(x, parent.get(parent.get(x)));
                x = parent.get(x);
            }
            return x;
        }
        // 合并两个连通分量，在本题中只用来将num并入到num+1的连续区间中
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
        }
    }
    /**
     * 并查集 ToDo
     * @param nums
     * @return
     */
    public int longestConsecutive4(int[] nums) {
        UnionFind unionFind = new UnionFind(nums);
        int maxLen = 0;
        for (int num : nums) {
            // 当num+1存在，将num合并到num+1所在集合中
            if (unionFind.find(num + 1) != null) {
                unionFind.union(num, num + 1);
            }
        }
        // 找到num的最远连续右边界
        for (int num : nums) {
            int right = unionFind.find(num);
            maxLen = Math.max(maxLen, right - num + 1);
        }
        return maxLen;
    }



    /**
     * 哈希表记录右边界
     * @param nums
     * @return
     */

    public int longestConsecutive5(int[] nums) {
        // key为数组中某个值，value为可以达到的最远值(连续序列)
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        // 初始化，为自己到自己
        for (int i = 0; i < length; i++) {
            map.put(nums[i], nums[i]);
        }
        int maxLen = 1;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i] - 1)) {
                int right = map.get(nums[i]);
                while (map.containsKey(right + 1)) {
                    map.put(nums[i], map.get(right + 1));
                    right = map.get(nums[i]);
                }
                maxLen = Math.max(maxLen, right - nums[i] + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        /**
         * 输入：nums = [100,4,200,1,3,2]
         * 输出：4
         * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
         */
        int[] nums = new int[]{100,4,200,1,3,2};
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        /*System.out.println(longestConsecutive.longestConsecutive(nums));
        System.out.println(longestConsecutive.longestConsecutive2(nums));*/
        //System.out.println(longestConsecutive.longestConsecutive5(nums));
        System.out.println(longestConsecutive.longestConsecutive3(nums));
        System.out.println(longestConsecutive.longestConsecutive4(nums));
        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        /*System.out.println(longestConsecutive.longestConsecutive(nums));
        System.out.println(longestConsecutive.longestConsecutive2(nums));*/
        //System.out.println(longestConsecutive.longestConsecutive5(nums));
        System.out.println(longestConsecutive.longestConsecutive3(nums));
        System.out.println(longestConsecutive.longestConsecutive4(nums));

    }
}
