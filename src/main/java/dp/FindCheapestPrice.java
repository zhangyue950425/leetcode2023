package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindCheapestPrice {
    int src, dst;
    // 备忘录
    int[][] memo;
    HashMap<Integer, List<int[]>> indegree;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 转化为边数
        k++;
        this.src = src;
        this.dst = dst;
        // 初始化备忘录，全部填⼀个特殊值
        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -888);
        }
        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            // 记录谁指向该节点，以及之间的权重
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }
        return dp(dst, k);
    }

    /**
     * 定义：从 src 出发，k 步之内到达 s 的最短路径权重
     * @param s
     * @param k
     * @return
     */
    private int dp(int s, int k) {
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }
        if (memo[s][k] != -888) {
            return memo[s][k];
        }
        // 初始化为最⼤值
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            // 当 s 有⼊度节点时，分解为⼦问题
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                // 从 src 到达相邻的⼊度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);
                // 跳过⽆解的情况
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 如果还是初始值，说明此节点不可达
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }

    public static void main(String[] args) {
        // n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
        // src = 0, dst = 2, k = 1
        int n = 3;
        int[][] flights = new int[][]{{0,1,100}, {1,2,100}, {0,2,500}};
        int src = 0;
        int dst = 2;
        int k = 1;
        FindCheapestPrice findCheapestPrice = new FindCheapestPrice();
        System.out.println(findCheapestPrice.findCheapestPrice(n, flights, src, dst, k));
    }
}
