package leetcodeHot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyue
 * @date 2022/4/18
 * 多数元素:
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 **/
public class majorityElement {

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Map.Entry<Integer, Integer> majorityElementEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityElementEntry == null || majorityElementEntry.getValue() <= entry.getValue()) {
                majorityElementEntry = entry;
            }
        }
        return majorityElementEntry.getKey();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        int[] nums1 = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(nums1));
    }
}
