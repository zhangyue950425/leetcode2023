package ByteDancePractice;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute_46_2 {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        boolean[] used = new boolean[length];
        backtrace(nums, new LinkedList<>(), used);
        return result;
    }

    private void backtrace(int[] nums, LinkedList<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
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
        Permute_46_2 permute_46_2 = new Permute_46_2();
        int[] nums = new int[] {1, 2, 3};
        System.out.println(permute_46_2.permute(nums));
    }
}
