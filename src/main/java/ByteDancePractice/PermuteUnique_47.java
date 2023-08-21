package ByteDancePractice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUnique_47 {

    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        boolean[] used = new boolean[length];
        backtrace(nums, new LinkedList<>(), used);
        return result;
    }

    private void backtrace(int[] nums, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            backtrace(nums, list, used);
            list.removeLast();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        PermuteUnique_47 permuteUnique_47 = new PermuteUnique_47();
        int[] nums = new int[] {2, 1, 1};
        System.out.println(permuteUnique_47.permuteUnique(nums));
        nums = new int[] {1, 2, 3};
        System.out.println(permuteUnique_47.permuteUnique(nums));
    }
}
