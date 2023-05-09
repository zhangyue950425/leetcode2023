package Hot100;

public class MaxArea {

    /**
     * 暴力法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        return max;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int max = 0;
        int left = 0, right = length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, area);
        }
        return max;
    }

    public static void main(String[] args) {
        // 1,8,6,2,5,4,8,3,7
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(height));
        System.out.println(maxArea.maxArea2(height));
        height = new int[] {1, 1};
        System.out.println(maxArea.maxArea(height));
        System.out.println(maxArea.maxArea2(height));
    }
}
