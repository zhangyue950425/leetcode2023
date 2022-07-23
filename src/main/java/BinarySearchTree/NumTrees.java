package BinarySearchTree;

public class NumTrees {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private int count(int left, int right) {
        if (left > right) return 1;
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            int leftCount = count(left, i - 1);
            int rightCount = count(i + 1, right);
            res += leftCount * rightCount;
        }
        memo[left][right] = res;
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(n));
    }
}
