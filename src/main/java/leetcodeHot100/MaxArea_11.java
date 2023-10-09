package leetcodeHot100;

public class MaxArea_11 {

    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;
        int i = 0, j = length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea_11 maxArea11 = new MaxArea_11();
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea11.maxArea(height));
        height = new int[] {1,1};
        System.out.println(maxArea11.maxArea(height));
    }
}
