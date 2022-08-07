package backtracking;

import java.util.HashMap;

public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 如果数组之和不能整除k，则肯定为false，可以再看具体分组
        int sum = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++){
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        // k大于length则不存在空集合
        if (k > length) return false;
        // 使用位图
        int used = 0;
        int target = sum / k;
        // 从nums[0]开始做选择
        return backtrack(k, 0, nums, 0, used, target);
    }

    HashMap<Integer, Boolean> memo = new HashMap<>();
    private boolean backtrack(int k, int bucket, int[] nums, int start, int used, int target) {
        if (k == 0) {
            // 所有桶都装满了，而且nums一定都用完了
            return true;
        }
        if (bucket == target) {
            boolean res = backtrack(k - 1, 0, nums, 0, used, target);
            memo.put(used, res);
            return res;
        }
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            // 判断第i位是不是1
            if (((used >> i) & 1) == 1) {
                // nums[i]已经放入到别的桶了
                continue;
            }
            if (nums[i] + bucket > target) {
                continue;
            }
            // 做选择
            used |= 1 << i;// 将第i位置为1
            bucket += nums[i];
            // 递归穷举下一个数字是否装入当前桶
            if (backtrack(k, bucket, nums, i + 1, used, target)) {
                return true;
            }
            // 撤销选择
            // 使用异或运算将第i位恢复为0
            used ^= 1 << i;
            bucket -= nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        CanPartitionKSubsets canPartitionKSubsets = new CanPartitionKSubsets();
        int [] nums = new int[]{4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(canPartitionKSubsets.canPartitionKSubsets(nums, k));
    }
}
