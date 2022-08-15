package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(0, candidates, target);
        return result;
    }

    private void backtrace(int start, int[] nums, int target) {
        if (sum == target) {
            result.add(new LinkedList<>(trace));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            sum += nums[i];
            trace.addLast(nums[i]);
            backtrace(i + 1, nums, target);
            trace.removeLast();
            sum -= nums[i];
        }
    }

    public static void main(String[] args) {
        // candidates = [10,1,2,7,6,1,5], target = 8
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(candidates, target));
    }
}
