package ByteDancePractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView_199 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    /**
     * bfs,每层最右的节点元素
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        queue.offer(temp);
        List<List<Integer>> lists = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = queue.poll();
            List<Integer> list = new LinkedList<>();
            List<TreeNode> nodeList = new LinkedList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.get(i);
                list.add(node.val);
                if (node.left != null) {
                    nodeList.add(node.left);
                }
                if (node.right != null) {
                    nodeList.add(node.right);
                }
            }
            if (!nodeList.isEmpty()) {
                queue.offer(nodeList);
            }
            lists.add(list);
        }
        for (List<Integer> list : lists) {
            result.add(list.get(list.size() - 1));
        }
        return result;
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public static List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }

    /**
     * DFS
     * @param root
     * @return
     */
    static List<Integer> result = new ArrayList<>();
    public static List<Integer> rightSideView3(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private static void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        //System.out.println(RightSideView_199.rightSideView(root));
        //System.out.println(RightSideView_199.rightSideView2(root));
        System.out.println(RightSideView_199.rightSideView3(root));
        root = new TreeNode(1);
        root.left = new TreeNode(3);
        //System.out.println(RightSideView_199.rightSideView(root));
        //System.out.println(RightSideView_199.rightSideView2(root));
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        //System.out.println(RightSideView_199.rightSideView(root));
        //System.out.println(RightSideView_199.rightSideView2(root));
    }
}
