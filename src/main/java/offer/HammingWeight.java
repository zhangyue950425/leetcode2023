package offer;

public class HammingWeight {

    public int hammingWeight(int n) {
        int count = 0;
        int factor = 1;
        while (n != 0) {
            if ((n & factor) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 0b00000000000000000000000000001011;
        HammingWeight hammingWeight = new HammingWeight();
        //System.out.println(hammingWeight.hammingWeight(n));
        System.out.println(hammingWeight.hammingWeight2(n));
        n = 0b00000000000000000000000010000000;
        //System.out.println(hammingWeight.hammingWeight(n));
        System.out.println(hammingWeight.hammingWeight2(n));
        n = 0b11111111111111111111111111111101;
        System.out.println(hammingWeight.hammingWeight2(n));
    }
}
