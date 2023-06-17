package ByteDancePractice;

public class Reverse {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int num = x % 10;
            result = result * 10 + num;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        int x = 123;
        //System.out.println(reverse.reverse(x));
        /*x = -123;
        System.out.println(reverse.reverse(x));
        x = 120;
        System.out.println(reverse.reverse(x));
        x = 0;
        System.out.println(reverse.reverse(x));*/
        x = 1534236469;
        System.out.println(reverse.reverse(x));
        x = 534236469;
        System.out.println(reverse.reverse(x));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
