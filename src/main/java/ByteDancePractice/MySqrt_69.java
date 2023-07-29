package ByteDancePractice;

public class MySqrt_69 {

    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        if (x <= 3) {
            return 1;
        }
        int left = 1;
        int right = x / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                // mid < x / mid
                left = mid + 1;
            }
        }
        return 0;
    }

    /**
     * 暴力遍历法
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x == 0) {
            return x;
        }
        int count = x / 2;
        int result = 1;
        for (int i = 1; i <= count; i++) {
            if (i * i == x) {
                return i;
            }
            if (i * i < x && (i + 1) * (i + 1) > x) {
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MySqrt_69 mySqrt69 = new MySqrt_69();
        int x = 4;
        //System.out.println(mySqrt69.mySqrt(x));
        System.out.println(mySqrt69.mySqrt(x));
        x = 8;
        //System.out.println(mySqrt69.mySqrt(x));
        System.out.println(mySqrt69.mySqrt(x));
        x = 3;
        System.out.println(mySqrt69.mySqrt(x));
        x = 2147483647;
        System.out.println(mySqrt69.mySqrt(x));
    }
}
