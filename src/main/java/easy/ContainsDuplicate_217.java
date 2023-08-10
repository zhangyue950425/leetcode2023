package easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate_217 {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                map.put(nums[i], ++count);
                if (map.get(nums[i]) >= 2) {
                    return true;
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate_217 containsDuplicate217 = new ContainsDuplicate_217();
        int[] nums = new int[] {1,2,3,1};
        System.out.println(containsDuplicate217.containsDuplicate(nums));
        nums = new int[] {1,2,3,4};
        System.out.println(containsDuplicate217.containsDuplicate(nums));
        nums = new int[] {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate217.containsDuplicate(nums));
    }
}
