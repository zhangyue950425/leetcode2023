package Hot100;

public class NumTrees {

    public int numTrees(int n) {
        // n个节点对应有几个二叉搜索树，节点的值是从1到n
        int[] dp = new int[n + 1];
        dp[0] = 1; // ?dp[0]设置为0的话会导致很多都计算为0
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 计算i个节点的所有二叉搜索树的个数，循环以每个节点作为根节点计算，然后所有可能相加
            for (int j = 1; j < i + 1; j++) {
                // 以j的值为根节点的二叉搜索树个数，以j的值为根节点的话，左子树节点个数为j-1，右子树节点字数为i - j
                int f = dp[j - 1] * dp[i - j];
                dp[i] = dp[i] + f;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(n));
        n = 4;
        System.out.println(numTrees.numTrees(n));
    }
}
