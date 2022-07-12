package leetcodeHot100;

import java.util.Arrays;

/**
 * @author zhangyue
 * @date 2022/4/23
 * 比特位计数：
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
 * 计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 **/
public class countBits {

    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            char[] array = Integer.toBinaryString(i).toCharArray();
            for (char c : array) {
                if (c == '1') {
                    result[i] += 1;
                }
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
