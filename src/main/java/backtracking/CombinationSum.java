package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        backtrace(candidates, 0, target);
        return result;

    }

    private void backtrace(int[] candidates, int start, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new LinkedList<>(trace));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            trace.addLast(candidates[i]);
            backtrace(candidates, i, target);
            sum -= candidates[i];
            trace.removeLast();
        }

    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum.combinationSum(candidates, target));
    }
}
