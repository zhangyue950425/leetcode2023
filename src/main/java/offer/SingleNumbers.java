package offer;

import java.util.Arrays;

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for (int i : nums) {
            n = n ^ i;
        }
        while ((n & m) == 0) {
            m = m << 1;
        }
        for (int num : nums) {
            if ((num & m) != 0) x = x ^ num;
            else y = y ^ num;
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        SingleNumbers singleNumbers = new SingleNumbers();
        int[] nums = new int[]{1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(singleNumbers.singleNumbers(nums)));
    }
}
