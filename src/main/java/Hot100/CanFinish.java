package Hot100;

import java.util.*;

public class CanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int row = prerequisites.length;
        if (row == 0) {
            return true;
        }
        int col = prerequisites[0].length;
        if (col == 0) {
            return false;
        }
        // 保存所有课程的入度，数组索引小标就是对应那么课程，入度+1说明是该课程所依赖的课程加一
        int[] indegree = new int[numCourses];
        // lists保存某个节点的邻接点，表示该课程有哪些课程以来这门课程,如：1->2,1->3，课程2和3都依赖课程1完成才能完成，记录1的列表包括2和3
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < row; i++) {
            // 入度+1
            indegree[prerequisites[i][0]]++;
            List<Integer> list = lists.get(prerequisites[i][1]);
            list.add(prerequisites[i][0]);
            lists.set(prerequisites[i][1], list);
        }
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的入队，表示不需要前置课程的课程
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            numCourses--;
            // 关联节点需要入度减一
            List<Integer> list = lists.get(node);
            for (int i = 0; i < list.size(); i++) {
                indegree[list.get(i)]--;
                if (indegree[list.get(i)] == 0) {
                    queue.offer(list.get(i));
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        // 输入：numCourses = 2, prerequisites = [[1,0]]
        // 输出：true
        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        // 输出：false
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        CanFinish canFinish = new CanFinish();
        //System.out.println(canFinish.canFinish(numCourses, prerequisites));
        prerequisites = new int[][]{{1,0},{0,1}};
        numCourses  =2;
        //System.out.println(canFinish.canFinish(numCourses, prerequisites));
        numCourses = 1;
        prerequisites = new int[][]{};
        System.out.println(canFinish.canFinish(numCourses, prerequisites));
    }
}
