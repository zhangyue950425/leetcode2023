package ByteDancePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute_46 {

    List<List<Integer>> result = new ArrayList<>();
    boolean[] choose;
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        choose = new boolean[length];
        dfs(nums, new LinkedList<>());
        return result;
    }

    private void dfs(int[] nums, LinkedList<Integer> linkedList) {
        if (linkedList.size() == nums.length) {
            result.add(new ArrayList<>(linkedList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (choose[i]) {
                continue;
            }
            choose[i] = true;
            linkedList.addLast(nums[i]);
            dfs(nums, linkedList);
            linkedList.removeLast();
            choose[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute_46 permute46 = new Permute_46();
        int[] nums = new int[] {1, 2, 3};
        System.out.println(permute46.permute(nums));
    }
}
