package offer;

public class SumNums {

    public int sumNums(int n) {
        return sum(n);
    }

    private int sum(int n) {
        boolean x = n > 0 && (n = n + sum(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        int n = 9;
        SumNums sumNums = new SumNums();
        System.out.println(sumNums.sumNums(n));
    }
}
