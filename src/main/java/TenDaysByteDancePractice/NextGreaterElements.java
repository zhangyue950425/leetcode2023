package TenDaysByteDancePractice;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        if (length == 1) {
            result[0] = -1;
            return result;
        }
        for (int i = 0; i < length; i++) {
            // 针对每个索引位置数字寻找下一个更大的数字，每个数字寻找length - 1次，找不到就是-1
            int index = i;
            int count = 0;
            boolean flag = false;
            while (true) {
                if (count == length - 1) {
                    flag = true;
                    break;
                }
                count++;
                int next = (index + 1) % length;
                if (nums[next] > nums[i]) {
                    result[i] = nums[next];
                    break;
                } else {
                    index++;
                }
            }
            // 没找到
            if (flag) {
                result[i] = -1;
            }
        }
        return result;
    }

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
       int length = nums.length;
       int[] result = new int[length];
       Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length * 2; i++) {
            int index = i % length;
            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                int num = stack.pop();
                result[num] = nums[index];
            }
            stack.push(index);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,1};
        NextGreaterElements nextGreaterElements = new NextGreaterElements();
        //System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(nums)));
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements2(nums)));
        nums = new int[] {1,2,3,4,3};
        //System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements(nums)));
        System.out.println(Arrays.toString(nextGreaterElements.nextGreaterElements2(nums)));
    }
}
