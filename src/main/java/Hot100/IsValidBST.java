package Hot100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsValidBST {

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

    public static boolean isValidBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                int left = node.left.val;
                if (node.val <= left) {
                    return false;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                int right = node.right.val;
                if (node.val >= right) {
                    return false;
                } else {
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }

    /**
     * 中序遍历，BST如果是中序遍历的话一定是升序，在遍历中比较前一个数和当前节点的数大小，如果当前节点的值小于上一个节点的值则不是BST
     * @param root
     * @return
     */
    public static boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        // 初始化一个比较的值，一个不可能的最小值，为了是第一个数据肯定能比较通过
        long comval = - Long.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            int val = node.val;
            if (comval >= val) {
                return false;
            }
            comval = val;
            root = node.right;
        }
        return true;
    }

    /**
     * 递归实现中序遍历
     * @param root
     * @return
     */
    // 设置一个比较变量，全局使用
    static long minVal = Long.MIN_VALUE;
    public static boolean isValidBST3(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 先遍历左子树，如果不符合BST就直接返回
        if (!isValidBST3(root.left)) {
            return false;
        }
        if (root.val <= minVal) {
            return false;
        }
        minVal = root.val;
        // 再遍历右子树
        return isValidBST3(root.right);

    }

    public static void main(String[] args) {
        // 输入：root = [2,1,3]
        // 输出：true
        // 输入：root = [5,1,4,null,null,3,6]
        // 输出：false
        // 解释：根节、点的值是 5 ，但是右子节点的值是 4 。
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        //System.out.println(IsValidBST.isValidBST(root));
        //System.out.println(IsValidBST.isValidBST2(root));
        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        //System.out.println(IsValidBST.isValidBST(root));
        //System.out.println(IsValidBST.isValidBST2(root));
        root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        //System.out.println(IsValidBST.isValidBST2(root));
        root = new TreeNode(-2147483648);
        //System.out.println(IsValidBST.isValidBST2(root));
        root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(IsValidBST.isValidBST2(root));
        System.out.println(IsValidBST.isValidBST3(root));
    }


}
