package ByteDancePractice;

public class MaxArea_11 {

    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0, right = length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxArea_11 maxArea11 = new MaxArea_11();
        int[] height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea11.maxArea(height));
        height = new int[] {1, 1};
        System.out.println(maxArea11.maxArea(height));
    }
}
