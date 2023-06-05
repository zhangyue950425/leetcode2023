package TenDaysByteDancePractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumEffortPath {

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        if (row == 1 && col == 1) {
            return 0;
        }
        // dp[i][j]表示从(0,0)位置到(i,j)为止最少体力消耗值
        int[][] dp = new int[row][col];
        dp[0][0] = heights[0][0];
        for (int i = 1; i < row; i++) {
            // 只有上的方向
            int upMax = Math.max(dp[i - 1][0], Math.abs(heights[i][0] - heights[i - 1][0]));
            dp[i][0] = upMax;
        }
        for (int i = 1; i < col; i++) {
            // 只有左的方向
            int leftMax = Math.max(dp[0][i - 1], Math.abs(heights[0][i] - heights[0][i - 1]));
            dp[0][i] = leftMax;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int upMax = Math.max(dp[i - 1][j], Math.abs(heights[i][j] - heights[i - 1][j]));
                int leftMax = Math.max(dp[i][j - 1], Math.abs(heights[i][j] - heights[i][j - 1]));
                dp[i][j] = Math.min(upMax, leftMax);
            }
        }
        return dp[row - 1][col - 1];
    }
    int N = 10009;
    int[] p = new int[N];
    int row, col;

    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    boolean query(int a, int b) {
        return p[find(a)] == p[find(b)];
    }
    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
    public int minimumEffortPath2(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        // 初始化并查集
        for (int i = 0; i < row * col; i++) {
            p[i] = i;
        }
        // 预处理出所有的边
        // edge 存的是 [a, b, w]：代表从 a 到 b 的体力值为 w
        // 虽然我们可以往四个方向移动，但是只要对于每个点都添加「向右」和「向下」两条边的话，其实就已经覆盖了所有边了
        List<int[]> edges = new ArrayList<>();
        for (int i = 0;i < row; i++) {
            for (int j = 0; j < col; j++) {
                int idx = getIndex(i, j);
                if (i + 1 < row) {
                    int a = idx, b = getIndex(i + 1, j);
                    int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                    edges.add(new int[]{a, b, w});
                }
                if (j + 1 < col) {
                    int a = idx, b = getIndex(i, j + 1);
                    int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                    edges.add(new int[]{a, b, w});
                }
            }
        }
        // 根据权值 w 降序
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        // 从「小边」开始添加，当某一条边别应用之后，恰好使用得「起点」和「结点」联通
        // 那么代表找到了「最短路径」中的「权重最大的边」
        int start = getIndex(0, 0), end = getIndex(row - 1, col - 1);
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            union(a, b);
            if (query(start, end)) {
                return w;
            }
        }
        return 0;
    }

    int getIndex(int x, int y) {
        return x * col + y;
    }

    public static void main(String[] args) {
        // 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
        // 输出：2
        int[][] heights = new int[][]{{1,2,2}, {3,8,2}, {5,3,5}};
        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        //System.out.println(minimumEffortPath.minimumEffortPath(heights));
        System.out.println(minimumEffortPath.minimumEffortPath2(heights));
        // 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
        // 输出：1
        heights = new int[][]{{1,2,3}, {3,8,4}, {5,3,5}};
        //System.out.println(minimumEffortPath.minimumEffortPath(heights));
        System.out.println(minimumEffortPath.minimumEffortPath2(heights));
        // 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
        // 输出：0
        heights = new int[][]{{1,2,1,1,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,2,1,2,1}, {1,1,1,2,1}};
        //System.out.println(minimumEffortPath.minimumEffortPath(heights));
        System.out.println(minimumEffortPath.minimumEffortPath2(heights));
        heights = new int[][]{{3}};
        //System.out.println(minimumEffortPath.minimumEffortPath(heights));
        System.out.println(minimumEffortPath.minimumEffortPath2(heights));
        heights = new int[][]{{1,10,6,7,9,10,4,9}};
        //System.out.println(minimumEffortPath.minimumEffortPath(heights));
        System.out.println(minimumEffortPath.minimumEffortPath2(heights));
    }
}
