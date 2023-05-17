package Hot100;

import java.util.Arrays;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 */
public class DailyTemperatures {

    /**
     * 暴力方法，超时
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int num1 = temperatures[i];
            for (int j = i + 1; j < length; j++) {
                int num2 = temperatures[j];
                if (num2 > num1) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 减少遍历次数
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        // 最后一个元素的值肯定是0
        int[] next = new int[length];
        // 所以从倒数第二个开始遍历处理
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length;) {
                if (temperatures[i] < temperatures[j]) {
                    next[i] = j - i;
                    break;
                } else {
                    // 当前元素比后一个要大，那要看后面那个元素比他大的数，拿到那个值再比较大小
                    // 但是如果后面那个元素没有比他大的数，那就更没有比当前元素大的数了
                    if (next[j] == 0) {
                        next[i] = 0;
                        break;
                    } else {
                        j = j + next[j];
                    }
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        //System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures2(temperatures)));
        temperatures = new int[]{30,60,90};
        //System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures2(temperatures)));
    }
}
