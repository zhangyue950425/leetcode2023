package binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 105
 */
public class BuildTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<Integer, Integer> indexValMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexValMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int index = indexValMap.get(preorder[preLeft]);
        int leftSize = index - inLeft;
        TreeNode root = new TreeNode(preorder[preLeft]);
        root.left = buildTree(preorder, preLeft + 1, preLeft + leftSize,
                inorder, inLeft, index - 1);
        root.right = buildTree(preorder, preLeft + leftSize + 1, preRight,
                inorder, index + 1, inRight);
        return root;
    }
}
