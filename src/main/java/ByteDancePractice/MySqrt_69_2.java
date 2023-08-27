package ByteDancePractice;

public class MySqrt_69_2 {

    public int mySqrt(int x) {
        if (x == 1) {
            return x;
        }
        for (int i = 1; i <= (x / 2); i++) {
            int num = i * i;
            if (num == x) {
                return i;
            }
            if (x / i >= i && x / (i + 1) < (i + 1)) {
                return i;
            }
        }
        return x / 2;
    }

    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
       if (x == 1) {
           return 1;
       }
       int left = 1;
       int right = x / 2;
       while (left <= right) {
           int mid = (left + right) / 2;
           if (x / mid >= mid && x / (mid + 1) < (mid + 1)) {
               return mid;
           } else if (x / mid < mid) {
               right = mid - 1;
           } else {
               left = mid + 1;
           }
       }
       return x / 2;
    }

    public static void main(String[] args) {
        MySqrt_69_2 mySqrt_69_2 = new MySqrt_69_2();
        int x = 4;
        System.out.println(mySqrt_69_2.mySqrt(x));
        System.out.println(mySqrt_69_2.mySqrt2(x));
        x = 8;
        System.out.println(mySqrt_69_2.mySqrt(x));
        System.out.println(mySqrt_69_2.mySqrt2(x));
        x = 1;
        System.out.println(mySqrt_69_2.mySqrt(x));
        System.out.println(mySqrt_69_2.mySqrt2(x));
        x = 2147483647;
        System.out.println(mySqrt_69_2.mySqrt(x));
        System.out.println(mySqrt_69_2.mySqrt2(x));
        x = 10;
        System.out.println(mySqrt_69_2.mySqrt(x));
        System.out.println(mySqrt_69_2.mySqrt2(x));
    }
}
