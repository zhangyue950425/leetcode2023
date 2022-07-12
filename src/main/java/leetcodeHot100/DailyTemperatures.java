package leetcodeHot100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 每日温度:
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]
 * 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = i + 1; j < length; j++) {
                if (temperatures[i] < temperatures[j]) {
                    if (count == 0) {
                        result[i] = 1;
                    } else {
                        result[i] = ++count;
                    }
                    break;

                } else {
                    count++;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && temperatures[i] > temperatures[deque.peek()]) {
                Integer index = deque.pop();
                result[index] = i - index;
            }
            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures1(temperatures)));
        temperatures = new int[]{30, 40, 50, 60};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures1(temperatures)));
        temperatures = new int[]{30, 60, 90};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures1(temperatures)));

    }
}
