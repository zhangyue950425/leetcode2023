package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, 0);
        return result;
    }

    private void backtrace(int[] nums, int start) {
        result.add(new LinkedList<>(trace));
        for (int i = start; i < nums.length; i++) {
            trace.addLast(nums[i]);
            backtrace(nums, i+ 1);
            trace.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(nums));
    }
}
