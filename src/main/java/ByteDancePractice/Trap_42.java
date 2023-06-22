package ByteDancePractice;

import java.util.Stack;

public class Trap_42 {

    /**
     * 按行遍历：从第一行开始计算水，一直到最高层
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int max = getMax(height);
        int length = height.length;
        int result = 0;
        for (int i = 1; i <= max; i++) {
            int temp = 0;
            boolean start = false;
            for (int j = 0; j < length; j++) {
                if (start && height[j] < i) {
                    temp = temp + 1;
                }
                if (height[j] >= i) {
                    result = result + temp;
                    temp = 0;
                    start = true;
                }
            }
        }
        return result;
    }

    /**
     * 求最高的高度
     * @param height
     * @return
     */
    private int getMax(int[] height) {
        int max = height[0];
        int length = height.length;
        for (int i = 1; i < length; i++) {
            max = Math.max(max, height[i]);
        }
        return max;
    }

    /**
     * 按列求每列可以接的水的单位，第一列和最后一列是肯定不能接到水的，因为其左右没有高度
     * 每一列接水的量主要取决于左边最高的高度和右边最高的高度
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int result = 0;
        int length = height.length;
        for (int i = 1; i < length - 1; i++) {
           // 求左边的最高高度
           int left = 0;
           for (int j = 0; j <= i - 1; j++) {
               left = Math.max(left, height[j]);
           }
           // 求右边的最高高度
            int right = 0;
           for (int j = i + 1; j < length; j++) {
               right = Math.max(right, height[j]);
           }
           //取决于短板
           int min = Math.min(left, right);
           if (height[i] < min) {
               result = result + (min - height[i]);
           }
        }
        return result;
    }

    /**
     * 动态规划先求出每列的左边最高高度，每列右边的最高高度
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int length = height.length;
        // max_left[i]表示第i列左边最高高度，值是通过计算第i-1列的高度和第i-1列的左边最高高度中的最大值
        int[] max_left = new int[length];
        // max_right[i]表示第i列右边最高高度，值是通过计算第i+1列的高度和第i+1列的右边最高高度中的最大值
        int[] max_right = new int[length];
        for (int i = 1; i < length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        int result = 0;
        for (int i = 1; i < length - 1; i++) {
            int left = max_left[i];
            int right = max_right[i];
            int min = Math.min(left, right);
            if (height[i] < min) {
                result = result + (min - height[i]);
            }
        }
        return result;
    }

    /**
     * 栈
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int length = height.length;
        int index = 0;
        int result = 0;
        while (index < length) {
            while (!stack.isEmpty() && height[index] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = index - stack.peek() - 1;
                int min = Math.min(height[index], height[stack.peek()]);
                result = result + distance * (min - h);
            }
            stack.push(index);
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Trap_42 trap_42 = new Trap_42();
        int[] height = new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //System.out.println(trap_42.trap(height));
        System.out.println(trap_42.trap2(height));
        System.out.println(trap_42.trap3(height));
        System.out.println(trap_42.trap4(height));
        height = new int[] {4, 2, 0, 3, 2, 5};
        //System.out.println(trap_42.trap(height));
        System.out.println(trap_42.trap2(height));
        System.out.println(trap_42.trap3(height));
        System.out.println(trap_42.trap4(height));
    }
}
