package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrace(nums, 0, used, new LinkedList<>());
        return result;
    }

    private void backtrace(int[] nums, int index, boolean[] used, LinkedList<Integer> linkedList) {
        if (linkedList.size() == nums.length) {
            result.add(new LinkedList<>(linkedList));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            linkedList.addLast(nums[i]);
            backtrace(nums, index, used, linkedList);
            linkedList.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permute permute = new Permute();
        System.out.println(permute.permute(nums));
    }
}
