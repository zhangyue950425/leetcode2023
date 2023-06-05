package TenDaysByteDancePractice;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class WidthOfBinaryTree {

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
     * BFS，节点编号
     * @param root
     * @return
     */
    public static int widthOfBinaryTree(TreeNode root) {
        int max = 1;
        List<Pair<TreeNode, Integer>> list = new ArrayList<>();
        // 给根节点编号为1，左子节点位2 * 1，右子节点编号为2 * 1 + 1
        list.add(new Pair<>(root, 1));
        while (!list.isEmpty()) {
            List<Pair<TreeNode, Integer>> list1 = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : list) {
                TreeNode node = pair.getKey();
                Integer index = pair.getValue();
                if (node.left != null) {
                    list1.add(new Pair<>(node.left, index * 2));
                }
                if (node.right != null) {
                    list1.add(new Pair<>(node.right, index * 2 + 1));
                }
            }
            max = Math.max(max, list.get(list.size() - 1).getValue() - list.get(0).getValue() + 1);
            list = list1;
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(7);
        System.out.println(WidthOfBinaryTree.widthOfBinaryTree(root));
    }
}
