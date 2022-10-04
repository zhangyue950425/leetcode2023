package array;

public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] nums, int k) {
        int length = nums.length;
        int max = -1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = nums[i] + nums[j];
                if (sum >= k) {
                } else {
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34,23,1,24,75,33,54,8};
        int k = 60;
        TwoSumLessThanK twoSumLessThanK = new TwoSumLessThanK();
        System.out.println(twoSumLessThanK.twoSumLessThanK(nums, k));
    }
}
