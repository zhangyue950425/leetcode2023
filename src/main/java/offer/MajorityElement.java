package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
           Integer count = map.getOrDefault(nums[i], 0);
           map.put(nums[i], ++count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= (length / 2 + 1)) {
                return entry.getKey();
            }
        }
        return nums[length - 1];
    }

    public int majorityElement2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int votes = 0, x = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(nums));
        System.out.println(majorityElement.majorityElement2(nums));
    }
}
