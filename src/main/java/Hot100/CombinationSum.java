package Hot100;

import java.util.*;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrace(candidates, 0, target, new LinkedList<>());
        return result;
    }

    private void backtrace(int[] candidates, int index, int target, LinkedList<Integer> linkedList) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new LinkedList<>(linkedList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            linkedList.addLast(candidates[i]);
            System.out.println("递归之前 => " + linkedList + "，剩余 = " + (target - candidates[i]));
            backtrace(candidates, i, target - candidates[i], linkedList);
            linkedList.removeLast();
            System.out.println("递归之后 => " + linkedList);
        }
    }

    /**
     * 排序剪枝
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace2(candidates, 0, target, new LinkedList<>());
        return result;
    }

    private void backtrace2(int[] candidates, int index, int target, LinkedList<Integer> linkedList) {
        if (target == 0) {
            result.add(new LinkedList<>(linkedList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            linkedList.addLast(candidates[i]);
            backtrace2(candidates, i, target - candidates[i], linkedList);
            linkedList.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        //System.out.println(combinationSum.combinationSum(candidates, target));
        System.out.println("输出 => " + combinationSum.combinationSum(candidates, target));
        //System.out.println(combinationSum.combinationSum2(candidates, target));
    }
}
