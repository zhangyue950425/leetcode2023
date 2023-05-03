package offer;

public class MyPow {

    public double myPow(double x, int n) {
        int count = n > 0 ? n : -n;
        // double result = 1.0;
        /*for (int i = 0; i < count; i++) {
            result = result * x;
        }*/
        double result = pow(x, count);
        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }
    }

    public double myPow2(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    private double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        return x * pow(x, n - 1);
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow(x, n));
        n = -2;
        System.out.println(myPow.myPow(x, n));
        x = 1.00000;
        n = 2147483647;
        System.out.println(myPow.myPow(x, n));
        System.out.println(myPow.myPow2(x, n));
    }
}
