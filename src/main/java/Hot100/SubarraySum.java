package Hot100;

public class SubarraySum {

    /**
     * 暴力方法
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int sum = 0;
                for (int c = i; c <= j;c++) {
                    sum = sum + nums[c];
                }
                if (k == sum) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 暴力方法优化
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        int length = nums.length;
        // 前缀和数组，[0...i]所有元素之和，preSum[0]为0
        int[] preSum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int start = 0; start < length; start++) {
            for (int end = start; end < length; end++) {
                if (preSum[end + 1] - preSum[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1};
        int k = 2;
        SubarraySum subarraySum = new SubarraySum();
        //System.out.println(subarraySum.subarraySum(nums, k));
        //System.out.println(subarraySum.subarraySum2(nums, k));
        System.out.println(subarraySum.subarraySum3(nums, k));
        nums = new int[] {1,2,3};
        k = 3;
        //System.out.println(subarraySum.subarraySum(nums, k));
        //System.out.println(subarraySum.subarraySum2(nums, k));
        System.out.println(subarraySum.subarraySum3(nums, k));

    }
}
