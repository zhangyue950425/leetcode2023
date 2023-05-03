package offer;

import java.util.Arrays;

public class MinNumber {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x) );
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if ((strs[j] + strs[j + 1]).compareTo((strs[j + 1] + strs[j])) > 0) {
                    String tmp = strs[j];
                    strs[j] = strs[j + 1];
                    strs[j + 1] = tmp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MinNumber minNumber = new MinNumber();
        int[] arr = new int[]{3,30,34,5,9};
        System.out.println(minNumber.minNumber(arr));
        System.out.println(minNumber.minNumber2(arr));
    }
}
