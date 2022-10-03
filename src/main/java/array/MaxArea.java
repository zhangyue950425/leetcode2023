package array;

public class MaxArea {

    public int maxArea(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        //List<Integer> result = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(max, area);
            }
        }
        /*int max = result.get(0);
        for (Integer area : result) {
            max = Math.max(max, area);
        }*/
        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(height));
    }
}
