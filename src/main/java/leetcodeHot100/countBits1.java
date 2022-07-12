package leetcodeHot100;

import java.util.Arrays;

/**
 * @author zhangyue
 * @date 2022/4/23
 **/
public class countBits1 {

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int j = i;
            while (j > 0) {
                j = j & (j - 1);
                result[i] += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(countBits(n)));
        n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }
}
