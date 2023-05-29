package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquares {

    /**
     * 动态规划，二维数组
     * @param n
     * @return
     */
    public int numSquares(int n) {
        // 先求出n以内的完全平方数，后面选择数字都是从这些数字里面选择
        List<Integer> list = new ArrayList<>();
        int index = 1;
        while (index * index <= n) {
            list.add(index * index);
            index++;
        }
        // 从所有数字中挑选拼凑出和等于n的最少数量，可以挑选多次，也可能拼不出n
        int length = list.size();
        // dp[i][j]定义为从前i个数字中挑选能拼凑和为j的最少数字数量，数字可以挑选多次
        int[][] dp = new int[length][n + 1];
        // dp初始化,用第一个数拼凑和为0到n
        for (int i = 0; i <= n; i++) {
            int num = list.get(0);
            int count = i / num;
            if (count * num == i) {
                // 用第一个数可以拼凑出和为i
                dp[0][i] = count;
            } else {
                // 用第一个数拼凑不出来
                dp[0][i] = -1;
            }
        }
        // 再求其他数字的拼凑结果,从第二个数字开始拼凑
        for (int i = 1; i < list.size(); i++) {
            // 需要拼凑和为j
            for (int j = 0; j <= n; j++) {
                // 不选择这个数字的话
                dp[i][j] = dp[i - 1][j];
                // 选择这个数字，可能选择多次
                int num = list.get(i);
                for (int k = 1; k * num <= j; k++) {
                    // 只有在dp[i - 1][j - k * num]可以拼凑的时候再处理dp[i][j]
                    if ( dp[i - 1][j - k * num] != -1) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * num] + k);
                    }
                }
            }
        }
        // 返回用前length-1个数字拼凑和为n的最少数字个数，因为第一个数是dp[0][j]开始的
        return dp[length - 1][n];
    }

    /**
     * 动态规划，一维数组
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int INF = 0x3f3f3f3f;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        int index = 1;
        List<Integer> list = new ArrayList<>();
        while (index * index <= n) {
            list.add(index * index);
            index++;
        }
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            for (int j = num; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - num] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(n));
        System.out.println(numSquares.numSquares2(n));
        n = 13;
        System.out.println(numSquares.numSquares(n));
        System.out.println(numSquares.numSquares2(n));
    }
}
