package ByteDancePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup_90 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrace(nums, new ArrayList<>(), 0);
        return result;
    }

    private void backtrace(int[] nums, List<Integer> list, int index) {
        if (index > nums.length) {
            return;
        }
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrace(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup_90 subsetsWithDup_90 = new SubsetsWithDup_90();
        int[] nums = new int[] {1, 2, 2};
        System.out.println(subsetsWithDup_90.subsetsWithDup(nums));
    }
}
