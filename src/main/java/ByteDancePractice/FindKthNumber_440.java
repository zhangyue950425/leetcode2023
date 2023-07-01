package ByteDancePractice;

public class FindKthNumber_440 {

    public int findKthNumber(int n, int k) {
        // 已经经过的元素个数, 开始一个元素都没有经过, 所以个数为 0
        int count = 0;
        // 第一个元素 (经过 i 个元素, 当前 num 是第 i + 1 元素)
        int num = 1;
        // 要找到第 k 个元素, 需要经过 k - 1 个元素
        while (true) {
            // 经过了 k - 1 个元素找到了第 k 个元素
            if (count == k - 1) {
                break;
            }
            int tem = count((long) num, n);
            // 以 num 为根的十叉树内有第 k 个元素
            if (count + tem >= k) {
                num = num * 10;
                count++;
            } else if (count + tem < k) {
                // 以 num 为根的十叉树内没有第 k 个元素
                num++;
                count = count + tem;
            }
        }
        return num;
    }

    /**
     * 以当前数字为根的十叉树的元素总个数(包括当前数字)
     * @param num 当前数字
     * @param n 数字的最大值
     * @return
     */
    private int count(long num, int n) {
        // 元素总个数
        int count = 0;
        // 当前层数的宽度, 第一层只有 num 一个元素, 所以第一层宽度为 1
        int width = 1;
        while (true) {
            // n 的值大于等于当前层的最大值, 说明当前层数的个数可以全部添加
            if (num + width - 1 <= n) {
                count = count + width;
                num = num * 10;
                width = width * 10;
            } else {
                // n 的值小于当前层的最大值则只能添加部分个数或者不添加, 并跳出循环
                if (n - num >= 0) {
                    count = count + n - (int) num + 1;
                }
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FindKthNumber_440 findKthNumber440 = new FindKthNumber_440();
        int n = 13;
        int k = 2;
        //System.out.println(findKthNumber440.findKthNumber(n, k));
        n = 110;
        k = 21;
        System.out.println(findKthNumber440.findKthNumber(n, k));
    }
}
