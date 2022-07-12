package leetcodeHot100;

/**
 * @author zhangyue
 * @date 2022/4/18
 * 汉明距离:
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * <p>
 * 输入：x = 1, y = 4
 * 输出：2
 * 解释：
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * <p>
 * 输入：x = 3, y = 1
 * 输出：1
 * <p>
 * 位运算：异或 与运算
 **/
public class hammingDistance {

    public static int hammingDistance(int x, int y) {
        /*char[] xBytes = Integer.toBinaryString(x).toCharArray();
        char[] yBytes = Integer.toBinaryString(y).toCharArray();
        int length = Math.min(xBytes.length, yBytes.length);
        int size = 0;
        for (int i = 0; i< length; i++) {
            if (xBytes[i] != yBytes[i]) {
                size++;
            }
        }
        size = size + (xBytes.length > yBytes.length ? (xBytes.length - yBytes.length) : (yBytes.length - xBytes.length));
        return size;*/
        int result = x ^ y;
        int count = 0;
        while (result != 0) {
            result = result & (result - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int val1 = 1;
        int val2 = 4;
        System.out.println(hammingDistance(val1, val2));
        val1 = 3;
        val2 = 1;
        System.out.println(hammingDistance(val1, val2));
        val1 = 4;
        val2 = 14;
        System.out.println(hammingDistance(val1, val2));
    }
}
