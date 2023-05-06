package offer;

import java.util.Arrays;

public class PrintNumbers {
    public int[] printNumbers(int n) {
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s = s * 10;
        }
        int[] result = new int[s - 1];
        for (int i = 0; i < s - 1; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        // n为1返回[1,2,3,4,5,6,7,8,9]
        int n = 1;
        PrintNumbers printNumbers = new PrintNumbers();
        System.out.println(Arrays.toString(printNumbers.printNumbers(n)));
        n = 2;
        System.out.println(Arrays.toString(printNumbers.printNumbers(n)));
        n = 3;
        System.out.println(Arrays.toString(printNumbers.printNumbers(n)));
    }
}
