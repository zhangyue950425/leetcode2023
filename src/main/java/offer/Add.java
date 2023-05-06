package offer;

public class Add {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1; // c为进位
            a = a ^ b;            // a为非进位和
            b = c;                // 进位
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        Add add = new Add();
        System.out.println(add.add(a, b));
        a = 3;
        b = -8;
        System.out.println(add.add(a, b));
    }
}
