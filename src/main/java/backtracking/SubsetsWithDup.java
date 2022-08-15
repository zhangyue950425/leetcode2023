package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrace(0, nums);
        return result;
    }

    private void backtrace(int start, int[] nums) {
        result.add(new LinkedList<>(trace));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            trace.addLast(nums[i]);
            backtrace(i + 1, nums);
            trace.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup(nums));
    }
}
