package leetcodeHot100;

import java.util.*;

/**
 * 课程表:
 * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，
 * 其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
 * <p>
 * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 存放课程对应的入度值
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化
        for (int i = 0; i < numCourses; i++) {
            map.put(i, 0);
        }
        // 依赖关系
        Map<Integer, List<Integer>> deMap = new HashMap<>();
        // 初始化入度和依赖关系
        for (int[] pre : prerequisites) {
            int back = pre[0];
            int front = pre[1];
            map.put(back, map.get(back) + 1);
            if (!deMap.containsKey(front)) {
                deMap.put(front, new ArrayList<>());
            }
            deMap.get(front).add(back);
        }
        // 入度为0的入队
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 0) {
                count++;
                queue.offer(key);
            }
        }
        // 出队
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!deMap.containsKey(node)) {
                continue;
            }
            List<Integer> list = deMap.get(node);
            for (Integer num : list) {
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    count++;
                    queue.offer(num);
                }
            }
        }
        return count == numCourses;

    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        CanFinish canFinish = new CanFinish();
        System.out.println(canFinish.canFinish(numCourses, prerequisites));
        prerequisites = new int[][]{{1, 0}, {0, 1}};
        System.out.println(canFinish.canFinish(numCourses, prerequisites));
    }
}
