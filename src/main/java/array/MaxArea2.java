package array;

public class MaxArea2 {
    public int maxArea(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int max = 0;
        int left = 0, right = length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        MaxArea2 maxArea = new MaxArea2();
        System.out.println(maxArea.maxArea(height));
    }
}
