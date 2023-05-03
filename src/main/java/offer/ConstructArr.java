package offer;

import java.util.Arrays;

public class ConstructArr {

    public int[] constructArr(int[] a) {
        int length = a.length;
        if (length == 0) {
            return new int[]{};
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int sum = 1;
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                } else {
                    sum = sum * a[j];
                }
            }
            result[i] = sum;
        }
        return result;
    }

    public int[] constructArr2(int[] a) {
        int length = a.length;
        if (length == 0) {
            return new int[]{};
        }
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = a[i - 1] * result[i - 1];
        }
        int temp = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp = temp * a[i + 1];
            result[i] = result[i] * temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(new ConstructArr().constructArr(a)));
        System.out.println(Arrays.toString(new ConstructArr().constructArr2(a)));
    }
}
