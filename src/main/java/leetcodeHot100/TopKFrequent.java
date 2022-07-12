package leetcodeHot100;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 前 K 个高频元素:
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        int[] max = new int[k];

        Pair[] pairs = IntStream.of(nums).distinct().boxed().map(num -> new Pair(num, map.get(num))).toArray(Pair[]::new);
        int index = 0;

        Pair[] topk = quickSort(pairs, 0, pairs.length - 1, k - 1);
        int idx = 0;
        for (Pair pair : topk) {
            max[idx++] = pair.num;
        }
        /*Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            map.put(num, 0);
        }
        for (int num : set) {
            for (int j = 0; j < length; j++) {
                Integer count = map.get(num);
                if (num == nums[j]) {
                    map.put(num, ++count);
                }
            }
        }*/
        return max;
    }

    private Pair[] quickSort(Pair[] pairs, int left, int right, int index) {
        if (left > right) {
            return new Pair[0];
        }
        int j = patition(pairs, left, right);
        if (j == index) {
            return Arrays.copyOf(pairs, index + 1);
        }
        return j < index ? quickSort(pairs, j + 1, right, index) : quickSort(pairs, left, j - 1, index);
    }

    private int patition(Pair[] pairs, int left, int right) {
        Pair v = pairs[left];
        int i = left;
        int j = right + 1;
        while (true) {
            while (++i <= right && pairs[i].count > v.count) ;
            while (--j >= left && pairs[j].count < v.count) ;
            if (i >= j) {
                break;
            }
            Pair tmp = pairs[i];
            pairs[i] = pairs[j];
            pairs[j] = tmp;
        }
        pairs[left] = pairs[j];
        pairs[j] = v;
        return j;
    }

    class Pair {
        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums, k)));
    }


}
