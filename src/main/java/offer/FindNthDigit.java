package offer;

public class FindNthDigit {
    public int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit = digit + 1;
            start = start * 10;
            count = 9 * digit * start;
        }
        // 具体数字
        long num = start + (n - 1) / digit;
        // 具体哪位
        int pos = (n - 1) % digit;
        return Long.toString(num).charAt(pos) - '0';
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        int n = 15;
        System.out.println(findNthDigit.findNthDigit(n));
        n = 10;
        System.out.println(findNthDigit.findNthDigit(n));
        n = 1000000000;
        System.out.println(findNthDigit.findNthDigit(n));
    }
}
